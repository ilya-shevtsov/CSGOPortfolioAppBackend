package features.caseoverview.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.ExperimentalSerializationApi
import features.caseoverview.domain.CaseRepository
import features.caseoverview.domain.entities.MarketOverview

class GetMarketOverviewUseCase(
    private val caseRepository: CaseRepository
) {
    @ExperimentalSerializationApi
    suspend fun getMarketOverviewUseCase(caseName: String,currency: Int): Flow<MarketOverview> {
        return caseRepository.getMarketOverview(caseName,currency)
    }
}