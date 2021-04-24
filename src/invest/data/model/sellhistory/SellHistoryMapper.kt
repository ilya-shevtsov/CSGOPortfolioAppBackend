package invest.data.model.sellhistory

import invest.domain.DailySellHistory
import invest.serializer.invest.data.model.sellhistory.SellHistoryDto

object SellHistoryMapper {

    fun map(sellHistoryDto: SellHistoryDto): List<DailySellHistory> {

        val pricesList = sellHistoryDto.prices
        return pricesList.map { dailyData ->
            DailySellHistory(
                date = dailyData.date,
                price = dailyData.price,
                volume = dailyData.volume
            )
        }
    }
}
