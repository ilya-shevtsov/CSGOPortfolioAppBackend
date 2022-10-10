package invest.data.entities

import invest.data.entities.PortfolioItemDbo
import invest.data.entities.PortfolioItemDto

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