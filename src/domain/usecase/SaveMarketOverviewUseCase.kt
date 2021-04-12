package domain.usecase

import domain.model.MarketOverview
import data.repository.DatabaseRepository

class SaveMarketOverviewUseCase(
    private val databaseRepository: DatabaseRepository
) {
    fun saveMarketOverviewUseCase(caseId: Int, marketOverviewDto: MarketOverview) {
        return databaseRepository.saveMarketOverview(caseId, marketOverviewDto)
    }
}