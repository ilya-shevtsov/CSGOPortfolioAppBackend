package invest.serializer

import invest.data.model.dailysellhistory.DailySellHistoryDto
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.intellij.lang.annotations.Language
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DailySellHistorySerializerTest {

    @Test
    fun test() {

        val dailySellHistoryList = listOf<DailySellHistoryDto>(
            DailySellHistoryDto(
                date = "Feb 16 2018 01: +0",
                price = 682.81,
                volume = 58774
            ),
            DailySellHistoryDto(
                date = "Feb 17 2018 01: +0",
                price = 388.74,
                volume = 67111
            )
        )

        @Language("json")
        val dailySellHistoryJSON = """
        [["Feb 16 2018 01: +0","682.81","58774"],["Feb 17 2018 01: +0","388.74","67111"]]
    """.trimIndent()

        val serializedDSHL = Json.encodeToString(dailySellHistoryList)
        val deserializedDSHL = Json.decodeFromString<List<DailySellHistoryDto>>(dailySellHistoryJSON)

        assertEquals(dailySellHistoryJSON, serializedDSHL)
        assertEquals(dailySellHistoryList, deserializedDSHL)
    }
}