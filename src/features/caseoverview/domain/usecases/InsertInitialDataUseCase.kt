package features.caseoverview.domain.usecases

import features.caseanalytics.data.AnalyticalDetailsRepository
import features.caseanalytics.data.DailySellHistoryTableRepository
import features.caseportfolio.domain.usecases.InsertInitialDataPortfolioUseCase
import org.jetbrains.exposed.sql.transactions.transaction
import javax.inject.Inject

class InsertInitialDataUseCase @Inject constructor(
    private val analyticalDetailsRepository: AnalyticalDetailsRepository,
    private val dailySellHistoryTableRepository: DailySellHistoryTableRepository,
    private val insertInitialDataPortfolioUseCase: InsertInitialDataPortfolioUseCase,
    private val insertInitialDataCaseOverviewUseCase: InsertInitialDataCaseOverviewUseCase
) {
    operator fun invoke() {
        insertInitialDataCaseOverviewUseCase()
        dailySellHistoryTableRepository.insertDailySellHistoryData()
        analyticalDetailsRepository.insertAnalyticsData()
        insertInitialDataPortfolioUseCase()
    }
}
