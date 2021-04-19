package invest

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*

class InvestRepository{

    suspend fun getCasePriceData():String{
        val client = HttpClient(CIO)
        return client.request("http://127.0.0.1:8080/getInvest") {
        }
    }
}