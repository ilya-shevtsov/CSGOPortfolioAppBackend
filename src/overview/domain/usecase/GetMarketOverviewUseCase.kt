package overview.domain.usecase

import overview.domain.repository.CaseRepository
import kotlinx.coroutines.flow.Flow
import overview.domain.model.marketoverview.MarketOverview
import kotlinx.serialization.ExperimentalSerializationApi

class GetMarketOverviewUseCase(
    private val caseRepository: CaseRepository
) {
    @ExperimentalSerializationApi
    suspend fun getMarketOverviewUseCase(caseName: String): Flow<MarketOverview> {
        return caseRepository.getMarketOverview(caseName)
    }
}