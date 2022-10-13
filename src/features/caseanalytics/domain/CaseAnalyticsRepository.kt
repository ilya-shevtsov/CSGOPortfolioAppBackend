package features.caseanalytics.domain

import features.caseanalytics.data.entities.caseanalytics.CaseAnalyticsDto
import features.caseanalytics.domain.entities.CaseAnalytics

interface CaseAnalyticsRepository {

    fun getAnalyticalDetailsResponse(): List<CaseAnalytics>

    fun insertAnalyticsData()
}