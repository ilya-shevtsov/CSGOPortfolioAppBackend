package features.caseportfolio.domain.usecases

import features.caseportfolio.domain.PortfolioRepository
import javax.inject.Inject

class InsertInitialDataPortfolioUseCase @Inject constructor(
    private val portfolioRepository: PortfolioRepository
) {
    operator fun invoke() {
        return portfolioRepository.insertInitialDataPortfolio()
    }
}
