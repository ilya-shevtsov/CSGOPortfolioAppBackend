package data.model.marketoverview

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarketOverviewDto(

    @SerialName("success")
    val success: Boolean,

    @SerialName("lowest_price")
    val lowestPrice: String,

    @SerialName("volume")
    val volume: String,

    @SerialName("median_price")
    val medianPrice: String,
)