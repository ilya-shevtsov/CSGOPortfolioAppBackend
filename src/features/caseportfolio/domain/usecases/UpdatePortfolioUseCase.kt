package features.caseportfolio.domain.usecases

import features.caseportfolio.data.entities.PortfolioItemDbo
import features.caseportfolio.domain.PortfolioRepository
import javax.inject.Inject

class UpdatePortfolioUseCase @Inject constructor(
    private val portfolioRepository: PortfolioRepository
) {
    operator fun invoke(addedCase: PortfolioItemDbo){
       return portfolioRepository.updatePortfolio(addedCase)
    }
}