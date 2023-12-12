package com.dyna.domain.entity

data class Response<T>(
    val code: Number,
    val success: Boolean,
    val message: String,
    val data: T?
)

object R {
    fun <T> success(data: T, message: String = "success"): Response<T> {
        return Response(0, true, message, data)
    }

    fun <T> error(message: String): Response<T> {
        return Response(-1, false, message, null)
    }
}   