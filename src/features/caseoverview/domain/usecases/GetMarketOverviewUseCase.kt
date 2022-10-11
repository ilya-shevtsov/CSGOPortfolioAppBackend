package features.caseoverview.domain.usecases

import features.caseoverview.domain.CaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.ExperimentalSerializationApi
import features.caseoverview.domain.entities.MarketOverview
import javax.inject.Inject

class GetMarketOverviewUseCase @Inject constructor(
    private val caseRepository: CaseRepository
) {
    @ExperimentalSerializationApi
    suspend operator fun invoke(caseName: String, currency: Int): Flow<MarketOverview> {
        return caseRepository.getMarketOverview(caseName, currency)
    }
}