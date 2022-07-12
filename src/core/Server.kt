package core

import overview.data.database.CaseStorage
import overview.data.repository.DatabaseRepository
import overview.domain.repository.CaseRepository
import overview.domain.usecase.UpdateInfoUseCase
import invest.data.database.repository.AnalyticalDetailsRepository
import invest.data.database.repository.DailySellHistoryTableRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi


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
//            caseRepository.tickFlow(1800000L).collect {
//                updateInfoUseCase.updateInfo()
//            }
        }
        embeddedServer(Netty, port = (System.getenv("PORT")?:"5000").toInt()) {
            install(ContentNegotiation) { json() }
            routing {
                get("/Errors") {
                    val response = "Reasons for errors:" +
                            "\n1. The price of the case is in decline" +
                            "\n2. One or more Case names was not supported"
                    call.respond(response)
                }
                get("/ForGoogleSheets"){
                    val response = caseRepository.getCaseForGoogleSheets("Chroma%20Case")
                    call.respond(response)
                }
                get("/getCase") {
                    val response = caseRepository.getCaseResponse()
                    call.respond(response)
                }
                get("/getAnalyticalDetails") {
                    val response = analyticalDetailsRepository.getAnalyticalDetailsResponse()
                        .filter { !it.monthlySharpRatio.isNaN() }
                    call.respond(response)
                }
            }
        }.start(wait = true)
    }
}