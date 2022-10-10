package features.caseanalytics.data.entities

object AnalyticalDetailsDtoMapper {

    fun map(analyticalDetailsDbo: AnalyticalDetailsDbo): AnalyticalDetailsDto {
        return AnalyticalDetailsDto(
            name = analyticalDetailsDbo.name,
            dailyAvgReturnInPercent = analyticalDetailsDbo.dailyAvgReturnInPercent,
            dailyAvgReturnInRUB = analyticalDetailsDbo.dailyAvgReturnInRUB,
            dailyStandardDeviation = analyticalDetailsDbo.dailyStandardDeviation,
            dailySharpRatio = analyticalDetailsDbo.dailySharpRatio,
            monthlyAvgReturnInPercent = analyticalDetailsDbo.monthlyAvgReturnInPercent,
            monthlyAvgReturnInRUB = analyticalDetailsDbo.monthlyAvgReturnInRUB,
            monthlyStandardDeviation = analyticalDetailsDbo.monthlyStandardDeviation,
            monthlySharpRatio = analyticalDetailsDbo.monthlySharpRatio
        )
    }
}