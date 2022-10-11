package features.caseportfolio.data

import features.caseportfolio.data.entities.PortfolioDtoMapper
import features.caseportfolio.data.entities.PortfolioItemDbo
import features.caseportfolio.data.entities.PortfolioItemDboMapper
import features.caseportfolio.data.entities.PortfolioItemDto
import features.caseportfolio.domain.PortfolioRepository
import org.jetbrains.exposed.sql.SqlExpressionBuilder
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import javax.inject.Inject

class PortfolioRepositoryImpl @Inject constructor(

) : PortfolioRepository {

    override fun updatePortfolio(addedCase: PortfolioItemDbo) {
        val storedCaseList = getPortfolioList()
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

    override fun getPortfolioData(): List<PortfolioItemDto> {
        return transaction {
            PortfolioTable.selectAll().map { PortfolioItemDboMapper.map(it) }
        }.map { portfolioItemDbo -> PortfolioDtoMapper.map(portfolioItemDbo) }
    }

    override fun insertInitialDataPortfolio() {
        val storedCaseList = listOf(
            PortfolioItemDbo(
                caseId = 2,
                name = "Chroma 2 Case",
                amount = 42,
                purchasePrice = 0.0,
                overallValue = 42.94,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Chroma%202%20Case",
            ),
            PortfolioItemDbo(
                caseId = 3,
                name = "Chroma 3 Case",
                amount = 51,
                purchasePrice = 0.0,
                overallValue = 37.76,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Chroma%203%20Case",
            ),
            PortfolioItemDbo(
                caseId = 1,
                name = "Chroma Case",
                amount = 33,
                purchasePrice = 0.0,
                overallValue = 47.48,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Chroma%20Case",
            ),
            PortfolioItemDbo(
                caseId = 4,
                name = "Clutch Case",
                amount = 82,
                purchasePrice = 0.0,
                overallValue = 27.92,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Clutch%20Case",
            ),
            PortfolioItemDbo(
                caseId = 8,
                name = "CS20 Case",
                amount = 27,
                purchasePrice = 0.0,
                overallValue = 5.81,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/CS20%20Case",
            ),
            PortfolioItemDbo(
                caseId = 9,
                name = "Danger Zone Case",
                amount = 29,
                purchasePrice = 0.0,
                overallValue = 3.95,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Danger%20Zone%20Case",
            ),
            PortfolioItemDbo(
                caseId = 13,
                name = "Falchion Case",
                amount = 38,
                purchasePrice = 0.0,
                overallValue = 14.96,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Falchion%20Case",
            ),
            PortfolioItemDbo(
                caseId = 14,
                name = "Fracture Case",
                amount = 28,
                purchasePrice = 0.0,
                overallValue = 3.88,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Fracture%20Case",
            ),
            PortfolioItemDbo(
                caseId = 16,
                name = "Gamma 2 Case",
                amount = 21,
                purchasePrice = 0.0,
                overallValue = 20.17,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Gamma%202%20Case",
            ),
            PortfolioItemDbo(
                caseId = 15,
                name = "Gamma Case",
                amount = 27,
                purchasePrice = 0.0,
                overallValue = 26.69,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Gamma%20Case",
            ),
            PortfolioItemDbo(
                caseId = 17,
                name = "Glove Case",
                amount = 24,
                purchasePrice = 0.0,
                overallValue = 67.95,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Glove%20Case",
            ),
            PortfolioItemDbo(
                caseId = 18,
                name = "Horizon Case",
                amount = 9,
                purchasePrice = 0.0,
                overallValue = 2.07,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Horizon%20Case",
            ),
            PortfolioItemDbo(
                caseId = 21,
                name = "Operation Breakout Weapon Case",
                amount = 58,
                purchasePrice = 0.0,
                overallValue = 246.45,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Breakout%20Weapon%20Case",
            ),
            PortfolioItemDbo(
                caseId = 22,
                name = "Operation Broken Fang Case",
                amount = 33,
                purchasePrice = 0.0,
                overallValue = 53.48,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Broken%20Fang%20Case",
            ),
            PortfolioItemDbo(
                caseId = 24,
                name = "Operation Phoenix Weapon Case",
                amount = 52,
                purchasePrice = 0.0,
                overallValue = 72.34,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Phoenix%20Weapon%20Case",
            ),
            PortfolioItemDbo(
                caseId = 26,
                name = "Operation Wildfire Case",
                amount = 24,
                purchasePrice = 0.0,
                overallValue = 14.09,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Wildfire%20Case",
            ),
            PortfolioItemDbo(
                caseId = 28,
                name = "Prisma 2 Case",
                amount = 68,
                purchasePrice = 0.0,
                overallValue = 8.81,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Prisma%202%20Case",
            ),
            PortfolioItemDbo(
                caseId = 27,
                name = "Prisma Case",
                amount = 202,
                purchasePrice = 0.0,
                overallValue = 26.63,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Prisma%20Case",
            ),
            PortfolioItemDbo(
                caseId = 29,
                name = "Revolver Case",
                amount = 34,
                purchasePrice = 0.0,
                overallValue = 13.74,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Revolver%20Case",
            ),
            PortfolioItemDbo(
                caseId = 30,
                name = "Shadow Case",
                amount = 31,
                purchasePrice = 0.0,
                overallValue = 12.12,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Shadow%20Case",
            ),
            PortfolioItemDbo(
                caseId = 33,
                name = "Spectrum 2 Case",
                amount = 48,
                purchasePrice = 0.0,
                overallValue = 36.99,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Spectrum%202%20Case",
            ),
            PortfolioItemDbo(
                caseId = 32,
                name = "Spectrum Case",
                amount = 40,
                purchasePrice = 0.0,
                overallValue = 48.40,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Spectrum%20Case",
            ),
        )
        storedCaseList.map { item -> insertPortfolioTable(item) }
//        storedCaseList.forEach { item ->
//            if (storedCaseList.all { storedCase -> item.name != storedCase.name }) {
//                insertPortfolioTable(item)
//            }
//        }
    }

    private fun insertPortfolioTable(portfolioItemDbo: PortfolioItemDbo) {
        transaction {
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
    }

    private fun getPortfolioList(): List<PortfolioItemDbo> {
        return transaction {
            PortfolioTable.selectAll().map { PortfolioItemDboMapper.map(it) }
        }
    }
}