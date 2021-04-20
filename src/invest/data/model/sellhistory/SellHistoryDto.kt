package invest.data.model.sellhistory

import invest.data.model.dailysellhistory.DailySellHistoryDto
import kotlinx.serialization.Serializable

@Serializable
data class SellHistoryDto(
    val success: Boolean,
    val pricePrefix: String,
    val priceSuffix: String,
    val prices: List<DailySellHistoryDto>
)