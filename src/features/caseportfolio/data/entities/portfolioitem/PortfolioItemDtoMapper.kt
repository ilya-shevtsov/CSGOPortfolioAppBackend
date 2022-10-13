package features.caseportfolio.data.entities.portfolioitem

import features.caseportfolio.domain.entities.PortfolioItem

object PortfolioItemDtoMapper {

    fun map(portfolioItem: PortfolioItem): PortfolioItemDto {
        return PortfolioItemDto(
            caseId = portfolioItem.caseId,
            name = portfolioItem.name,
            amount = portfolioItem.amount,
            purchasePrice = portfolioItem.purchasePrice,
            overallValue = portfolioItem.overallValue,
            profitLoss = portfolioItem.profitLoss,
            imageUrl = portfolioItem.imageUrl
        )
    }
}