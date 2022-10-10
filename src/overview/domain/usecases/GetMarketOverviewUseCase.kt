package overview.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.ExperimentalSerializationApi
import overview.domain.CaseRepository
import overview.domain.entities.MarketOverview

class GetMarketOverviewUseCase(
    private val caseRepository: CaseRepository
) {
    @ExperimentalSerializationApi
    suspend fun getMarketOverviewUseCase(caseName: String,currency: Int): Flow<MarketOverview> {
        return caseRepository.getMarketOverview(caseName,currency)
    }
}