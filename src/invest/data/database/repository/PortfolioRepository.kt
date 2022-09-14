package invest.data.database.repository

import invest.data.database.table.portfolio.PortfolioStorage
import invest.data.database.table.portfolio.PortfolioTable
import invest.data.model.CaseWeaponsDto
import invest.data.model.portfolio.dbo.PortfolioItemDbo
import invest.data.model.portfolio.dbo.PortfolioItemDboMapper
import invest.data.model.portfolio.dto.PortfolioDtoMapper
import invest.data.model.portfolio.dto.PortfolioItemDto
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import overview.data.database.CaseTable
import overview.data.model.case.CaseDboMapper
import overview.domain.model.case.CaseDto
import overview.domain.model.case.CaseDtoMapper

class PortfolioRepository {

    fun getPortfolioList(): List<PortfolioItemDbo> {
        return transaction {
            PortfolioTable.selectAll().map { PortfolioItemDboMapper.map(it) }
        }
    }

    fun getCaseResponse(): List<PortfolioItemDto> {
        return transaction {
            PortfolioTable.selectAll().map { PortfolioItemDboMapper.map(it) }
        }.map { portfolioItemDbo -> PortfolioDtoMapper.map(portfolioItemDbo) }
    }

    fun insertInitialData() {
        val storedCaseList = listOf(
            PortfolioItemDbo(
                name = "Chroma 2 Case",
                amount = 42,
                purchasePrice = 0.0,
                overallValue = 42.94,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Chroma%202%20Case",
            ),
            PortfolioItemDbo(
                name = "Chroma 3 Case",
                amount = 51,
                purchasePrice = 0.0,
                overallValue = 37.76,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Chroma%203%20Case",
            ),
            PortfolioItemDbo(
                name = "Chroma Case",
                amount = 33,
                purchasePrice = 0.0,
                overallValue = 47.48,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Chroma%20Case",
            ),
            PortfolioItemDbo(
                name = "Clutch Case",
                amount = 82,
                purchasePrice = 0.0,
                overallValue = 27.92,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Clutch%20Case",
            ),
            PortfolioItemDbo(
                name = "CS20 Case",
                amount = 27,
                purchasePrice = 0.0,
                overallValue = 5.81,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/CS20%20Case",
            ),
            PortfolioItemDbo(
                name = "Danger Zone Case",
                amount = 29,
                purchasePrice = 0.0,
                overallValue = 3.95,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Danger%20Zone%20Case",
            ),
            PortfolioItemDbo(
                name = "Falchion Case",
                amount = 38,
                purchasePrice = 0.0,
                overallValue = 14.96,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Falchion%20Case",
            ),
            PortfolioItemDbo(
                name = "Fracture Case",
                amount = 28,
                purchasePrice = 0.0,
                overallValue = 3.88,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Fracture%20Case",
            ),
            PortfolioItemDbo(
                name = "Gamma 2 Case",
                amount = 21,
                purchasePrice = 0.0,
                overallValue = 20.17,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Gamma%202%20Case",
            ),
            PortfolioItemDbo(
                name = "Gamma Case",
                amount = 27,
                purchasePrice = 0.0,
                overallValue = 26.69,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Gamma%20Case",
            ),
            PortfolioItemDbo(
                name = "Glove Case",
                amount = 24,
                purchasePrice = 0.0,
                overallValue = 67.95,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Glove%20Case",
            ),
            PortfolioItemDbo(
                name = "Horizon Case",
                amount = 9,
                purchasePrice = 0.0,
                overallValue = 2.07,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Horizon%20Case",
            ),
            PortfolioItemDbo(
                name = "Operation Breakout Weapon Case",
                amount = 58,
                purchasePrice = 0.0,
                overallValue = 246.45,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Breakout%20Weapon%20Case",
            ),
            PortfolioItemDbo(
                name = "Operation Broken Fang Case",
                amount = 33,
                purchasePrice = 0.0,
                overallValue = 53.48,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Broken%20Fang%20Case",
            ),
            PortfolioItemDbo(
                name = "Operation Phoenix Weapon Case",
                amount = 52,
                purchasePrice = 0.0,
                overallValue = 72.34,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Phoenix%20Weapon%20Case",
            ),
            PortfolioItemDbo(
                name = "Operation Wildfire Case",
                amount = 24,
                purchasePrice = 0.0,
                overallValue = 14.09,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Operation%20Wildfire%20Case",
            ),
            PortfolioItemDbo(
                name = "Prisma 2 Case",
                amount = 68,
                purchasePrice = 0.0,
                overallValue = 8.81,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Prisma%202%20Case",
            ),
            PortfolioItemDbo(
                name = "Prisma Case",
                amount = 202,
                purchasePrice = 0.0,
                overallValue = 26.63,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Prisma%20Case",
            ),
            PortfolioItemDbo(
                name = "Revolver Case",
                amount = 34,
                purchasePrice = 0.0,
                overallValue = 13.74,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Revolver%20Case",
            ),
            PortfolioItemDbo(
                name = "Shadow Case",
                amount = 31,
                purchasePrice = 0.0,
                overallValue = 12.12,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Shadow%20Case",
            ),
            PortfolioItemDbo(
                name = "Spectrum 2 Case",
                amount = 48,
                purchasePrice = 0.0,
                overallValue = 36.99,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Spectrum%202%20Case",
            ),
            PortfolioItemDbo(
                name = "Spectrum Case",
                amount = 40,
                purchasePrice = 0.0,
                overallValue = 48.40,
                profitLoss = 0.0,
                imageUrl = "https://api.steamapis.com/image/item/730/Spectrum%20Case",
            ),
        )
//        storedCaseList.map { item -> PortfolioStorage.insertPortfolioTable(item) }
        storedCaseList.forEach { item ->
            if (storedCaseList.all { storedCase -> item.name != storedCase.name }) {
                PortfolioStorage.insertPortfolioTable(item)
            }
        }
    }
}