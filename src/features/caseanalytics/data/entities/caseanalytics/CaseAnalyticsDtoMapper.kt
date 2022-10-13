package features.caseanalytics.data.entities.caseanalytics

import features.caseanalytics.domain.entities.CaseAnalytics

object CaseAnalyticsDtoMapper {

    fun map(caseAnalytics: CaseAnalytics): CaseAnalyticsDto {
        return CaseAnalyticsDto(
            name = caseAnalytics.name,
            dailyAvgReturnInPercent = caseAnalytics.dailyAvgReturnInPercent,
            dailyAvgReturnInRUB = caseAnalytics.dailyAvgReturnInRUB,
            dailyStandardDeviation = caseAnalytics.dailyStandardDeviation,
            dailySharpRatio = caseAnalytics.dailySharpRatio,
            monthlyAvgReturnInPercent = caseAnalytics.monthlyAvgReturnInPercent,
            monthlyAvgReturnInRUB = caseAnalytics.monthlyAvgReturnInRUB,
            monthlyStandardDeviation = caseAnalytics.monthlyStandardDeviation,
            monthlySharpRatio = caseAnalytics.monthlySharpRatio
        )
    }
}