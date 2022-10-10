package invest.data.entities

import invest.domain.DailySellHistory

object SellHistoryMapper {

    fun map(sellHistoryDto: SellHistoryDto): List<DailySellHistory> {

        val pricesList = sellHistoryDto.prices
        return pricesList.map { dailyData ->
            DailySellHistoryMapper.map(dailyData)
        }
    }
}
