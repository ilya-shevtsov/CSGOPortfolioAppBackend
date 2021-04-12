package data.usecase

import data.repository.DatabaseRepository
import domain.repository.CaseRepository
import domain.usecase.GetMarketOverviewUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect

class UpdateInfoUseCase (
    private val caseRepository: CaseRepository,
    private val databaseRepository: DatabaseRepository
){
    private val getCaseListUseCase = GetCaseListUseCase(databaseRepository)
    private val getMarketOverviewUseCase = GetMarketOverviewUseCase(caseRepository)

    suspend fun updateInfo() {
        val caseList = getCaseListUseCase.getCaseList()
        caseList.forEach { case ->
            getMarketOverviewUseCase.getMarketOverviewUseCase(case.caseAccess)
                .catch { println("Error") }
                .collect { marketOverviewDto ->
                    databaseRepository.saveMarketOverview(case.id, marketOverviewDto)
                }
        }
    }
}