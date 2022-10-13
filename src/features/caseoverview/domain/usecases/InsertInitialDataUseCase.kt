package features.caseoverview.domain.usecases

import features.caseanalytics.data.DailySellHistoryTableRepository
import features.caseanalytics.domain.usecases.InsertAnalyticsDataUseCase
import features.caseportfolio.domain.usecases.InsertInitialDataPortfolioUseCase
import javax.inject.Inject

class InsertInitialDataUseCase @Inject constructor(
    private val insertAnalyticsDataUseCase: InsertAnalyticsDataUseCase,
    private val dailySellHistoryTableRepository: DailySellHistoryTableRepository,
    private val insertInitialDataPortfolioUseCase: InsertInitialDataPortfolioUseCase,
    private val insertInitialDataCaseOverviewUseCase: InsertInitialDataCaseOverviewUseCase
) {
    operator fun invoke() {
        insertInitialDataCaseOverviewUseCase()
        dailySellHistoryTableRepository.insertDailySellHistoryData()
        insertAnalyticsDataUseCase()
        insertInitialDataPortfolioUseCase()
    }
}
