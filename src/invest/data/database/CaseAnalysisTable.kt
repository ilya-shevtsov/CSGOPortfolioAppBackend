package invest.data.database

import data.database.CaseTable.autoIncrement
import org.jetbrains.exposed.sql.*

object CaseAnalysisTable : Table() {

    val id: Column<Int> = integer("Id").autoIncrement()
    val name: Column<String> = varchar("Name", 255)
    val avgReturnInPercent: Column<Double> = double("Avg Return in %")
    val avgReturnInRUB: Column<Double> = double("Avg Return in RUB")
    val dailyStandardDeviation: Column<Double> = double("Daily Standard Deviation")
    val monthlyStandardDeviation: Column<Double> = double("Monthly Standard Deviation")
    val dailySharpRatio: Column<Double> = double("Daily Sharp Ratio")
    val monthlySharpRatio: Column<Double> = double("Monthly Sharp Ratio")
}