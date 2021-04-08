package core

import domain.repository.Repository
import data.database.CaseDatabase
import domain.model.CaseDto
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class Server {

    private val repository = Repository()

    private fun insertData() {
        CaseDatabase.insert {
            it[caseAccess] = "Chroma%20Case"
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
        CaseDatabase.insert {
            it[caseAccess] = "Chroma%202%20Case"
            it[name] = "Chroma 2 Case"
            it[releaseDate] = "15.04.2015"
            it[dropStatus] = "Inactive (Rare)"
            it[lowestPrice] = 23.00
            it[volume] = 21684
            it[medianPrice] = 23.00
            it[imageUrl] = "https://api.steamapis.com/image/item/730/Chroma%202%20Case"
            it[description] =
                "The Chroma 2 Case is a weapon case consisting of 15 community-made weapon skins released as part of the April 15, 2015 update. It requires a Chroma 2 Case Key to be opened."
        }
    }


    private fun initDatabase() {
        Database.connect("jdbc:h2:mem:regular;DB_CLOSE_DELAY=-1;", "org.h2.Driver")
        transaction {
            SchemaUtils.create(CaseDatabase)
            insertData()
        }
    }

    private suspend fun getCaseResponse(): List<CaseDto> {
        repository.updateInfo()
        return transaction {
            CaseDatabase.selectAll().map { CaseDatabase.toCaseDbo(it) }
        }.map { case -> repository.toCaseDto(case) }
    }

    fun start() {
        initDatabase()
        embeddedServer(Netty, 8080) {
            install(ContentNegotiation) { json() }
            routing {
                get("/getCase") {
                    val response = getCaseResponse()
                    call.respond(response)
                }
            }
        }.start(wait = true)
    }
}

