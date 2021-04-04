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
                call.respond(listOf(
                        CaseDto(
                                "Chroma Case",
                                "08.01.2015",
                                "Inactive (Rare)",
                                64.23,
                                3803,
                                62.54,
                                "https://api.steamapis.com/image/item/730/Chroma%20Case",
                                "The Chroma Case is a weapon case consisting of 14 community-desgined weapon skins released as part of the January 8, 2015 update. It requires a Chroma Case Key to be opened. The Chroma Case also has six exclusive community created knife finishes: Damascus Steel, Doppler, Marble Fade, Tiger Tooth, Rust Coat, and Ultraviolet. The Spectrum Case and Spectrum 2 Case includes these Chroma finishes on the Huntsman Knife, Butterfly Knife, Falchion Knife, Shadow Daggers and the Bowie Knife. The Prisma Case contains these Chroma finishes on the Navaja Knife, Stiletto Knife, Talon Knife, and the Ursus Knife."),
                        CaseDto(
                                "Operation Breakout Weapon Case",
                                "01.07.2014",
                                "Inactive (Rare)",
                                152.77,
                                16224,
                                153.55,
                                "https://api.steamapis.com/image/item/730/Operation%20Breakout%20Weapon%20Case",
                                "The Operation Breakout Case is a weapon case consisting of 14 community-created weapon skins released as part of Operation Breakout with the July 1, 2014 update. Like the Operation Phoenix Weapon Case during Operation Phoenix, Operation Breakout Coin holders received this case. Once the operation ended on October 2, 2014, the weapon case became available for all CS:GO players."))
                )
            }
        }
    }.start(wait = true)
}
