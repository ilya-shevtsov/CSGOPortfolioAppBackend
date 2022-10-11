package features.caseportfolio.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class PortfolioItemDto(
    val caseId: Int,
    val name: String,
    val amount: Int,
    val purchasePrice: Double,
    val overallValue: Double,
    val profitLoss: Double,
    val imageUrl: String
)
