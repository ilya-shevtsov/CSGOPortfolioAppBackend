package domain.repository

import model.CaseDataResponseMapper
import model.SimpleCaseDto
import data.api.ApiTools
import data.database.CaseDatabase
import data.database.CaseDbo
import domain.model.CaseDto
import io.ktor.utils.io.errors.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
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

    suspend fun getMarketOverview(caseName: String): Flow<SimpleCaseDto> = flow {
        val response = ApiTools.getApiService()
            .getCase(
                appId = 730,
                currency = 5,
                caseName = caseName
            )
        val simpleCaseDto = CaseDataResponseMapper.map(response, caseName)
        emit(simpleCaseDto)
    }.retryWhen { cause, _ ->
        if (cause is IOException) {
            delay(60000)
            true
        } else {
            false
        }
    }

    suspend fun updateInfo() {
        val caseList = getCaseList()
        caseList.forEach { case ->
            getMarketOverview(case.caseAccess)
                .catch { println("Error") }
                .collect { simpleCaseDto ->
                transaction {
                    CaseDatabase.update({ CaseDatabase.id eq case.id }) { caseDatabase ->
                        caseDatabase[lowestPrice] = simpleCaseDto.lowestPrice
                        caseDatabase[volume] = simpleCaseDto.volume
                        caseDatabase[medianPrice] = simpleCaseDto.medianPrice
                    }
                }
            }
        }
    }

    fun getCaseList(): List<CaseDbo> {
        return transaction {
            CaseDatabase.selectAll().map { CaseDatabase.toCaseDbo(it) }
        }
    }
}