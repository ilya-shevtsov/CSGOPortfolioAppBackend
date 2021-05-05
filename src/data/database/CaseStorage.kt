package data.database

import domain.model.marketoverview.MarketOverview
import data.model.case.CaseDbo
import data.repository.DatabaseRepository
import invest.data.database.repository.AnalyticalDetailsRepository
import invest.data.database.repository.DailySellHistoryTableRepository
import invest.data.database.table.analysis.CaseAnalysisTable
import invest.data.database.table.sellhistory.CaseSellHistoryTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

object CaseStorage {
    private val databaseRepository = DatabaseRepository()
    private val dailySellHistoryTableRepository = DailySellHistoryTableRepository()
    private val analyticalDetailsRepository = AnalyticalDetailsRepository()


    fun createDatabase() {
        Database.connect("jdbc:h2:./caseDatabase", "org.h2.Driver")
        transaction {
            SchemaUtils.create(CaseTable)
            SchemaUtils.create(CaseSellHistoryTable)
            SchemaUtils.create(CaseAnalysisTable)
            databaseRepository.insertInitialData()
            dailySellHistoryTableRepository.insertData()
            analyticalDetailsRepository.insertData()
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