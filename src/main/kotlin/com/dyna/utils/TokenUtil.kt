package com.dyna.utils

import cn.hutool.jwt.JWTUtil
import cn.hutool.jwt.signers.JWTSigner
import cn.hutool.jwt.signers.JWTSignerUtil

object TokenUtil {
    private val tokenSecret = "sifhrevhwvnkjsfihre".toByteArray()
    private val signer: JWTSigner = JWTSignerUtil.hs256(tokenSecret)

    fun create(username: String): String {
        val map = object : HashMap<String, Any>() {
            init {
                put("username", username)
                put("exp", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15)
            }
        }

        return JWTUtil.createToken(map, signer)
    }

    fun verify(token: String): Boolean {
        return JWTUtil.verify(token, signer)
    }

    fun getUsername(token: String): String {
        val jwt = JWTUtil.parseToken(token)
        return jwt.payloads.get("username").toString()
    }

}