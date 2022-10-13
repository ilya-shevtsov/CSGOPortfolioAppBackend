package features.caseanalytics.data

import features.caseanalytics.data.tables.CaseSellHistoryStorage.getDailyCasePriceData
import features.caseanalytics.data.tables.CaseSellHistoryStorage.getMonthlyCasePriceData
import features.caseanalytics.data.tables.CaseSellHistoryStorage.insertToCaseSellHistoryTable
import features.caseanalytics.data.entities.sellhistory.DailySellHistoryDbo
import features.caseanalytics.data.entities.sellhistory.DailySellHistoryDboMapper
import features.caseanalytics.data.entities.sellhistory.SellHistoryDto
import features.caseanalytics.data.entities.sellhistory.SellHistoryMapper
import features.caseanalytics.domain.entities.CasePriceData
import features.caseanalytics.domain.entities.DailySellHistory
import features.caseanalytics.domain.MathRepository
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File
import java.sql.SQLException
import java.time.ZoneOffset
import javax.inject.Inject

class DailySellHistoryTableRepository@Inject constructor() {
    private val mathRepository = MathRepository()


    val numberOfCaseId = (1..34).toList()
//    val numberOfCaseId = listOf(21)

    fun prepareAvgReturn(period: Int, averageReturnType: Int): List<String> {
        val outputList = mutableListOf<String>()
        val casePriceDataList = getCasePriceDataList(period, numberOfCaseId)
        casePriceDataList.forEach { case ->
            val priceList = case.priceList
            val caseName = case.name
            val averageReturn = mathRepository.getAverageReturn(priceList, averageReturnType)

            if (averageReturn.isNaN()) {
                outputList.add("$caseName could not calculate, for more details check /Errors")
            } else {
                when (period to averageReturnType) {
                    Pair(30, 1) -> outputList.add("$caseName monthly standard deviation in % is: $averageReturn")
                    Pair(30, 2) -> outputList.add("$caseName monthly standard deviation in RUB is: $averageReturn")
                    Pair(1, 1) -> outputList.add("$caseName daily standard deviation in % is: $averageReturn")
                    Pair(1, 2) -> outputList.add("$caseName daily standard deviation in RUB is: $averageReturn")
                }
            }
        }
        return outputList
    }

    fun prepareStandardDeviationResponse(period: Int): List<String> {
        val outputList = mutableListOf<String>()
        val casePriceDataList = getCasePriceDataList(period, numberOfCaseId)
        casePriceDataList.forEach { case ->
            val priceList = case.priceList
            val caseName = case.name
            val standardDeviation = mathRepository.getStandardDeviation(priceList)

            if (standardDeviation.isNaN()) {
                outputList.add("$caseName could not calculate, for more details check /Errors")
            } else {
                when (period) {
                    30 -> outputList.add("$caseName monthly standard deviation is: $standardDeviation")
                    1 -> outputList.add("$caseName daily standard deviation is: $standardDeviation")
                }
            }
        }
        return outputList
    }

    fun prepareSharpRatioResponse(period: Int): List<String> {
        val outputList = mutableListOf<String>()
        val casePriceDataList = getCasePriceDataList(period, numberOfCaseId)
        casePriceDataList.forEach { case ->
            val priceList = case.priceList
            val caseName = case.name
            val sharpRatio = mathRepository.getSharpRatio(priceList)

            if (sharpRatio.isNaN()) {
                outputList.add("$caseName could not calculate, for more details check /Errors")
            } else {
                when (period) {
                    30 -> outputList.add("$caseName monthly sharp Ratio is: $sharpRatio")
                    1 -> outputList.add("$caseName daily sharp Ratio is: $sharpRatio")
                }
            }
        }
        return outputList
    }

    fun getCasePriceDataList(period: Int, numberOfCaseId: List<Int>): List<CasePriceData> {
        val casePriceDataList = mutableListOf<CasePriceData>()
        numberOfCaseId.map { id ->
            if (period == 1) {
                casePriceDataList.add(getDailyCasePriceData(id))
            }
            if (period == 30) {
                casePriceDataList.add(getMonthlyCasePriceData(id))
            }
        }
        return casePriceDataList
    }

    fun insertDailySellHistoryData() {
        transaction {
            val dailySellHistoryDboList = getDailySellHistoryDboList("resources/caseJson")
            for (dailySellHistoryDbo in dailySellHistoryDboList) {
                try {
                    insertToCaseSellHistoryTable(dailySellHistoryDbo)
                } catch (e: SQLException) {
                    continue
                }
            }
        }
    }

    private fun getDailySellHistoryDboList(resourcePath: String): MutableList<DailySellHistoryDbo> {
        val dailySellHistoryDboList = mutableListOf<DailySellHistoryDbo>()
        val resourceList = File(resourcePath).walk().toMutableList().drop(1)
        resourceList.forEach { file ->
            val filePath = handleFilePath(file)
            val caseName = handleFileName(filePath)
            getDailySellHistoryFromJson(filePath).map { dailySellHistory ->
                val dailySellHistoryDbo = DailySellHistoryDboMapper
                    .map(caseName, dailySellHistory)
                dailySellHistoryDboList.add(dailySellHistoryDbo)
            }
        }
        return dailySellHistoryDboList
    }

    private fun getDailySellHistoryFromJson(jsonPath: String): List<DailySellHistory> {
        val jsonFileText = getResourceDirectory(jsonPath)
        val parsedJson: SellHistoryDto = Json.decodeFromString(jsonFileText)
        val dailySellHistoryData = SellHistoryMapper.map(parsedJson)
        return getDailySellHistoryList(dailySellHistoryData)
    }

    private fun getDailySellHistoryList(dailySellHistoryData: List<DailySellHistory>): MutableList<DailySellHistory> {
        val dailySellHistoryList = mutableListOf<DailySellHistory>()
        dailySellHistoryData.map { day ->
            if (day.date.atZone(ZoneOffset.UTC).hour == 1) {
                dailySellHistoryList.add(day)
            }
        }
        return dailySellHistoryList
    }

    private fun handleFileName(filePath: String): String {
        return filePath
            .replace(".json", "")
            .replace("caseJson/", "")
            .replace("/", "")
    }

    private fun handleFilePath(file: File): String {
        val filePath = file.toString()
            .replace("resources\\", "")
            .replace("""\""", "/")
        return "/$filePath"
    }

    private fun getResourceDirectory(path: String): String {
        return object {}.javaClass.getResource(path).readText()
    }
}
