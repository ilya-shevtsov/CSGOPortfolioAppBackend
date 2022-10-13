package features.caseportfolio.domain.entities

data class PortfolioItem(
    val caseId: Int,
    val name: String,
    val amount: Int,
    val purchasePrice: Double,
    val overallValue: Double,
    val profitLoss: Double,
    val imageUrl: String
)
