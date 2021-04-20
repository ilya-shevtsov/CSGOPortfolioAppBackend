package invest

import data.api.ApiTools
import data.model.marketoverview.MarketOverviewDtoMapper
import domain.model.marketoverview.MarketOverview
import invest.data.model.DailySellHistoryDto
import invest.data.model.SellHistoryDto
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retryWhen

class SellHistoryRepository {

    val sellHistoryDto = SellHistoryDto(
        success = true,
        pricePrefix = "",
        priceSuffix = "pуб.",
        prices = listOf(
            DailySellHistoryDto(
                date = "Feb 16 2018 01: +0",
                price = 678.837,
                volume = "58774"
            )
        )
    )

    suspend fun getSellHistoryOverview(caseName: String): Flow<MarketOverview> = flow {
        val response = ApiTools.getSellHistoryApiService()
            .getData()

//        val sellHistoryDto = MarketOverviewDtoMapper.map(response)
//        emit(marketOverviewDto)
    }
}


