package invest.data.model.sellhistory

import invest.data.model.dailysellhistory.dto.DailySellHistoryMapper
import invest.domain.model.dailysellhistory.DailySellHistory

object SellHistoryMapper {

    fun map(sellHistoryDto: SellHistoryDto): List<DailySellHistory> {

        val pricesList = sellHistoryDto.prices
        return pricesList.map { dailyData ->
            DailySellHistoryMapper.map(dailyData)
        }
    }
}
