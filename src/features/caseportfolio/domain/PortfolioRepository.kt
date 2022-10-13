package features.caseportfolio.domain

import features.caseportfolio.data.entities.portfolioitem.PortfolioItemDbo
import features.caseportfolio.data.entities.portfolioitem.PortfolioItemDto
import features.caseportfolio.domain.entities.PortfolioItem

interface PortfolioRepository {

    fun getPortfolioData(): List<PortfolioItem>

    fun insertInitialDataPortfolio()

    fun updatePortfolio(addedCase: PortfolioItemDbo)
}