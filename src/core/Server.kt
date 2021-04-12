package core

import domain.repository.Repository
import data.database.CaseDatabase
import data.database.CaseDbo
import domain.model.CaseDto
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
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*


class Server {

    private val repository = Repository()
    private val databaseRepository = DatabaseRepository()



    @ExperimentalCoroutinesApi
    fun start() {
        databaseRepository.initDatabase()
        CoroutineScope(Dispatchers.Default).launch {
            repository.tickFlow(300000L).collect {
                databaseRepository.updateInfo()
            }
        }
        embeddedServer(Netty, 8080) {
            install(ContentNegotiation) { json() }
            routing {
                get("/getCase") {
                    val response = repository.getCaseResponse()
                    call.respond(response)
                }
            }
        }.start(wait = true)
    }
}