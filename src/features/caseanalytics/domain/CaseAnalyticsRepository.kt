package features.caseanalytics.domain

import features.caseanalytics.data.entities.AnalyticalDetailsDto

interface CaseAnalyticsRepository {

    fun getAnalyticalDetailsResponse(): List<AnalyticalDetailsDto>

    fun insertAnalyticsData()
}