package com.example.bustime.service

import com.example.bustime.Interfaces.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "http://10.40.1.176:8080/"

    // Interceptor para mostrar el log del cuerpo de las peticiones/respuestas
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Cliente OkHttp con interceptor
    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    // Retrofit usando el cliente con logs
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client) // <-- Se asegura de usar el interceptor
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Servicio API que usa el Retrofit con logging
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}
