package invest.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SellHistoryDto(
    val success: Boolean,
    val pricePrefix: String,
    val priceSuffix: String,
    val prices: List<DailySellHistoryDto>
)