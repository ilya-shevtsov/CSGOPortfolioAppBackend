package invest.data.database.table.portfolio

import invest.data.model.portfolio.dbo.PortfolioItemDbo
import invest.data.model.portfolio.dbo.PortfolioItemDboMapper
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

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

        val hdhd = any
        if (portfolioItemDbo.caseId  !in storedCaseList) {
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