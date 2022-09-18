package invest.data.database.table.portfolio

import invest.data.common.CommonRepository
import invest.data.model.portfolio.dbo.PortfolioItemDbo
import invest.data.model.portfolio.dbo.PortfolioItemDboMapper
import org.jetbrains.exposed.sql.SqlExpressionBuilder
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import overview.data.database.CaseTable
import overview.data.model.case.CaseDbo
import overview.data.model.case.CaseDboMapper

object PortfolioStorage {

    fun insertPortfolioTable(portfolioItemDbo: PortfolioItemDbo) {
        PortfolioTable.insert {
            it[caseId] = portfolioItemDbo.caseId
            it[name] = portfolioItemDbo.name
            it[amount] = portfolioItemDbo.amount
            it[purchasePrice] = portfolioItemDbo.purchasePrice
            it[overallValue] = portfolioItemDbo.overallValue
            it[profitLoss] = portfolioItemDbo.profitLoss
            it[imageUrl] = portfolioItemDbo.imageUrl
        }
    }

    private fun getPortfolioList(): List<PortfolioItemDbo> {
        return transaction {
            PortfolioTable.selectAll().map { PortfolioItemDboMapper.map(it) }
        }
    }

    fun updateCaseData(portfolioItemDbo: PortfolioItemDbo) {
        val storedCaseList = getPortfolioList()
        if (portfolioItemDbo !in storedCaseList) {
            insertPortfolioTable(portfolioItemDbo)
        } else {
            transaction {
                PortfolioTable.update({ PortfolioTable.caseId eq portfolioItemDbo.caseId })
                { portfolioTable ->
                    with(SqlExpressionBuilder) {
                        portfolioTable[amount] = amount + portfolioItemDbo.amount
                        portfolioTable[overallValue] = overallValue + portfolioItemDbo.overallValue
                    }
                }
            }
        }
    }
}