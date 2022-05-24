package org.sopt.zepeto.data.service

import org.sopt.zepeto.data.response.BaseResponse
import org.sopt.zepeto.data.response.ResponseImages
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ZepetoService {
    @GET("images")
    fun getImages(): Call<BaseResponse<List<ResponseImages>>>
}