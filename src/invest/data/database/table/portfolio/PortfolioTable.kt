package invest.data.database.table.portfolio

import invest.data.database.table.analysis.CaseAnalysisTable
import invest.data.database.table.analysis.CaseAnalysisTable.autoIncrement
import org.jetbrains.exposed.sql.*

object PortfolioTable: Table() {

    val id: Column<Int> = integer("id").autoIncrement()
    val caseId: Column<Int> = integer("caseId")
    val name: Column<String> = varchar("name", 255)
    val position: Column<Int> = integer("position")
    //    val date: Column<Instant> = timestamp("date")
    val currentCasePrice: Column<Double> = double("currentCasePrice")
    val currentPositionValue: Column<Double> = double("currentPositionValue")
    val boughtCasePrice: Column<Double> = double("boughtCasePrice")
    val boughtPositionValue: Column<Double> = double("boughtPositionValue")
    val todayMovement: Column<Double> = double("todayMovement")
    val todayProfitInRUB: Column<Double> = double("todayProfitInRUB")
    val todayProfitInPercent: Column<Double> = double("todayProfitInPercent")

}