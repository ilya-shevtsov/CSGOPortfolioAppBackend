package features.caseanalytics.domain.usecases

import features.caseanalytics.data.entities.AnalyticalDetailsDto
import features.caseanalytics.domain.CaseAnalyticsRepository
import javax.inject.Inject

class GetAnalyticalDetailsUseCase @Inject constructor(
    private val analyticsRepository: CaseAnalyticsRepository
) {
    operator fun invoke(): List<AnalyticalDetailsDto>{
        return analyticsRepository.getAnalyticalDetailsResponse()
    }
}