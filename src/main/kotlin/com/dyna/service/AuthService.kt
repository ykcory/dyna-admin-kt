package com.dyna.service

import com.dyna.domain.dto.LoginParams

interface AuthService {
    fun login(params: LoginParams): String
}