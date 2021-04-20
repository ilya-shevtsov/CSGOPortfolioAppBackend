package invest.data.model.sellhistory

import invest.data.model.dailysellhistory.DailySellHistoryMapper
import invest.domain.DailySellHistory

object SellHistoryMapper {

    fun map(
        sellHistoryDto: SellHistoryDto,
    ): List<DailySellHistory> {

        val sellHistoryDtoList = sellHistoryDto.prices
        val sellHistoryList = sellHistoryDtoList.map { day ->
            DailySellHistoryMapper.map(day)
        }
        return sellHistoryList
    }
}