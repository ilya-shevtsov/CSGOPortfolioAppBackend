package features.caseanalytics.domain.usecases

import features.caseanalytics.domain.CaseAnalyticsRepository
import javax.inject.Inject

class InsertAnalyticsDataUseCase @Inject constructor(
    private val caseAnalyticsRepository: CaseAnalyticsRepository
) {
    operator fun invoke(){
        caseAnalyticsRepository.insertAnalyticsData()
    }
}