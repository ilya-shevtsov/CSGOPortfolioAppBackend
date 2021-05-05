package invest.data.model.analyticaldetails.dbo

import invest.data.common.CommonRepository
import invest.data.database.table.analysis.CaseAnalysisTable
import invest.data.model.analyticaldetails.DailyAnalyticalDetails
import invest.data.model.analyticaldetails.MonthlyAnalyticalDetails
import invest.data.model.analyticaldetails.dto.AnalyticalDetailsDto
import org.jetbrains.exposed.sql.ResultRow

object AnalyticalDetailsMapper {

    private val commonRepository = CommonRepository()

    fun mapToDto(analyticalDetailsDbo: AnalyticalDetailsDbo): AnalyticalDetailsDto {
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

    fun mapToDboFromRow(row: ResultRow): AnalyticalDetailsDbo {
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


    fun mapToDbo(pair: Pair<MonthlyAnalyticalDetails, DailyAnalyticalDetails>): AnalyticalDetailsDbo {
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