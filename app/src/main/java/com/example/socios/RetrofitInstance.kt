package com.example.socios

import com.example.socios.servicio.DolarApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://dolarapi.com/docs/operations/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val dolarApi: DolarApi by lazy {
        retrofit.create(DolarApi::class.java)
    }
}
