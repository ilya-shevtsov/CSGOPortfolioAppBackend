package invest.data.model.dailysellhistory.dto

import invest.domain.model.DailySellHistory
import java.time.Instant
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.TemporalAccessor


object DailySellHistoryMapper {

    val datePattern = DateTimeFormatterBuilder()
        .appendPattern("MMM dd yyyy HH: +0")
        .toFormatter()


    fun map(dailySellHistoryDto: DailySellHistoryDto): DailySellHistory {
        return DailySellHistory(
            date = datePattern.parse(dailySellHistoryDto.date) { temporal: TemporalAccessor? -> Instant.from(temporal) },
            price = dailySellHistoryDto.price,
            volume = dailySellHistoryDto.volume,
        )
    }
}