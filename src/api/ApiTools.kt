package api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class ApiTools {

    companion object {

        private var serverApi: ServerApi? = null

        private fun getClient(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        @ExperimentalSerializationApi
        private fun getCaseRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://steamcommunity.com/market/")
                .client(getClient())
                .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
                .build()
        }

        @ExperimentalSerializationApi
        fun getCaseApiService(): ServerApi {
            if (serverApi == null) {
                serverApi = getCaseRetrofit().create(ServerApi::class.java)
            }
            return serverApi!!
        }
    }
}