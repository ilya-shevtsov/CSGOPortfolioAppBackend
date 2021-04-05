package com.ilya.shevtsov.casewatcher.core

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
                    val caseDto = repository.getCaseDto(
                        simpleCaseDto = repository.getSimpleCaseDto("Chroma%20Case"),
                        releaseDate = "08.01.2015",
                        dropStatus = "Inactive (Rare)",
                        imageUrl = "https://api.steamapis.com/image/item/730/Chroma%20Case",
                        description = "The Chroma Case is a weapon case consisting of 14 community-desgined weapon skins released as part of the January 8, 2015 update. It requires a Chroma Case Key to be opened. The Chroma Case also has six exclusive community created knife finishes: Damascus Steel, Doppler, Marble Fade, Tiger Tooth, Rust Coat, and Ultraviolet. The Spectrum Case and Spectrum 2 Case includes these Chroma finishes on the Huntsman Knife, Butterfly Knife, Falchion Knife, Shadow Daggers and the Bowie Knife. The Prisma Case contains these Chroma finishes on the Navaja Knife, Stiletto Knife, Talon Knife, and the Ursus Knife."
                    )
                    call.respond(caseDto)
                }
            }
        }.start(wait = true)
    }
}