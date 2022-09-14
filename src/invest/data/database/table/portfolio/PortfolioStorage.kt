package invest.data.database.table.portfolio
import invest.data.model.portfolio.dbo.PortfolioItemDbo
import org.jetbrains.exposed.sql.insert

object PortfolioStorage {

    fun insertPortfolioTable(portfolioItemDbo: PortfolioItemDbo) {
        PortfolioTable.insert {
            it[name] = portfolioItemDbo.name
            it[amount] = portfolioItemDbo.amount
            it[purchasePrice] = portfolioItemDbo.purchasePrice
            it[overallValue] = portfolioItemDbo.overallValue
            it[profitLoss] = portfolioItemDbo.profitLoss
            it[imageUrl] = portfolioItemDbo.imageUrl
        }
    }
}