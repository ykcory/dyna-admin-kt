package com.dyna.controller

import com.dyna.domain.entity.R
import com.dyna.domain.entity.Response
import com.dyna.domain.dto.LoginParams
import com.dyna.service.impl.AuthServiceImpl
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Auth", description = "用户认证接口")
@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthServiceImpl
) {
    @Operation(summary = "登录")
    @PostMapping("/login")
    fun login(@RequestBody params: LoginParams): Response<String> {
        return R.success(authService.login(params))
    }

    @Operation(summary = "是否登录")
    @GetMapping("/is-login")
    fun isLogin(): Response<Boolean> {
        return R.success(true)
    }

    @Operation(summary = "获取用户信息")
    @GetMapping("/info")
    fun info(): Response<String> {
        return R.success("")
    }
}