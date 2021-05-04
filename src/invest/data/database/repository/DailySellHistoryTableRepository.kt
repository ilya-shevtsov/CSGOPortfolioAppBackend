package invest.data.database.repository

import invest.data.database.table.sellhistory.CaseSellHistoryStorage.getPriceListQuery
import invest.data.database.table.sellhistory.CaseSellHistoryStorage.insertToCaseSellHistoryTable
import invest.data.database.table.sellhistory.CaseSellHistoryTable
import invest.data.model.dailysellhistory.Bdo.DailySellHistoryDbo
import invest.data.model.dailysellhistory.Bdo.DailySellHistoryDboMapper
import invest.data.model.sellhistory.SellHistoryDto
import invest.data.model.sellhistory.SellHistoryMapper
import invest.domain.model.CasePriceData
import invest.domain.model.DailySellHistory
import invest.domain.repository.MathRepository
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File
import java.sql.SQLException
import java.time.ZoneOffset

class DailySellHistoryTableRepository {
    private val mathRepository = MathRepository()

    val numberOfCaseId = (1..34).toList()

    fun prepareStandardDeviationResponse(): List<String> {
        val outputList = mutableListOf<String>()
        val casePriceDataList = getCasePriceDataList(numberOfCaseId)
        casePriceDataList.forEach { case ->
            val priceList = case.priceList
            val caseName = case.name
            val standardDeviation = mathRepository.getStandardDeviation(priceList)

            if (standardDeviation.isNaN()) {
                outputList.add("$caseName could not calculate, for more details check /Errors")
            } else {
                outputList.add("$caseName daily standard deviation is: $standardDeviation")
            }
        }
        return outputList
    }

//    fun getPriceListFromPriceData(){
//
//
//    }


    fun getCasePriceDataList(numberOfCaseId: List<Int>): List<CasePriceData> {
        val casePriceDataList = mutableListOf<CasePriceData>()
        numberOfCaseId.map { id ->
            casePriceDataList.add(getCasePriceData(id))
        }
        return casePriceDataList
    }

    private fun getCasePriceData(id: Int): CasePriceData {
        val list = mutableListOf<Double>()
        var case = CasePriceData("", emptyList())
        val query = getPriceListQuery()
        transaction {
            query.forEach {
                if (it[CaseSellHistoryTable.caseId] == id) {
                    list.add(it[CaseSellHistoryTable.price])
                    case = CasePriceData(
                        name = it[CaseSellHistoryTable.name],
                        priceList = list
                    )
                }
            }
        }
        return case
    }

    fun insertData() {
        val dailySellHistoryDboList = getDailySellHistoryDboList("resources/caseJson")
        for (dailySellHistoryDbo in dailySellHistoryDboList) {
            try {
                insertToCaseSellHistoryTable(dailySellHistoryDbo)
            } catch (e: SQLException) {
                continue
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
