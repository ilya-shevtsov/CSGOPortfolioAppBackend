package overview.domain.repository

import overview.data.model.marketoverview.MarketOverviewDtoMapper
import overview.domain.model.marketoverview.MarketOverview
import api.ApiTools
import overview.data.database.CaseTable
import overview.data.model.case.CaseDboMapper
import overview.domain.model.case.CaseDto
import overview.domain.model.case.CaseDtoMapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
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