package features.caseportfolio.domain

import features.caseportfolio.data.entities.PortfolioItemDto

interface PortfolioRepository {

    fun getPortfolioData(): List<PortfolioItemDto>

}