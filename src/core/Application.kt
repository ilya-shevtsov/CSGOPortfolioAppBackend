package core


import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
@ExperimentalCoroutinesApi
fun main(){
    embeddedServer(Netty, port = (System.getenv("PORT")?:"5000").toInt()) {
        install(ContentNegotiation) {
            json()
        }
        module()
    }.start(wait = true)
}

fun Application.module() {
    routing {
        get("/getCase") {
//            val response = caseRepository.getCaseResponse()
            call.respondText("response")
        }
    }
}
