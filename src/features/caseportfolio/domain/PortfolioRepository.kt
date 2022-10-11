package features.caseportfolio.domain

import features.caseportfolio.data.entities.PortfolioItemDbo
import features.caseportfolio.data.entities.PortfolioItemDto

interface PortfolioRepository {

    fun getPortfolioData(): List<PortfolioItemDto>

    fun insertInitialDataPortfolio()

    fun updatePortfolio(addedCase: PortfolioItemDbo)
}