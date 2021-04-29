package invest.data.database.repository

import invest.data.model.sellhistory.SellHistoryDto
import invest.data.model.sellhistory.SellHistoryMapper
import invest.domain.model.DailySellHistory
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File
import java.time.ZoneOffset

class AddToTableRepository {

    fun getDailySellHistoryFromResource(resourcePath: String): MutableList<List<DailySellHistory>> {
        val output = mutableListOf<List<DailySellHistory>>()
        val resourceList = File(resourcePath).walk().toMutableList().drop(1)
        resourceList.forEach { file ->
            val filePath = handleFilePath(file)
            output.add(getDailySellHistoryFromJson(filePath))
        }
        return output
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
