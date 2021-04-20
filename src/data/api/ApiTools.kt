package data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getCaseApiService(): ServerApi {
            if (serverApi == null) {
                serverApi = getCaseRetrofit().create(ServerApi::class.java)
            }
            return serverApi!!
        }
//        private fun getSellHistoryRetrofit(): Retrofit {
//            return Retrofit.Builder()
//                .baseUrl("http://192.168.1.89:8080/")
//                .client(getClient())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//        }
//
//        fun getSellHistoryApiService(): ServerApi {
//            if (serverApi == null) {
//                serverApi = getSellHistoryRetrofit().create(ServerApi::class.java)
//            }
//            return serverApi!!
//        }
    }
}