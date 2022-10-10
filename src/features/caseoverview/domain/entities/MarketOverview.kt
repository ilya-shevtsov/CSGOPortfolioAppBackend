package features.caseoverview.domain.entities

data class MarketOverview(
    val name: String,
    val lowestPrice: Double,
    val volume: Int,
    val medianPrice: Double,
)