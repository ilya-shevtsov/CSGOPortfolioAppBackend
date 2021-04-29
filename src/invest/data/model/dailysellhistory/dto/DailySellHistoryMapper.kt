package invest.data.model.dailysellhistory.dto

import invest.domain.model.DailySellHistory
import java.text.SimpleDateFormat
import java.util.*


object DailySellHistoryMapper {

    private val datePattern = SimpleDateFormat("MMM dd yyyy HH: +0", Locale.ENGLISH)


    fun map(dailySellHistoryDto: DailySellHistoryDto): DailySellHistory {
        return DailySellHistory(
            date = datePattern.parse(dailySellHistoryDto.date).toInstant(),
            price = dailySellHistoryDto.price,
            volume = dailySellHistoryDto.volume,
        )
    }
}