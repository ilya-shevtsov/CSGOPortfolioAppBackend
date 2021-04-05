package com.ilya.shevtsov.casewatcher.core

import com.ilya.shevtsov.casewatcher.Model.CaseDataResponseMapper
import com.ilya.shevtsov.casewatcher.Repository
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

class Server {

    private val repository = Repository()

    fun start() {
        embeddedServer(Netty, 8080) {
            install(ContentNegotiation) { json() }
            routing {
                get("/getCase") {
                    val simpleCaseDtoResponse = repository.getSimpleCaseDto("Chroma%20Case")
                    call.respond(simpleCaseDtoResponse)
                }
            }
        }.start(wait = true)
    }
}