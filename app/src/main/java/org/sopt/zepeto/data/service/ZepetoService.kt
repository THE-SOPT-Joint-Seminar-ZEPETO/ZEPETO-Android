package org.sopt.zepeto.data.service

import okhttp3.MultipartBody
import org.sopt.zepeto.data.response.BaseResponse
import org.sopt.zepeto.data.response.ResponseFeed
import org.sopt.zepeto.data.response.ResponseImages
import org.sopt.zepeto.data.response.UploadPostResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ZepetoService {
    @GET("images")
    fun getImages(): Call<BaseResponse<List<ResponseImages>>>

    @GET("feed")
    fun getFeed() : Call<BaseResponse<ResponseFeed>>

    @Multipart
    @POST("feed")
    fun uploadPost(
        @Part("contents") contents: String,
        @Part image: MultipartBody.Part
    ): Call<BaseResponse<UploadPostResponse>>
}
