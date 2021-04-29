package invest.data.model.dailysellhistory.dto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.time.Instant
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.TemporalAccessor


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class DailySellHistoryMapperTest{

    val datePattern = DateTimeFormatterBuilder()
        .appendPattern("MMM dd yyyy HH: +0")
        .toFormatter()

    @Test
    fun testMap() {
        val input = "Jan 09 2015 01: +0"
        val output = datePattern.parse(input) { temporal: TemporalAccessor? -> Instant.from(temporal) }
        assertEquals("f", output)
    }


}