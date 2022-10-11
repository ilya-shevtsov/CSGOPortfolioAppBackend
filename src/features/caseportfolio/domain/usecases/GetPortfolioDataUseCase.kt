package features.caseportfolio.domain.usecases

import features.caseportfolio.data.entities.PortfolioItemDto
import features.caseportfolio.domain.PortfolioRepository
import javax.inject.Inject

class GetPortfolioDataUseCase @Inject constructor(
    private val portfolioRepository: PortfolioRepository
) {
    operator fun invoke(): List<PortfolioItemDto> {
        return portfolioRepository.getPortfolioData()
    }
}