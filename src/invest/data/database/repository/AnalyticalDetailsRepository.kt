package invest.data.database.repository

import invest.data.database.table.analysis.CaseAnalysisStorage.insertToCaseAnalysisTable
import invest.data.database.table.analysis.CaseAnalysisTable
import invest.data.model.analyticaldetails.dbo.AnalyticalDetailsDbo
import invest.data.model.analyticaldetails.dbo.AnalyticalDetailsDboMapper
import invest.domain.model.analyticaldetails.DailyAnalyticalDetails
import invest.domain.model.analyticaldetails.MonthlyAnalyticalDetails
import invest.data.model.analyticaldetails.dto.AnalyticalDetailsDto
import invest.data.model.analyticaldetails.dto.AnalyticalDetailsDtoMapper
import invest.domain.repository.MathRepository
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.SQLException

class AnalyticalDetailsRepository {

    private val mathRepository = MathRepository()
    private val dailySellHistoryTableRepository = DailySellHistoryTableRepository()
    val numberOfCaseId = dailySellHistoryTableRepository.numberOfCaseId


    fun getAnalyticalDetailsResponse(): List<AnalyticalDetailsDto> {
        return transaction {
            CaseAnalysisTable.selectAll().map { AnalyticalDetailsDboMapper.mapFromRow(it) }
        }.map { AnalyticalDetailsDbo -> AnalyticalDetailsDtoMapper.map(AnalyticalDetailsDbo) }
    }


    fun insertData() {
        val analyticalDetailsList = getAnalyticalDetailList()

        for (analyticalDetailsDbo in analyticalDetailsList) {
            try {
                insertToCaseAnalysisTable(analyticalDetailsDbo)
            } catch (e: SQLException) {
                continue
            }
        }
    }


    fun getAnalyticalDetailList(): List<AnalyticalDetailsDbo> {
        val analyticalDetailsDboList = mutableListOf<AnalyticalDetailsDbo>()
        val monthlyAnalyticalDetailList = getMonthlyAnalyticalDetailList()
        val dailyAnalyticalDetailList = getDailyAnalyticalDetailList()
        val newList =
            monthlyAnalyticalDetailList zip dailyAnalyticalDetailList
        newList.map { pair ->
            analyticalDetailsDboList.add(
                AnalyticalDetailsDboMapper.map(pair)
            )
        }
        return analyticalDetailsDboList
    }

    fun getMonthlyAnalyticalDetailList(): List<MonthlyAnalyticalDetails> {
        val monthlyAnalyticalDetailsList = mutableListOf<MonthlyAnalyticalDetails>()

        val monthlyCasePriceDataList = dailySellHistoryTableRepository
            .getCasePriceDataList(30, numberOfCaseId)

        monthlyCasePriceDataList.forEach { case ->
            val priceList = case.priceList
            val caseName = case.name
            val monthlyAvgReturnPresent = mathRepository.getAverageReturn(priceList, 1)
            val monthlyAvgReturnRUB = mathRepository.getAverageReturn(priceList, 2)
            val monthlyStandardDeviation = mathRepository.getStandardDeviation(priceList)
            val monthlySharpRatio = mathRepository.getSharpRatio(priceList)
            monthlyAnalyticalDetailsList.add(
                MonthlyAnalyticalDetails(
                    name = caseName,
                    monthlyAvgReturnInPercent = monthlyAvgReturnPresent,
                    monthlyAvgReturnInRUB = monthlyAvgReturnRUB,
                    monthlyStandardDeviation = monthlyStandardDeviation,
                    monthlySharpRatio = monthlySharpRatio
                )
            )
        }
        return monthlyAnalyticalDetailsList
    }

    fun getDailyAnalyticalDetailList(): List<DailyAnalyticalDetails> {
        val dailyAnalyticalDetailsList = mutableListOf<DailyAnalyticalDetails>()

        val dailyCasePriceDataList = dailySellHistoryTableRepository
            .getCasePriceDataList(1, numberOfCaseId)

        dailyCasePriceDataList.forEach { case ->
            val priceList = case.priceList
            val caseName = case.name
            val dailyAvgReturnPresent = mathRepository.getAverageReturn(priceList, 1)
            val dailyAvgReturnRUB = mathRepository.getAverageReturn(priceList, 2)
            val dailyStandardDeviation = mathRepository.getStandardDeviation(priceList)
            val dailySharpRatio = mathRepository.getSharpRatio(priceList)
            dailyAnalyticalDetailsList.add(
                DailyAnalyticalDetails(
                    name = caseName,
                    dailyAvgReturnInPercent = dailyAvgReturnPresent,
                    dailyAvgReturnInRUB = dailyAvgReturnRUB,
                    dailyStandardDeviation = dailyStandardDeviation,
                    dailySharpRatio = dailySharpRatio
                )
            )
        }
        return dailyAnalyticalDetailsList
    }
}

