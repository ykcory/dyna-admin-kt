package com.dyna.modules.setting.service.impl

import com.dyna.modules.setting.mapper.UserMapper
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    val userMapper: UserMapper? = null

    @Test
    fun getList() {
        val users = userMapper?.list()
        println(users)
    }
}