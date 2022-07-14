package core

import overview.data.database.CaseStorage
import overview.data.repository.DatabaseRepository
import overview.domain.repository.CaseRepository
import overview.domain.usecase.UpdateInfoUseCase
import invest.data.database.repository.AnalyticalDetailsRepository
import invest.data.database.repository.DailySellHistoryTableRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.contentnegotiation.*

import io.ktor.serialization.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi


//class Server {
//
//
//
//    @ExperimentalCoroutinesApi
//    @ExperimentalSerializationApi
//    fun start() {
//

//    }