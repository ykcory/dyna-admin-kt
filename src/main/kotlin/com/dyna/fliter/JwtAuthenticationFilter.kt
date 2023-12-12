package com.dyna.fliter

import com.alibaba.fastjson2.JSONObject
import com.dyna.modules.setting.domain.entity.User
import com.dyna.utils.TokenUtil
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val redisTemplate: RedisTemplate<String, Any>
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val token = request.getHeader("Authorization")
        if(token==null){
            filterChain.doFilter(request,response)
            return
        }
//        UsernamePasswordAuthenticationToken()
        if(!TokenUtil.verify(token)){
            return
        }
        // redis 获取 userinfo
        val userJson = redisTemplate.opsForValue().get(TokenUtil.getUsername(token)) as JSONObject
        val userInfo = userJson.toJavaObject(User::class.java)
        val authentication =
            UsernamePasswordAuthenticationToken(userInfo, null, userInfo.authorities)
        SecurityContextHolder.getContext().authentication = authentication

        doFilter(request,response,filterChain)

    }
}