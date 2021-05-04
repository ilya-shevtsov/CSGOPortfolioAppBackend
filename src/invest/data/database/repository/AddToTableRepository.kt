package invest.data.database.repository

import invest.data.database.table.sellhistory.CaseSellHistoryStorage.insertToCaseSellHistoryTable
import invest.data.model.dailysellhistory.Bdo.DailySellHistoryDbo
import invest.data.model.dailysellhistory.Bdo.DailySellHistoryDboMapper
import invest.data.model.sellhistory.SellHistoryDto
import invest.data.model.sellhistory.SellHistoryMapper
import invest.domain.model.DailySellHistory
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File
import java.time.ZoneOffset

class AddToTableRepository {




    fun insertPriceTableData() {
        val dailySellHistoryDboList = getDailySellHistoryDboList("resources/caseJson")
        dailySellHistoryDboList.forEach { dailySellHistoryDbo ->
            insertToCaseSellHistoryTable(dailySellHistoryDbo)
        }
    }

    fun getDailySellHistoryDboList(resourcePath: String): MutableList<DailySellHistoryDbo> {
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
