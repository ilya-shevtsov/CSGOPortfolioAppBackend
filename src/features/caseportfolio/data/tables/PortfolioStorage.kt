package features.caseportfolio.data.tables

import features.caseportfolio.data.entities.PortfolioItemDbo
import features.caseportfolio.data.entities.PortfolioItemDboMapper
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

    fun updateCaseData(addedCase: PortfolioItemDbo) {
        val storedCaseList = getPortfolioList()

        // none, any all

        if (storedCaseList.none { portfolioItem -> portfolioItem.caseId == addedCase.caseId }) {
            insertPortfolioTable(addedCase)
        } else {
            transaction {
                PortfolioTable.update({ PortfolioTable.caseId eq addedCase.caseId })
                { portfolioTable ->
                    with(SqlExpressionBuilder) {
                        portfolioTable[amount] = amount + addedCase.amount
                        portfolioTable[overallValue] = overallValue + addedCase.overallValue
                    }
                }
            }
        }
    }
}