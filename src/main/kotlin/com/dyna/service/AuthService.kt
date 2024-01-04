package com.dyna.service

import com.dyna.domain.dto.LoginDto

interface AuthService {
    fun login(params: LoginDto): String
}