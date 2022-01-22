package overview.domain.model.marketoverview

import kotlinx.serialization.Serializable

@Serializable
data class MarketOverview(
    val name: String,
    val lowestPrice: Double,
    val volume: Int,
    val medianPrice: Double,
)