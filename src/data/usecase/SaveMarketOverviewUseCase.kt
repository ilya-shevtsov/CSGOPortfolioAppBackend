package data.usecase

import data.model.MarketOverviewDto
import data.repository.DatabaseRepository

class SaveMarketOverviewUseCase(
    private val databaseRepository: DatabaseRepository
) {
    fun saveMarketOverviewUseCase(caseId: Int, marketOverviewDto: MarketOverviewDto) {
        return databaseRepository.saveMarketOverview(caseId, marketOverviewDto)
    }
}