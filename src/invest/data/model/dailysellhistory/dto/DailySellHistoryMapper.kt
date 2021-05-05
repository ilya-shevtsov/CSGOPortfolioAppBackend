package invest.data.model.dailysellhistory.dto

import invest.domain.model.dailysellhistory.DailySellHistory
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

object DailySellHistoryMapper {

    fun map(dailySellHistoryDto: DailySellHistoryDto): DailySellHistory {
        return DailySellHistory(
            date = LocalDateTime.parse(
                dailySellHistoryDto.date,
                DateTimeFormatter.ofPattern("MMM dd yyyy HH: +0", Locale.ENGLISH)
            ).toInstant(ZoneOffset.UTC),
            price = dailySellHistoryDto.price,
            volume = dailySellHistoryDto.volume,
        )
    }
}