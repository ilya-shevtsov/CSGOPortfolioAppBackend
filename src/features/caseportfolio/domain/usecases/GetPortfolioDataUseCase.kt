package features.caseportfolio.domain.usecases

import features.caseportfolio.domain.PortfolioRepository
import features.caseportfolio.domain.entities.PortfolioItem
import javax.inject.Inject

class GetPortfolioDataUseCase @Inject constructor(
    private val portfolioRepository: PortfolioRepository
) {
    operator fun invoke(): List<PortfolioItem> {
        return portfolioRepository.getPortfolioData()
    }
}