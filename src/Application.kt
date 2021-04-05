package com.ilya.shevtsov.casewatcher

import com.ilya.shevtsov.casewatcher.Model.SimpleResponse
import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.serialization.*
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun main() {

    suspend fun getSimpleResponse(caseName: String): SimpleResponse {
        return ApiTools.getApiService()
            .getCase(
                appId = 730,
                currency = 5,
                caseName = caseName
            )
    }

    embeddedServer(Netty, 8080) {
        install(ContentNegotiation) { json() }
        routing {
            get("/getCase") {
                call.respond(getSimpleResponse("Chroma%20Case"))
            }
        }
    }.start(wait = true)
}
