package com.dyna.domain.dto

data class PageParam(
    val current: Int = 1,
    val pageSize: Int = 10,
)