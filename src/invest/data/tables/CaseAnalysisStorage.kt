package invest.data.tables

import invest.data.entities.AnalyticalDetailsDbo
import org.jetbrains.exposed.sql.insert

object CaseAnalysisStorage {

    fun insertToCaseAnalysisTable(analyticalDetailsDbo: AnalyticalDetailsDbo) {
        CaseAnalysisTable.insert {
            it[caseId] = analyticalDetailsDbo.id
            it[name]= analyticalDetailsDbo.name
            it[dailyAvgReturnInPercent] = analyticalDetailsDbo.dailyAvgReturnInPercent
            it[dailyAvgReturnInRUB] = analyticalDetailsDbo.dailyAvgReturnInRUB
            it[dailyStandardDeviation] = analyticalDetailsDbo.dailyStandardDeviation
            it[dailySharpRatio] = analyticalDetailsDbo.dailySharpRatio
            it[monthlyAvgReturnInPercent] = analyticalDetailsDbo.monthlyAvgReturnInPercent
            it[monthlyAvgReturnInRUB] = analyticalDetailsDbo.monthlyAvgReturnInRUB
            it[monthlyStandardDeviation] = analyticalDetailsDbo.monthlyStandardDeviation
            it[monthlySharpRatio] = analyticalDetailsDbo.monthlySharpRatio
        }
    }
}