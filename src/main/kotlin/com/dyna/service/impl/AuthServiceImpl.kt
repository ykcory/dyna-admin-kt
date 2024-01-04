package com.dyna.service.impl

import cn.hutool.jwt.signers.JWTSigner
import cn.hutool.jwt.signers.JWTSignerUtil
import com.dyna.domain.dto.LoginDto
import com.dyna.modules.setting.domain.entity.User
import com.dyna.service.AuthService
import com.dyna.utils.TokenUtil
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl(
    private val authenticationManager: AuthenticationManager,
    private val redisTemplate: RedisTemplate<String, Any>
) : AuthService {

    private final val tokenSecret = "sifhrevhwvnkjsfihre".toByteArray()
    val signer: JWTSigner = JWTSignerUtil.hs256(tokenSecret)

    override fun login(params: LoginDto): String {
        val authentication = UsernamePasswordAuthenticationToken(params.username, params.password)
        // 此时会调用 loadUserByUsername 方法 返回的是 UserDetails
        val authenticate: Authentication?
        try {
            authenticate = authenticationManager.authenticate(authentication)
        } catch (e: BadCredentialsException) {
            return "用户名或密码错误"
        }
        val user = authenticate.principal as User
        redisTemplate.opsForValue().set(user.username, user)
        return TokenUtil.create(user.username)
    }
}