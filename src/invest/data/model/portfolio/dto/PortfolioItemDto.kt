package invest.data.model.portfolio.dto

import kotlinx.serialization.Serializable

@Serializable
data class PortfolioItemDto(
    val name: String,
    val amount: Int,
    val purchasePrice: Double,
    val overallValue: Double,
    val profitLoss: Double,
    val imageUrl: String
)
