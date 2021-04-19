package data.database

import domain.model.marketoverview.MarketOverview
import data.model.case.CaseDbo
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

object CaseStorage {

    fun createCaseDatabase() {
        Database.connect("jdbc:h2:./caseDatabase", "org.h2.Driver")
        transaction {
            SchemaUtils.create(CaseDatabase)
//                insertInitialData()
        }
    }

    fun insertToDatabase(caseDbo: CaseDbo) {
        CaseDatabase.insert {
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
            CaseDatabase.update({ CaseDatabase.id eq caseId }) { caseDatabase ->
                caseDatabase[lowestPrice] = marketOverviewDto.lowestPrice
                caseDatabase[volume] = marketOverviewDto.volume
                caseDatabase[medianPrice] = marketOverviewDto.medianPrice
            }
        }
    }
}