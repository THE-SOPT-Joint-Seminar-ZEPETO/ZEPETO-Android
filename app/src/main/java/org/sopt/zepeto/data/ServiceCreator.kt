package org.sopt.zepeto.data

import org.sopt.zepeto.data.service.ZepetoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL_ZEPETO = "http://3.39.190.107:5000/"

    private fun buildRetrofit(url: String): Retrofit =
        Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()

    val zepetoService: ZepetoService =
        buildRetrofit(BASE_URL_ZEPETO).create(ZepetoService::class.java)
}