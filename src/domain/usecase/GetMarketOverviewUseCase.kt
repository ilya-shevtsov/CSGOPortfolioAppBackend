package domain.usecase

import domain.repository.CaseRepository
import kotlinx.coroutines.flow.Flow
import domain.model.marketoverview.MarketOverview

class GetMarketOverviewUseCase(
    private val caseRepository: CaseRepository
) {
    suspend fun getMarketOverviewUseCase(caseName: String): Flow<MarketOverview> {
        return caseRepository.getMarketOverview(caseName)
    }
}