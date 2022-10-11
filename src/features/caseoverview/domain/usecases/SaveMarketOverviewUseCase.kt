package features.caseoverview.domain.usecases

import features.caseoverview.domain.CaseRepository
import features.caseoverview.domain.entities.MarketOverview
import javax.inject.Inject

class SaveMarketOverviewUseCase @Inject constructor(
    private val caseRepository: CaseRepository
) {
    operator fun invoke(caseId: Int, marketOverviewDto: MarketOverview) {
        return caseRepository.saveMarketOverview(caseId, marketOverviewDto)
    }
}