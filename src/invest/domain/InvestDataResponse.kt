package invest.domain

import kotlinx.serialization.Serializable

@Serializable
data class InvestDataResponse(
    val success: Boolean,
    val pricePrefix: String,
    val priceSuffix: String,
    val prices: List<DailySellData>
)