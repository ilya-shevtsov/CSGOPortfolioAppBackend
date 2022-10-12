package features.caseportfolio.data.entities.portfolioitem

data class PortfolioItemDbo(
    val caseId: Int,
    val name: String,
    val amount: Int,
    val purchasePrice: Double,
    val overallValue: Double,
    val profitLoss: Double,
    val imageUrl: String
)