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
        val output = prepareSellHistoryList("resources/caseJson")
        assertEquals("f", output.drop(output.size-1))
    }

    private val mathRepository = MathRepository()

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

        val dailyPriceList = getDailySellHistoryList(parsedJson)
        val dailyPriceListFromHourly = toDailyListFromHourly(getDailyFromHourlySellHistoryList(parsedJson))

        return (dailyPriceList + dailyPriceListFromHourly)
    }

    private fun toDailyListFromHourly(hourlyDayList: List<List<DailySellHistory>>): MutableList<DailySellHistory> {
        val hourlyPriceList = mutableListOf<DailySellHistory>()
        hourlyDayList.map { day ->
            day.map { hour ->
                if (hour.date.atZone(ZoneOffset.UTC).hour == 1) {
                    hourlyPriceList.add(hour)
                }
            }
        }
        return hourlyPriceList
    }


    private fun handleFilePath(file: File): String {
        val filePath = file.toString()
            .replace("resources\\", "")
            .replace("""\""", "/")
        return "/$filePath"
    }

    private fun getDailyFromHourlySellHistoryList(parsedJson: SellHistoryDto) =
        SellHistoryMapper.map(parsedJson).takeLast(720).chunked(24)

    private fun getDailySellHistoryList(parsedJson: SellHistoryDto) =
        SellHistoryMapper.map(parsedJson).dropLast(725)

    private fun getResourceDirectory(path: String): String {
        return object {}.javaClass.getResource(path).readText()
    }

}