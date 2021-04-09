package domain.repository

import model.CaseDataResponseMapper
import model.SimpleCaseDto
import data.api.ApiTools
import data.database.CaseDatabase
import data.database.CaseDbo
import domain.model.CaseDto
import okhttp3.internal.wait
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class Repository {

    fun toCaseDto(caseDbo: CaseDbo): CaseDto {
        return CaseDto(
            name = caseDbo.name,
            releaseDate = caseDbo.releaseDate,
            dropStatus = caseDbo.dropStatus,
            lowestPrice = caseDbo.lowestPrice,
            volume = caseDbo.volume,
            medianPrice = caseDbo.medianPrice,
            imageUrl = caseDbo.imageUrl,
            description = caseDbo.description
        )
    }



    suspend fun getMarketOverview(caseName: String): SimpleCaseDto {
        val simpleResponse = ApiTools.getApiService()
            .getCase(
                appId = 730,
                currency = 5,
                caseName = caseName
            )
            return CaseDataResponseMapper.map(simpleResponse, caseName)
    }

    suspend fun updateInfo() {
        val caseList = transaction {
            CaseDatabase.selectAll().map { CaseDatabase.toCaseDbo(it) }
        }

        caseList.forEach { case ->
            val marketOverview = getMarketOverview(case.caseAccess)

            transaction {
                CaseDatabase.update({ CaseDatabase.id eq case.id }) { caseDatabase ->
                    caseDatabase[lowestPrice] = marketOverview.lowestPrice
                    caseDatabase[volume] = marketOverview.volume
                    caseDatabase[medianPrice] = marketOverview.medianPrice
                }
            }
        }
    }
}

