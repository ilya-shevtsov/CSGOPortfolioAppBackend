package com.ilya.shevtsov.casewatcher

import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.serialization.*

fun main(args: Array<String>) {
    embeddedServer(Netty, 8080) {
        install(ContentNegotiation) { json() }

        routing {
            get("/getCase") {
                call.respond(listOf(CaseDto("Chroma Case",
                        "08.01.2015",
                        "Inactive (Rare)",
                        64.23, 3803,
                        62.54,
                        "https://api.steamapis.com/image/item/730/Chroma%20Case")))
            }
        }
    }.start(wait = true)
}
