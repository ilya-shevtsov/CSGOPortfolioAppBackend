package data.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class ApiTools {

    companion object {

        private var serverApi: ServerApi? = null

        private fun getClient(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        private fun getCaseRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://steamcommunity.com/market/")
                .client(getClient())
                .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
                .build()
        }

        fun getCaseApiService(): ServerApi {
            if (serverApi == null) {
                serverApi = getCaseRetrofit().create(ServerApi::class.java)
            }
            return serverApi!!
        }
    }
}