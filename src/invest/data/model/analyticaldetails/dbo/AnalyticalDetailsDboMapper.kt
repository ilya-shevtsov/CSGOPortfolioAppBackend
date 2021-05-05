package invest.data.model.analyticaldetails.dbo

import invest.data.common.CommonRepository
import invest.data.database.table.analysis.CaseAnalysisTable
import invest.domain.model.analyticaldetails.DailyAnalyticalDetails
import invest.domain.model.analyticaldetails.MonthlyAnalyticalDetails
import org.jetbrains.exposed.sql.ResultRow

object AnalyticalDetailsDboMapper {

    private val commonRepository = CommonRepository()

    fun mapFromRow(row: ResultRow): AnalyticalDetailsDbo {
        return AnalyticalDetailsDbo(
            id = row[CaseAnalysisTable.id],
            name = row[CaseAnalysisTable.name],
            dailyAvgReturnInPercent = row[CaseAnalysisTable.dailyAvgReturnInPercent],
            dailyAvgReturnInRUB = row[CaseAnalysisTable.dailyAvgReturnInRUB],
            dailyStandardDeviation = row[CaseAnalysisTable.dailyStandardDeviation],
            dailySharpRatio = row[CaseAnalysisTable.dailySharpRatio],
            monthlyAvgReturnInPercent = row[CaseAnalysisTable.monthlyAvgReturnInPercent],
            monthlyAvgReturnInRUB = row[CaseAnalysisTable.monthlyAvgReturnInRUB],
            monthlyStandardDeviation = row[CaseAnalysisTable.monthlyStandardDeviation],
            monthlySharpRatio = row[CaseAnalysisTable.monthlySharpRatio]
        )
    }


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