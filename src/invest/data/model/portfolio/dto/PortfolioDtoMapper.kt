package invest.data.model.portfolio.dto

import invest.data.model.portfolio.dbo.PortfolioItemDbo

object PortfolioDtoMapper {

    fun map(portfolioItemDbo: PortfolioItemDbo): PortfolioItemDto {
        return PortfolioItemDto(
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