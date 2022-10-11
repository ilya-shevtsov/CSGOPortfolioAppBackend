package core

import core.dependencyInjection.DependencyInjection
import features.caseanalytics.data.AnalyticalDetailsRepository
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import org.jetbrains.exposed.sql.transactions.transaction
import features.currency.PreferredCurrencyDto
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import java.util.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

@ExperimentalSerializationApi
@ExperimentalCoroutinesApi

var preferredCurrency = PreferredCurrencyDto(1)

@OptIn(ExperimentalCoroutinesApi::class, ExperimentalSerializationApi::class)
fun Application.module() {

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

    val dependencyInjection = DependencyInjection()
    val analyticalDetailsRepository = AnalyticalDetailsRepository()

    dependencyInjection.createDataBaseUseCase()
    dependencyInjection.insertInitialDataUseCase()
    CoroutineScope(Dispatchers.Default).launch {
        tickFlow(1800000000L).collect {
            dependencyInjection.updateInfoUseCase()
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
            val response = dependencyInjection.getCaseDataUseCase()
            call.respond(response)
        }

        get("/getPreferredCurrency") {
            val response = preferredCurrency
            call.respond(response)
        }


        get("/getPortfolioData") {
            val response = dependencyInjection.getPortfolioDataUseCase().sortedByDescending {
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
                dependencyInjection.updatePortfolioUseCase(portfolioItemDbo)
            }
            call.respond(postBody)
        }
    }
}

