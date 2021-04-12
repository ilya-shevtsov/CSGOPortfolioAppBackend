package domain.repository

import data.model.CaseDataResponseMapper
import data.model.SimpleCaseDto
import data.api.ApiTools
import data.database.CaseDatabase
import data.database.CaseDbo
import domain.model.CaseDto
import domain.model.CaseDtoMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class CaseRepository {

    suspend fun getMarketOverview(caseName: String): Flow<SimpleCaseDto> = flow {
        val response = ApiTools.getApiService()
            .getCase(
                appId = 730,
                currency = 5,
                caseName = caseName
            )
        val simpleCaseDto = CaseDataResponseMapper.map(response, caseName)
        emit(simpleCaseDto)
    }.retryWhen { _, _ ->
        delay(60000)
        true
    }

    fun getCaseResponse(): List<CaseDto> {
        return transaction {
            CaseDatabase.selectAll().map { CaseDatabase.toCaseDbo(it) }
        }.map { case -> CaseDtoMapper.map(case) }
    }

    @ExperimentalCoroutinesApi
    fun tickFlow(millis: Long) = callbackFlow<Int> {
        val timer = Timer()
        var time = 0
        timer.scheduleAtFixedRate(
            object : TimerTask() {
                override fun run() {
                    try {
                        offer(time)
                    } catch (e: Exception) {
                    }
                    time += 1
                }
            },
            0,
            millis
        )
        awaitClose {
            timer.cancel()
        }
    }
}