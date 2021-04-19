package core

import data.database.CaseStorage
import domain.repository.CaseRepository
import data.repository.DatabaseRepository
import domain.usecase.UpdateInfoUseCase
import invest.InvestRepository
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

class Server {

    private val caseRepository = CaseRepository()
    private val investRepository = InvestRepository()
    private val databaseRepository = DatabaseRepository()
    private val updateInfoUseCase = UpdateInfoUseCase(caseRepository, databaseRepository)

    @ExperimentalCoroutinesApi
    fun start() {
        CaseStorage.createCaseDatabase()
        databaseRepository.insertInitialData()

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
                get("/getInvest"){
                    val response = """{"success":true,"price_prefix":"","price_suffix":"pуб.","prices":[["Feb 16 2018 01: +0",678.837,"58774"],["Feb 17 2018 01: +0",386.477,"67111"],["Feb 18 2018 01: +0",306.325,"62299"],["Feb 19 2018 01: +0",299.748,"50165"],["Feb 20 2018 01: +0",274.909,"46028"],["Feb 21 2018 01: +0",255.226,"45406"],["Feb 22 2018 01: +0",218.398,"49342"],["Feb 23 2018 01: +0",192.557,"56360"],["Feb 24 2018 01: +0",172.448,"61486"],["Feb 25 2018 01: +0",144.249,"62297"],["Feb 26 2018 01: +0",143.576,"50454"],["Feb 27 2018 01: +0",145.944,"47847"],["Feb 28 2018 01: +0",149.933,"45872"],["Mar 01 2018 01: +0",145.537,"46928"],["Mar 02 2018 01: +0",142.398,"52559"],["Mar 03 2018 01: +0",115.846,"61120"],["Mar 04 2018 01: +0",91.122,"65102"],["Mar 05 2018 01: +0",90.609,"50573"],["Mar 06 2018 01: +0",92.349,"44644"],["Mar 07 2018 01: +0",94.022,"44076"],["Mar 08 2018 01: +0",86.494,"47470"],["Mar 09 2018 01: +0",81.307,"52565"],["Mar 10 2018 01: +0",75.61,"56621"],["Mar 11 2018 01: +0",67.902,"55508"],["Mar 12 2018 01: +0",64.422,"44889"],["Mar 13 2018 01: +0",63.26,"44060"],["Mar 14 2018 01: +0",61.387,"43027"],["Mar 15 2018 01: +0",61.163,"42001"],["Mar 16 2018 01: +0",62.06,"48983"]]}"""
                    call.respond(response)
                }
                get("/getRealInvest"){
                    val response = investRepository.getCasePriceData()
                    call.respond(response)
                }
            }
        }.start(wait = true)
    }
}