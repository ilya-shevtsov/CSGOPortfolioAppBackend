package invest.data.model.dailysellhistory

import invest.domain.model.DailySellHistory
import java.text.SimpleDateFormat
import java.util.*

object DailySellHistoryMapper {

    fun map(dailySellHistoryDto: DailySellHistoryDto): DailySellHistory {

        val datePattern = SimpleDateFormat("MMM dd yyyy HH: +0", Locale.ENGLISH)

        return DailySellHistory(
            date = datePattern.parse(dailySellHistoryDto.date),
            price = dailySellHistoryDto.price,
            volume = dailySellHistoryDto.volume,
        )
    }
}