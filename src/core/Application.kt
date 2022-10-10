package core


import features.caseanalytics.data.AnalyticalDetailsRepository
import features.caseanalytics.data.DailySellHistoryTableRepository
import features.caseportfolio.data.PortfolioRepositoryImpl
import features.caseportfolio.data.tables.PortfolioStorage
import features.caseportfolio.data.entities.AddedCaseDto
import features.caseportfolio.data.entities.AddedCaseDtoMapper
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.serialization.ExperimentalSerializationApi
import features.caseoverview.data.DatabaseRepository
import features.caseoverview.domain.CaseRepository
import features.caseoverview.domain.usecases.UpdateInfoUseCase
import features.caseoverview.data.tables.CaseStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import org.jetbrains.exposed.sql.transactions.transaction
import features.currency.PreferredCurrencyDto


fun main(args: Array<String>): Unit = EngineMain.main(args)

@ExperimentalSerializationApi
@ExperimentalCoroutinesApi


var preferredCurrency = PreferredCurrencyDto(1)


@OptIn(ExperimentalCoroutinesApi::class, ExperimentalSerializationApi::class)
fun Application.module() {

    val portfolioRepositoryImpl = PortfolioRepositoryImpl()
    val caseRepository = CaseRepository()
    val databaseRepository = DatabaseRepository()
    val updateInfoUseCase = UpdateInfoUseCase(caseRepository, databaseRepository)

    val dailySellHistoryTableRepository = DailySellHistoryTableRepository()
    val analyticalDetailsRepository = AnalyticalDetailsRepository()

    CaseStorage.createDatabase()
    CoroutineScope(Dispatchers.Default).launch {
        caseRepository.tickFlow(1800000000L).collect {
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
//            updateInfoUseCase.updateInfo()
            val response = caseRepository.getCaseResponse()
            call.respond(response)
        }

        get("/getPreferredCurrency") {
            val response = preferredCurrency
            call.respond(response)
        }

        get("/getPortfolioData") {
            val response = portfolioRepositoryImpl.getPortfolioData().sortedByDescending {
                it.overallValue
            }
            call.respond(response)
        }

        get("/getAnalyticalDetails") {
            val response = analyticalDetailsRepository.getAnalyticalDetailsResponse()
                .filter { !it.monthlySharpRatio.isNaN() }
            call.respond(response)
        }

        post("/postPreferredCurrency") {
            val postBody = call.receive<PreferredCurrencyDto>()
            preferredCurrency = PreferredCurrencyDto(postBody.preferredCurrency)
            call.respond(postBody)
        }
        post("/postAddedCase") {
            val postBody = call.receive<AddedCaseDto>()
            val addedCase = AddedCaseDto(
                postBody.name, postBody.amount, postBody.purchasePrice
            )
            transaction {
                val portfolioItemDbo = AddedCaseDtoMapper.map(addedCase)
                PortfolioStorage.updateCaseData(portfolioItemDbo)
            }
            call.respond(postBody)
        }
    }
}

