package org.sopt.zepeto

data class MakeData(
    val title: String,
    val profile: String,
    val description: String,
    val images: List<MakeContentsData>
)

data class MakeContentsData(
    val url: String,
    val isVideo: Boolean,
    val isStared: Boolean
)