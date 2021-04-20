package invest.data.model

import invest.domain.DailySellHistory

object DailySellHistoryMapper {

    fun map(dailySellHistoryDto: DailySellHistoryDto):List<String> {
        return dailySellHistoryDto.date.split(" ")
    }
}