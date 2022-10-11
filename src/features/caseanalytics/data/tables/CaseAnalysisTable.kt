package features.caseanalytics.data.tables

import org.jetbrains.exposed.sql.*

object CaseAnalysisTable : Table() {

    val id: Column<Int> = integer("id").autoIncrement()
    val caseId: Column<Int> = integer("caseId")
    val name: Column<String> = varchar("name", 255)
    //    val date: Column<Instant> = timestamp("date")
    val dailyAvgReturnInPercent: Column<Double> = double("dailyAvgReturnInPercent")
    val dailyAvgReturnInRUB: Column<Double> = double("dailyAvgReturnInRUB")
    val dailyStandardDeviation: Column<Double> = double("dailyStandardDeviation")
    val dailySharpRatio: Column<Double> = double("dailySharpRatio")
    val monthlyAvgReturnInPercent: Column<Double> = double("monthlyAvgReturnInPercent")
    val monthlyAvgReturnInRUB: Column<Double> = double("monthlyAvgReturnInRUB")
    val monthlyStandardDeviation: Column<Double> = double("monthlyStandardDeviation")
    val monthlySharpRatio: Column<Double> = double("monthlySharpRatio")

    init {
        uniqueIndex("caseAnalyticalDetails", caseId, monthlySharpRatio)
    }
}