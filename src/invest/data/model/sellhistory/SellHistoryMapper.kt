package invest.data.model.sellhistory

import invest.data.model.dailysellhistory.DailySellHistoryMapper
import invest.domain.model.DailySellHistory

object SellHistoryMapper {

    fun map(sellHistoryDto: SellHistoryDto): List<DailySellHistory> {

        val pricesList = sellHistoryDto.prices
        return pricesList.map { dailyData ->
            DailySellHistoryMapper.map(dailyData)
        }
    }
}
