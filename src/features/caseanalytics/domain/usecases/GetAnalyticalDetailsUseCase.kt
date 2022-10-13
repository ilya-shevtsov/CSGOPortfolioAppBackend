package features.caseanalytics.domain.usecases

import features.caseanalytics.data.entities.caseanalytics.CaseAnalyticsDto
import features.caseanalytics.domain.CaseAnalyticsRepository
import features.caseanalytics.domain.entities.CaseAnalytics
import javax.inject.Inject

class GetAnalyticalDetailsUseCase @Inject constructor(
    private val analyticsRepository: CaseAnalyticsRepository
) {
    operator fun invoke(): List<CaseAnalytics>{
        return analyticsRepository.getAnalyticalDetailsResponse()
    }
}