package invest.domain.repository

import invest.data.model.sellhistory.SellHistoryDto
import invest.data.model.sellhistory.SellHistoryMapper
import invest.domain.model.DailySellHistory
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.*
import org.junit.jupiter.api.TestInstance
import java.io.File
import java.time.ZoneOffset

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class SellHistoryRepositoryTest {

    @Test
    fun testGetParsedJson() {
        val output = prepareSellHistoryList("resources/test")
        assertEquals("f", output)
    }

    fun prepareSellHistoryList(resourcePath: String): MutableList<List<DailySellHistory>> {
        val output = mutableListOf<List<DailySellHistory>>()
        val resourceList = File(resourcePath).walk().toMutableList().drop(1)
        resourceList.forEach { file ->
            val filePath = handleFilePath(file)
            output.add(getDailySellHistoryClassListOutPut(filePath))
        }
        return output
    }

    private fun getDailySellHistoryClassListOutPut(jsonPath: String): List<DailySellHistory> {
        val jsonFileText = getResourceDirectory(jsonPath)
        val parsedJson: SellHistoryDto = Json.decodeFromString(jsonFileText)
        val dailySellHistoryClassList = getDailySellHistoryClassList(parsedJson)
        return dailySellHistoryClassList
    }


    private fun getDailySellHistoryClassList(
        parsedJson: SellHistoryDto,
    ): List<DailySellHistory> {

        val dailyPriceList = getDailySellHistoryList(SellHistoryMapper.map(parsedJson))

        return dailyPriceList
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