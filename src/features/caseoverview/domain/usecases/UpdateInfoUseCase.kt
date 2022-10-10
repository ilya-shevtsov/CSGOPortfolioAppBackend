package features.caseoverview.domain.usecases

import core.preferredCurrency
import features.caseoverview.data.DatabaseRepository
import kotlinx.coroutines.flow.catch
import kotlinx.serialization.ExperimentalSerializationApi
import features.caseoverview.domain.CaseRepository

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