package overview.domain.usecase

import core.preferredCurrency
import overview.data.repository.DatabaseRepository
import overview.domain.repository.CaseRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.serialization.ExperimentalSerializationApi

class UpdateInfoUseCase(
    caseRepository: CaseRepository,
    databaseRepository: DatabaseRepository
) {

    private val getCaseListUseCase = GetCaseListUseCase(databaseRepository)
    private val saveMarketOverviewUseCase = SaveMarketOverviewUseCase(databaseRepository)
    private val getMarketOverviewUseCase = GetMarketOverviewUseCase(caseRepository)

    @ExperimentalSerializationApi
    suspend fun updateInfo() {
        val caseList = getCaseListUseCase.getCaseList()
        caseList.forEach { case ->
            getMarketOverviewUseCase.getMarketOverviewUseCase(case.caseAccess, preferredCurrency.preferredCurrency)
                .catch { println("Error") }
                .collect { marketOverviewDto ->
                    saveMarketOverviewUseCase.saveMarketOverviewUseCase(case.id, marketOverviewDto)
                }
        }
    }
}