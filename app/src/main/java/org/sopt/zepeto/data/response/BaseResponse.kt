package org.sopt.zepeto.data.response

data class BaseResponse<T>(
    val status: Int,
    val message: String,
    val data: T? = null
)
