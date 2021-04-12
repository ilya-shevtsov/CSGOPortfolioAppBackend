package core

import domain.repository.CaseRepository
import data.repository.DatabaseRepository
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
    private val databaseRepository = DatabaseRepository()

    @ExperimentalCoroutinesApi
    fun start() {
        databaseRepository.initDatabase()
        CoroutineScope(Dispatchers.Default).launch {
            caseRepository.tickFlow(300000L).collect {
                databaseRepository.updateInfo()
            }
        }
        embeddedServer(Netty, 8080) {
            install(ContentNegotiation) { json() }
            routing {
                get("/getCase") {
                    val response = caseRepository.getCaseResponse()
                    call.respond(response)
                }
            }
        }.start(wait = true)
    }
}