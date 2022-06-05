package org.sopt.zepeto.data.response

import com.google.gson.annotations.SerializedName

data class ResponseImages(
    val _id: String,
    val title: String,
    val description: String,
    @SerializedName("profileImage")
    val profileImgUrl: String,
    val images: List<Images>
)

data class Images(
    @SerializedName("imageUrl")
    val imgUrl: String,
    val isVideo: Boolean,
    val isStared: Boolean
)
