package features.caseoverview.domain.usecases

import features.caseanalytics.domain.usecases.InsertAnalyticsDataUseCase
import features.caseanalytics.domain.usecases.InsertDailySellHistoryDataUseCase
import features.caseportfolio.domain.usecases.InsertInitialDataPortfolioUseCase
import javax.inject.Inject

class InsertInitialDataUseCase @Inject constructor(
    private val insertAnalyticsDataUseCase: InsertAnalyticsDataUseCase,
    private val insertDailySellHistoryDataUseCase: InsertDailySellHistoryDataUseCase,
    private val insertInitialDataPortfolioUseCase: InsertInitialDataPortfolioUseCase,
    private val insertInitialDataCaseOverviewUseCase: InsertInitialDataCaseOverviewUseCase
) {
    operator fun invoke() {
        insertInitialDataCaseOverviewUseCase()
        insertDailySellHistoryDataUseCase()
        insertAnalyticsDataUseCase()
        insertInitialDataPortfolioUseCase()
    }
}
