package org.sopt.zepeto.data.response

import com.google.gson.annotations.SerializedName

data class UploadPostResponse(
    @SerializedName("_id")
    val id: String,
    val content: String,
    val link: String
)
