package invest


import data.api.ApiTools
import invest.data.model.dailysellhistory.DailySellHistoryDto
import invest.data.model.sellhistory.SellHistoryDto
import invest.data.model.sellhistory.SellHistoryMapper
import invest.domain.DailySellHistory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow



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

    suspend fun getSellHistoryOverview(): Flow<List<DailySellHistory>> = flow {
        val response = ApiTools.getCaseApiService()
            .getSellHistory(
                country = "US",
                appId = 730,
                currency = 5,
                caseName = "Clutch%20Case"
            )
        println("getSellHistoryOverview: $response")
        val sellHistoryDto = SellHistoryMapper.map(response)
        println(sellHistoryDto)

        emit(sellHistoryDto)
    }

    suspend fun getSellHistoryOverviewResponse(): List<DailySellHistory> {
        val sellHistoryOverviewFlow = getSellHistoryOverview()
        println(sellHistoryOverviewFlow)
        var haha: List<DailySellHistory> = emptyList()
        sellHistoryOverviewFlow.collect { case ->
            haha = case
        }
        println(haha)
        return haha
    }
}


