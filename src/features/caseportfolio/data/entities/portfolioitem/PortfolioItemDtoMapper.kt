package features.caseportfolio.data.entities.portfolioitem

object PortfolioItemDtoMapper {

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