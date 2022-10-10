package features.caseportfolio.data.entities

import features.caseportfolio.data.tables.PortfolioTable
import org.jetbrains.exposed.sql.ResultRow

object PortfolioItemDboMapper {
    fun map(row: ResultRow): PortfolioItemDbo {
        return PortfolioItemDbo(
            caseId = row[PortfolioTable.caseId],
            name = row[PortfolioTable.name],
            amount = row[PortfolioTable.amount],
            purchasePrice = row[PortfolioTable.purchasePrice],
            overallValue = row[PortfolioTable.overallValue],
            profitLoss = row[PortfolioTable.profitLoss],
            imageUrl = row[PortfolioTable.imageUrl]
        )
    }
}