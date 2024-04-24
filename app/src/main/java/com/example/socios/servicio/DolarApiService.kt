package com.example.socios.servicio

import retrofit2.Response
import retrofit2.http.GET

interface DolarApi {
    @GET("get-dolar-oficial")
    suspend fun getOfficialDolar(): Response<DolarResponse>
}


data class DolarResponse(
    val value: Double
)

