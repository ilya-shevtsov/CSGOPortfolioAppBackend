package features.caseoverview.domain.usecases

import features.caseoverview.data.DatabaseRepository
import features.caseoverview.domain.entities.MarketOverview

class SaveMarketOverviewUseCase(
    private val databaseRepository: DatabaseRepository
) {
    fun saveMarketOverviewUseCase(caseId: Int, marketOverviewDto: MarketOverview) {
        return databaseRepository.saveMarketOverview(caseId, marketOverviewDto)
    }
}