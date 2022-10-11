package features.caseoverview.domain.usecases

import core.preferredCurrency
import kotlinx.coroutines.flow.catch
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Inject

class UpdateInfoUseCase @Inject constructor(
    private val getCaseListUseCase: GetCaseListUseCase,
    private val getMarketOverviewUseCase: GetMarketOverviewUseCase,
    private val saveMarketOverviewUseCase: SaveMarketOverviewUseCase
) {

    @ExperimentalSerializationApi
    suspend operator fun invoke() {
        val caseList = getCaseListUseCase()
        caseList.forEach { case ->
            getMarketOverviewUseCase(case.caseAccess, preferredCurrency.preferredCurrency)
                .catch { println("Error") }
                .collect { marketOverviewDto ->
                    saveMarketOverviewUseCase(case.id, marketOverviewDto)
                }
        }
    }
}