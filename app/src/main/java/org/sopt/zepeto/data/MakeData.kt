package org.sopt.zepeto.data

data class MakeData(
    val title: String,
    val profileImgUrl: String,
    val description: String,
    val images: List<MakeContentsData>
)

data class MakeContentsData(
    val imgUrl: String,
    val isVideo: Boolean,
    val isStared: Boolean
)