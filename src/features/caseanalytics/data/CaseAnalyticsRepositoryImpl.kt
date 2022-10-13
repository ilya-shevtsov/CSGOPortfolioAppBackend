package features.caseanalytics.data

import features.caseanalytics.data.entities.caseanalytics.CaseAnalyticsDbo
import features.caseanalytics.data.entities.caseanalytics.CaseAnalyticsDboMapper
import features.caseanalytics.data.entities.caseanalytics.CaseAnalyticsDto
import features.caseanalytics.data.entities.caseanalytics.CaseAnalyticsDtoMapper
import features.caseanalytics.data.tables.CaseAnalysisTable
import features.caseanalytics.domain.CaseAnalyticsRepository
import features.caseanalytics.domain.entities.DailyAnalyticalDetails
import features.caseanalytics.domain.entities.MonthlyAnalyticalDetails
import features.caseanalytics.domain.MathRepository
import features.caseanalytics.domain.entities.CaseAnalytics
import features.caseanalytics.domain.entities.CaseAnalyticsMapper
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.SQLException
import javax.inject.Inject

class CaseAnalyticsRepositoryImpl @Inject constructor(

): CaseAnalyticsRepository {

    private val mathRepository = MathRepository()
    private val dailySellHistoryTableRepository = DailySellHistoryTableRepository()
    private val numberOfCaseId = dailySellHistoryTableRepository.numberOfCaseId


    override fun getAnalyticalDetailsResponse(): List<CaseAnalytics> {
        return transaction {
            CaseAnalysisTable.selectAll().map { CaseAnalyticsDboMapper.mapFromRow(it) }
        }.map { AnalyticalDetailsDbo -> CaseAnalyticsMapper.map(AnalyticalDetailsDbo) }
    }

    override fun insertAnalyticsData() {
        transaction {
            val analyticalDetailsList = getAnalyticalDetailList()
            for (analyticalDetailsDbo in analyticalDetailsList) {
                try {
                    insertToCaseAnalysisTable(analyticalDetailsDbo)
                } catch (e: SQLException) {
                    continue
                }
            }
        }
    }

    private fun insertToCaseAnalysisTable(caseAnalyticsDbo: CaseAnalyticsDbo) {
        CaseAnalysisTable.insert {
            it[caseId] = caseAnalyticsDbo.id
            it[name]= caseAnalyticsDbo.name
            it[dailyAvgReturnInPercent] = caseAnalyticsDbo.dailyAvgReturnInPercent
            it[dailyAvgReturnInRUB] = caseAnalyticsDbo.dailyAvgReturnInRUB
            it[dailyStandardDeviation] = caseAnalyticsDbo.dailyStandardDeviation
            it[dailySharpRatio] = caseAnalyticsDbo.dailySharpRatio
            it[monthlyAvgReturnInPercent] = caseAnalyticsDbo.monthlyAvgReturnInPercent
            it[monthlyAvgReturnInRUB] = caseAnalyticsDbo.monthlyAvgReturnInRUB
            it[monthlyStandardDeviation] = caseAnalyticsDbo.monthlyStandardDeviation
            it[monthlySharpRatio] = caseAnalyticsDbo.monthlySharpRatio
        }
    }

    private fun getAnalyticalDetailList(): List<CaseAnalyticsDbo> {
        val caseAnalyticsDboList = mutableListOf<CaseAnalyticsDbo>()
        val monthlyAnalyticalDetailList = getMonthlyAnalyticalDetailList()
        val dailyAnalyticalDetailList = getDailyAnalyticalDetailList()
        val newList =
            monthlyAnalyticalDetailList zip dailyAnalyticalDetailList
        newList.map { pair ->
            caseAnalyticsDboList.add(
                CaseAnalyticsDboMapper.map(pair)
            )
        }
        return caseAnalyticsDboList
    }

    private fun getMonthlyAnalyticalDetailList(): List<MonthlyAnalyticalDetails> {
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

    private fun getDailyAnalyticalDetailList(): List<DailyAnalyticalDetails> {
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

