package com.ilya.shevtsov.casewatcher

import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.serialization.*

fun main(args: Array<String>) {
    embeddedServer(Netty, 8080) {
        install(ContentNegotiation) { json() }

        routing {
            get("/") {
                call.respond(HelloWorldResponse(hello = "lol", world = "kek"))
            }
        }
    }.start(wait = true)
}
