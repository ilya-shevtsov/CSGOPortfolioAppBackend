package features.caseanalytics.domain.entities

import features.caseanalytics.data.entities.caseanalytics.CaseAnalyticsDbo

object CaseAnalyticsMapper {

    fun map(caseAnalyticsDbo: CaseAnalyticsDbo): CaseAnalytics {
        return CaseAnalytics(
            name = caseAnalyticsDbo.name,
            dailyAvgReturnInPercent = caseAnalyticsDbo.dailyAvgReturnInPercent,
            dailyAvgReturnInRUB = caseAnalyticsDbo.dailyAvgReturnInRUB,
            dailyStandardDeviation = caseAnalyticsDbo.dailyStandardDeviation,
            dailySharpRatio = caseAnalyticsDbo.dailySharpRatio,
            monthlyAvgReturnInPercent = caseAnalyticsDbo.monthlyAvgReturnInPercent,
            monthlyAvgReturnInRUB = caseAnalyticsDbo.monthlyAvgReturnInRUB,
            monthlyStandardDeviation = caseAnalyticsDbo.monthlyStandardDeviation,
            monthlySharpRatio = caseAnalyticsDbo.monthlySharpRatio
        )
    }
}