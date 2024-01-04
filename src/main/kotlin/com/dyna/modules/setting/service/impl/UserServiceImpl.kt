package com.dyna.modules.setting.service.impl

import com.dyna.domain.dto.PageParam
import com.dyna.modules.setting.domain.dto.UserDto
import com.dyna.modules.setting.mapper.UserMapper
import com.dyna.modules.setting.domain.entity.User
import com.dyna.modules.setting.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userMapper: UserMapper) : UserService {
    override fun add(userDto: UserDto) {
        val user = userDto.toEntity()
        println(user)

    }

    override fun findById(id: Int): User? {
        return userMapper.findById(id)
    }

    override fun findByUsername(username: String): User? {
        return userMapper.findByUsername(username)
    }

    override fun list(userDto: UserDto, pageParam: PageParam): List<User> {
        TODO("Not yet implemented")
    }

    fun getList(): List<User> {
        return userMapper.list()
    }

}