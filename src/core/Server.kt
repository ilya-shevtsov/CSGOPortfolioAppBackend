package com.ilya.shevtsov.casewatcher.core

import com.ilya.shevtsov.casewatcher.Model.CaseDto
import com.ilya.shevtsov.casewatcher.Repository
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class Server {

    private val repository = Repository()


    object CaseList : Table() {
        val id: Column<Int> = integer("id").autoIncrement()
        val name: Column<String> = varchar("name", 255)
        val releaseDate: Column<String> = varchar("releaseDate", 255)
        val dropStatus: Column<String> = varchar("dropStatus", 255)
        val lowestPrice: Column<Double> = double("lowestPrice")
        val volume: Column<Int> = integer("volume")
        val medianPrice: Column<Double> = double("medianPrice")
        val imageUrl: Column<String> = varchar("imageUrl", 255)
        val description: Column<String> = varchar("description", 1000)

        override val primaryKey = PrimaryKey(id, name = "PK_Case_ID")

        fun toCase(row: ResultRow): CaseDto =
            CaseDto(
                id = row[id],
                name = row[name],
                releaseDate = row[releaseDate],
                dropStatus = row[dropStatus],
                lowestPrice = row[lowestPrice],
                volume = row[volume],
                medianPrice = row[medianPrice],
                imageUrl = row[imageUrl],
                description = row[description]
            )
    }

    fun start() {
        embeddedServer(Netty, 8080) {
            install(ContentNegotiation) { json() }

            Database.connect("jdbc:h2:mem:regular;DB_CLOSE_DELAY=-1;", "org.h2.Driver")
            transaction {
                SchemaUtils.create(CaseList)

                CaseList.insert {
                    it[name] = "Chroma Case"
                    it[releaseDate] = "08.01.2015"
                    it[dropStatus] = "Inactive (Rare)"
                    it[lowestPrice] = 64.23
                    it[volume] = 3803
                    it[medianPrice] = 62.54
                    it[imageUrl] = "https://api.steamapis.com/image/item/730/Chroma%20Case"
                    it[description] =
                        "The Chroma Case is a weapon case consisting of 14 community-desgined weapon skins released as part of the January 8, 2015 update. It requires a Chroma Case Key to be opened. The Chroma Case also has six exclusive community created knife finishes: Damascus Steel, Doppler, Marble Fade, Tiger Tooth, Rust Coat, and Ultraviolet. The Spectrum Case and Spectrum 2 Case includes these Chroma finishes on the Huntsman Knife, Butterfly Knife, Falchion Knife, Shadow Daggers and the Bowie Knife. The Prisma Case contains these Chroma finishes on the Navaja Knife, Stiletto Knife, Talon Knife, and the Ursus Knife."

                }
            }
            routing {
                get("/getCase") {
                    val caseListResponse = transaction {
                        CaseList.selectAll().map {
                            CaseList.toCase(it)
                        }
                    }
                    call.response(caseListResponse)
                }
            }
        }.start(wait = true)
    }
}