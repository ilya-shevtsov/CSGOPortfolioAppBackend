package features.caseanalytics.data.entities

import features.caseanalytics.domain.entities.DailySellHistory

object SellHistoryMapper {

    fun map(sellHistoryDto: SellHistoryDto): List<DailySellHistory> {

        val pricesList = sellHistoryDto.prices
        return pricesList.map { dailyData ->
            DailySellHistoryMapper.map(dailyData)
        }
    }
}
