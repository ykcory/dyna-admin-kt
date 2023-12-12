package com.dyna

import cn.hutool.jwt.JWTUtil
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DynaAdminKtApplicationTests {

    @Test
    fun contextLoads() {
    }

    @Test
    fun parseTest() {
        val token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjEyMywiZXhwIjoxNjYzNzI2Mzg2NTQ0fQ.yZtjlrV5hN8hWdFOZLJNqoaNaand-1XW0Pi1YIwmCrk";
        val jwt = JWTUtil.parseToken(token);
        //header
        val headers = jwt.headers;
        //payload
        val payloads = jwt.payloads.get("uid");
        println(headers)
        println(payloads)
    }

}
