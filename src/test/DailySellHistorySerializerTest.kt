package invest.serializer


import invest.serializer.invest.data.model.dailysellhistory.DailySellHistoryDto
import invest.serializer.invest.data.model.sellhistory.SellHistoryDto
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.intellij.lang.annotations.Language
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DailySellHistorySerializerTest {

    @Test
    fun test() {

        val dailySellHistoryDtoNewList =
            SellHistoryDto(
                success = true,
                pricePrefix = "",
                priceSuffix = "rub",
                prices = listOf(
                    DailySellHistoryDto(
                        date = "Feb 16 2018 01: +0",
                        price = 682.81,
                        volume = 58774,
                    )
                )
            )

        @Language("json")
        val jsonString = """{
  "success":true,
  "price_prefix":"",
  "price_suffix":"rub",
  "prices":[["Feb 16 2018 01: +0",682.81,"58774"]]}
  """.trimIndent().replace("\n","")

        val decoded = Json.decodeFromString<SellHistoryDto>(jsonString)

        assertEquals(dailySellHistoryDtoNewList, decoded)
    }
}