package features.caseoverview.domain

import features.caseoverview.data.entities.MarketOverviewDtoMapper
import api.ApiTools
import features.caseoverview.data.tables.CaseTable
import features.caseoverview.data.entities.CaseDboMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import features.caseoverview.data.entities.CaseDto
import features.caseoverview.data.entities.CaseDtoMapper
import features.caseoverview.domain.entities.MarketOverview
import java.util.*

class CaseRepository {

//    @ExperimentalSerializationApi
//    fun getCaseForGoogleSheets(caseName: String): Flow<MarketOverview> = flow {
//        val response = ApiTools.getCaseApiService()
//            .getCase(
//                appId = 730,
//                currency = 5,
//                caseName = caseName
//            )
//        val marketOverviewDto = MarketOverviewDtoMapper.map(response, caseName)
//        emit(marketOverviewDto)
//    }.retryWhen { _, _ ->
//        delay(60000)
//        true
//    }

    @ExperimentalSerializationApi
    suspend fun getMarketOverview(caseName: String,currency: Int): Flow<MarketOverview> = flow {
        val response = ApiTools.getCaseApiService()
            .getCase(
                appId = 730,
                currency = currency,
                caseName = caseName
            )
        val marketOverviewDto = MarketOverviewDtoMapper.map(response, caseName)
        emit(marketOverviewDto)
    }.retryWhen { _, _ ->
        delay(60000)
        true
    }

    fun getCaseResponse(): List<CaseDto> {
        return transaction {
            CaseTable.selectAll().map { CaseDboMapper.map(it) }
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
                        trySend(time).isSuccess
                    } catch (_: Exception) {
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