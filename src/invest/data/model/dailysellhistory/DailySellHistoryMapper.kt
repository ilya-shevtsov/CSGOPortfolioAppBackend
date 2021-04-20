package invest.data.model.dailysellhistory

import invest.domain.DailySellHistory

object DailySellHistoryMapper {

    fun map(dailySellHistoryDto: DailySellHistoryDto):DailySellHistory {

        val newDate = dailySellHistoryDto.date

        val newPrice = dailySellHistoryDto.price

        val newVolume = dailySellHistoryDto.volume

        return DailySellHistory(
            date = newDate,
            price = newPrice,
            volume = newVolume
        )
    }
}