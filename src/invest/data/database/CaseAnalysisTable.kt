package invest.data.database

import org.jetbrains.exposed.sql.*

object CaseAnalysisTable : Table() {

    val id: Column<Int> = integer("id").autoIncrement()
    val name: Column<String> = varchar("name", 255)
    val avgReturnInPercent: Column<Double> = double("avgReturnInPercent")
    val avgReturnInRUB: Column<Double> = double("avgReturnInRUB")
    val dailyStandardDeviation: Column<Double> = double("dailyStandardDeviation")
    val monthlyStandardDeviation: Column<Double> = double("monthlyStandardDeviation")
    val dailySharpRatio: Column<Double> = double("dailySharpRatio")
    val monthlySharpRatio: Column<Double> = double("monthlySharpRatio")
}