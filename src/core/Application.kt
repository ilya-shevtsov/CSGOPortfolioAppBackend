package core


import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
@ExperimentalCoroutinesApi
fun main(){
    val server = Server()
    server.start()
}

//fun Application.module() {
//    routing {
//        get("/") {
//            call.respondText("IT WORKS!")
//        }
//    }
//}
