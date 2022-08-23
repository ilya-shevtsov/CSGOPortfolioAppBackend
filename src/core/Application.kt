package core


import invest.data.database.repository.AnalyticalDetailsRepository
import invest.data.database.repository.DailySellHistoryTableRepository
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.serialization.ExperimentalSerializationApi
import overview.data.repository.DatabaseRepository
import overview.domain.repository.CaseRepository
import overview.domain.usecase.UpdateInfoUseCase
import overview.data.database.CaseStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import overview.data.model.preferredcurrency.PreferredCurrencyDto


fun main(args: Array<String>): Unit = EngineMain.main(args)
@ExperimentalSerializationApi
@ExperimentalCoroutinesApi


var preferredCurrency = PreferredCurrencyDto(0)
@OptIn(ExperimentalCoroutinesApi::class, ExperimentalSerializationApi::class)
fun Application.module() {

    val caseRepository = CaseRepository()
    val databaseRepository = DatabaseRepository()
    val updateInfoUseCase = UpdateInfoUseCase(caseRepository, databaseRepository)

    val dailySellHistoryTableRepository = DailySellHistoryTableRepository()
    val analyticalDetailsRepository = AnalyticalDetailsRepository()

    CaseStorage.createDatabase()
    CoroutineScope(Dispatchers.Default).launch {
        caseRepository.tickFlow(18000000L).collect {
            updateInfoUseCase.updateInfo()
        }
    }

    install(ContentNegotiation) {
        json()
    }
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

        post("/getPreferredCurrency"){
            val postBody = call.receive<PreferredCurrencyDto>()
            preferredCurrency = PreferredCurrencyDto(postBody.preferredCurrency)
            updateInfoUseCase.updateInfo()
            println("This is the postBody $postBody")
            call.respond(postBody)
        }
//        get("/getAnalyticalDetails") {
//            val response = analyticalDetailsRepository.getAnalyticalDetailsResponse()
//                .filter { !it.monthlySharpRatio.isNaN() }
//            call.respond(response)
//        }
    }
}
//
