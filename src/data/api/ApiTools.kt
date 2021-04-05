package com.ilya.shevtsov.casewatcher.data.api

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

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl("https://steamcommunity.com/market/")
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create())
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }

        fun getApiService(): ServerApi {
            if (serverApi == null) {
                serverApi = getRetrofit().create(ServerApi::class.java)
            }
            return serverApi!!
        }
    }
}