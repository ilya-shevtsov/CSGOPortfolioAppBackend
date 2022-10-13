package features.caseportfolio.domain.entities

import features.caseportfolio.data.entities.portfolioitem.PortfolioItemDbo

object PortfolioItemMapper {
    fun map(portfolioItemDbo: PortfolioItemDbo): PortfolioItem {
        return PortfolioItem(
            caseId = portfolioItemDbo.caseId,
            name = portfolioItemDbo.name,
            amount = portfolioItemDbo.amount,
            purchasePrice = portfolioItemDbo.purchasePrice,
            overallValue = portfolioItemDbo.overallValue,
            profitLoss = portfolioItemDbo.profitLoss,
            imageUrl = portfolioItemDbo.imageUrl
        )
    }
}