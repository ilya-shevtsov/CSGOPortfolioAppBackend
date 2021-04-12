package domain.usecase

import domain.repository.CaseRepository
import kotlinx.coroutines.flow.Flow
import data.model.MarketOverviewDto

class GetMarketOverviewUseCase (
    private val caseRepository:CaseRepository
){
    suspend fun getMarketOverviewUseCase(caseName: String): Flow<MarketOverviewDto> {
        return caseRepository.getMarketOverview(caseName)
    }
}