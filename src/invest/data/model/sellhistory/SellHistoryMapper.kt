package invest.data.model.sellhistory

import invest.domain.DailySellHistory

object SellHistoryMapper {

    fun map(sellHistoryDto: SellHistoryDto, ): List<DailySellHistory> {

        val pricesList = sellHistoryDto.prices
        return pricesList.map { dailyData ->
            DailySellHistory(
                date = dailyData[0],
                price = dailyData[1].toDouble(),
                volume = dailyData[2]
            )
        }
    }
}
