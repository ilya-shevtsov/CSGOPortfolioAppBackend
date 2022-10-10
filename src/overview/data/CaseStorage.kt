package overview.data

import overview.domain.entities.MarketOverview
import invest.data.AnalyticalDetailsRepository
import invest.data.DailySellHistoryTableRepository
import invest.data.PortfolioRepository
import invest.data.tables.CaseAnalysisTable
import invest.data.tables.PortfolioTable
import invest.data.tables.CaseSellHistoryTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import overview.data.entities.CaseDbo

object CaseStorage {
    private val databaseRepository = DatabaseRepository()
    private val dailySellHistoryTableRepository = DailySellHistoryTableRepository()
    private val analyticalDetailsRepository = AnalyticalDetailsRepository()
    private val portfolioRepository = PortfolioRepository()


    fun createDatabase() {
        Database.connect("jdbc:h2:./caseDatabase", "org.h2.Driver")
        transaction {
            SchemaUtils.create(CaseTable)
            SchemaUtils.create(CaseSellHistoryTable)
            SchemaUtils.create(CaseAnalysisTable)
            SchemaUtils.create(PortfolioTable)
            databaseRepository.insertInitialData()
            dailySellHistoryTableRepository.insertData()
            analyticalDetailsRepository.insertData()
            portfolioRepository.insertInitialData()

        }
    }

    fun insertToCaseTable(caseDbo: CaseDbo) {
        CaseTable.insert {
            it[name] = caseDbo.name
            it[caseAccess] = caseDbo.caseAccess
            it[releaseDate] = caseDbo.releaseDate
            it[dropStatus] = caseDbo.dropStatus
            it[lowestPrice] = caseDbo.lowestPrice
            it[volume] = caseDbo.volume
            it[medianPrice] = caseDbo.medianPrice
            it[imageUrl] = caseDbo.imageUrl
            it[description] = caseDbo.description
        }
    }

    fun saveMarketOverview(caseId: Int, marketOverviewDto: MarketOverview) {
        transaction {
            CaseTable.update({ CaseTable.id eq caseId }) { caseTable ->
                caseTable[lowestPrice] = marketOverviewDto.lowestPrice
                caseTable[volume] = marketOverviewDto.volume
                caseTable[medianPrice] = marketOverviewDto.medianPrice
            }
        }
    }
}