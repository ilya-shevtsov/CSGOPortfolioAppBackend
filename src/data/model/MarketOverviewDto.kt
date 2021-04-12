package data.model

import kotlinx.serialization.Serializable

@Serializable
data class MarketOverviewDto(
    val name: String,
    val lowestPrice: Double,
    val volume: Int,
    val medianPrice: Double,
)