package org.sopt.zepeto.data.service

import org.sopt.zepeto.data.response.BaseResponse
import org.sopt.zepeto.data.response.ResponseFeed
import org.sopt.zepeto.data.response.ResponseImages
import retrofit2.Call
import retrofit2.http.GET

interface ZepetoService {
    @GET("images")
    fun getImages(): Call<BaseResponse<List<ResponseImages>>>

    @GET("feed")
    fun getFeed() : Call<BaseResponse<ResponseFeed>>
}