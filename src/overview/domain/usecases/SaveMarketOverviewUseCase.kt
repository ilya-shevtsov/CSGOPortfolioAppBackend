package overview.domain.usecases

import overview.data.DatabaseRepository
import overview.domain.entities.MarketOverview

class SaveMarketOverviewUseCase(
    private val databaseRepository: DatabaseRepository
) {
    fun saveMarketOverviewUseCase(caseId: Int, marketOverviewDto: MarketOverview) {
        return databaseRepository.saveMarketOverview(caseId, marketOverviewDto)
    }
}