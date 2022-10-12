package features.caseportfolio.domain

import features.caseportfolio.data.entities.portfolioitem.PortfolioItemDbo
import features.caseportfolio.data.entities.portfolioitem.PortfolioItemDto

interface PortfolioRepository {

    fun getPortfolioData(): List<PortfolioItemDto>

    fun insertInitialDataPortfolio()

    fun updatePortfolio(addedCase: PortfolioItemDbo)
}