package invest.data.model.analyticaldetails.dbo

import invest.data.common.CommonRepository
import invest.data.model.analyticaldetails.DailyAnalyticalDetails
import invest.data.model.analyticaldetails.MonthlyAnalyticalDetails

object AnalyticalDetailsDboMapper {

    private val commonRepository = CommonRepository()

    fun map(pair: Pair<MonthlyAnalyticalDetails, DailyAnalyticalDetails>): AnalyticalDetailsDbo {
        return AnalyticalDetailsDbo(
            id = commonRepository.assignId(pair.first.name),
            name = pair.first.name,
            dailyAvgReturnInPercent = pair.second.dailyAvgReturnInPercent,
            dailyAvgReturnInRUB = pair.second.dailyAvgReturnInRUB,
            dailyStandardDeviation = pair.second.dailyStandardDeviation,
            dailySharpRatio = pair.second.dailySharpRatio,
            monthlyAvgReturnInPercent = pair.first.monthlyAvgReturnInPercent,
            monthlyAvgReturnInRUB = pair.first.monthlyAvgReturnInRUB,
            monthlyStandardDeviation = pair.first.monthlyStandardDeviation,
            monthlySharpRatio = pair.first.monthlySharpRatio
        )
    }
}