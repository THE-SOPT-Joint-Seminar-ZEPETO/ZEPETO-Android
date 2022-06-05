package org.sopt.zepeto.data.response

import com.google.gson.annotations.SerializedName

data class ResponseFeed(
    val _id: String,
    @SerializedName("image")
    val imageUrl: String,
    val content: String,
    val userName: String,
    @SerializedName("userProfileImage")
    val userProfileImageUrl: String
)
