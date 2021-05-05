package overview.domain.usecase

import overview.domain.model.marketoverview.MarketOverview
import overview.data.repository.DatabaseRepository

class SaveMarketOverviewUseCase(
    private val databaseRepository: DatabaseRepository
) {
    fun saveMarketOverviewUseCase(caseId: Int, marketOverviewDto: MarketOverview) {
        return databaseRepository.saveMarketOverview(caseId, marketOverviewDto)
    }
}