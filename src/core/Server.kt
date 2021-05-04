package core

import data.database.CaseStorage
import domain.repository.CaseRepository
import data.repository.DatabaseRepository
import domain.usecase.UpdateInfoUseCase
import invest.domain.repository.SellHistoryRepository
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
                            "\n1. The price of the case is in decline"+
                            "\n2. One or more Case names was not supported"
                    call.respond(response)
                }
                get("/getCase") {
                    val response = caseRepository.getCaseResponse()
                    call.respond(response)
                }
                get("/getSharpRatio/monthly") {
                    val sharpRatioList = sellHistoryRepository
                        .prepareSharpRatioResponse("resources/caseJson",30)
                    call.respond(sharpRatioList)
                }

                get("/getSharpRatio/daily") {
                    val sharpRatioList = sellHistoryRepository
                        .prepareSharpRatioResponse("resources/caseJson",1)
                    call.respond(sharpRatioList)
                }
                get("/getStandardDeviation/monthly") {
                    val standardDeviationList = sellHistoryRepository
                        .prepareStandardDeviationResponse("resources/caseJson",30)
                    call.respond(standardDeviationList)
                }
                get("/getStandardDeviation/daily") {
                    val standardDeviationList = sellHistoryRepository
                        .prepareStandardDeviationResponse("resources/caseJson",1)
                    call.respond(standardDeviationList)
                }
            }
        }.start(wait = true)
    }
}