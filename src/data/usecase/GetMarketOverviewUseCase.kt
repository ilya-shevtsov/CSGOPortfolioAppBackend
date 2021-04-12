package data.usecase

import domain.repository.CaseRepository
import kotlinx.coroutines.flow.Flow
import model.SimpleCaseDto

class GetMarketOverviewUseCase (
    private val caseRepository:CaseRepository
){
    suspend fun getMarketOverviewUseCase(caseName: String): Flow<SimpleCaseDto> {
        return caseRepository.getMarketOverview(caseName)
    }
}