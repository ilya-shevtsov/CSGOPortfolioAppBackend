package core

import data.database.CaseStorage
import data.repository.DatabaseRepository
import domain.repository.CaseRepository
import domain.usecase.UpdateInfoUseCase
import invest.data.database.repository.AnalyticalDetailsRepository
import invest.data.database.repository.DailySellHistoryTableRepository
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ofPattern
import java.util.*


class Server {

    private val caseRepository = CaseRepository()
    private val databaseRepository = DatabaseRepository()
    private val updateInfoUseCase = UpdateInfoUseCase(caseRepository, databaseRepository)

    private val dailySellHistoryTableRepository = DailySellHistoryTableRepository()
    private val analyticalDetailsRepository = AnalyticalDetailsRepository()

    @ExperimentalCoroutinesApi
    @ExperimentalSerializationApi
    fun start() {

        CaseStorage.createDatabase()
        CoroutineScope(Dispatchers.Default).launch {
            caseRepository.tickFlow(1800000L).collect {
                updateInfoUseCase.updateInfo()
            }
        }
        embeddedServer(Netty, 8080) {
            install(ContentNegotiation) { json() }
            routing {
                get("/Errors") {
                    val response = "Reasons for errors:" +
                            "\n1. The price of the case is in decline" +
                            "\n2. One or more Case names was not supported"
                    call.respond(response)
                }
                get("/getCase") {
                    val response = caseRepository.getCaseResponse()
                    call.respond(response)
                }
                get("/getAnalyticalDetails") {
                    val response = analyticalDetailsRepository.getAnalyticalDetailsResponse()
                    call.respond(response)
                }
            }
        }.start(wait = true)
    }
}