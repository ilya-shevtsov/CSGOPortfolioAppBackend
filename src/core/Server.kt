package core

import data.database.CaseStorage
import domain.repository.CaseRepository
import data.repository.DatabaseRepository
import domain.usecase.UpdateInfoUseCase
import invest.SellHistoryRepository
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
import kotlinx.serialization.ExperimentalSerializationApi
import java.io.File

class Server {

    private val caseRepository = CaseRepository()
    private val sellHistoryRepository = SellHistoryRepository()
    private val databaseRepository = DatabaseRepository()
    private val updateInfoUseCase = UpdateInfoUseCase(caseRepository, databaseRepository)

    @ExperimentalCoroutinesApi
    @ExperimentalSerializationApi
    fun start() {
        CaseStorage.createCaseDatabase()
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
                get("/getData") {
//                    val response = sellHistoryRepository.calculateSharpRatioFromJSON("/caseJson/Clutch Case.json")
                    val response = notSure("resources/caseJson")
                    call.respond(response)

                }
            }
        }.start(wait = true)


    }

    fun notSure(resourcePath:String) {

        File(resourcePath).walk().forEach {file ->
            val fileToString = file.toString()

            val filePath = fileToString
                .replace("resources\\","")
                .replace("""\""","/")
            val filePathNew = "/$filePath"

            val fileName = filePath
                .replace(".json","")
                .replace("resources\\caseJson\\","")
            println(filePathNew)
            val response = sellHistoryRepository.calculateSharpRatioFromJSON(filePathNew)
            println(response)
        }
    }
}