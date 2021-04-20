package data.api

import data.model.marketoverview.MarketOverviewDto
import invest.data.model.sellhistory.SellHistoryDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ServerApi {

    @GET("priceoverview/")
    suspend fun getCase(
        @Query("appid") appId: Long,

        @Query("currency") currency: Int,

        @Query(value = "market_hash_name", encoded = true) caseName: String

    ): MarketOverviewDto
}