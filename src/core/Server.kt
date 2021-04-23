package core

import data.database.CaseStorage
import domain.repository.CaseRepository
import data.repository.DatabaseRepository
import domain.usecase.UpdateInfoUseCase
import invest.SellHistoryRepository
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
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import kotlinx.serialization.ExperimentalSerializationApi

class Server {

    private val caseRepository = CaseRepository()
    private val sellHistoryRepository = SellHistoryRepository()
    private val databaseRepository = DatabaseRepository()
    private val updateInfoUseCase = UpdateInfoUseCase(caseRepository, databaseRepository)

    @ExperimentalCoroutinesApi
    @ExperimentalSerializationApi
    fun start() {
        CaseStorage.createCaseDatabase()
        CoroutineScope(Dispatchers.Default).launch {
            caseRepository.tickFlow(300000L).collect {
                updateInfoUseCase.updateInfo()
            }
        }
        embeddedServer(Netty, 8080) {
            install(ContentNegotiation) { json() }
            routing {
                get("/getCase") {
                    val response = caseRepository.getCaseResponse()
                    call.respond(response)
                }
                get("/getData") {
                    val response = sellHistoryRepository.calculateSharpRatioFromJSON("/chromaCaseDSH.json")
                    call.respond("This is the Sharp Ratio: $response")
                }
            }
        }.start(wait = true)
    }

}