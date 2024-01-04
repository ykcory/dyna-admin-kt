package com.dyna.modules.setting.service

import com.dyna.domain.dto.PageParam
import com.dyna.modules.setting.domain.dto.UserDto
import com.dyna.modules.setting.domain.entity.User

interface UserService {

    fun add(userDto: UserDto)

    fun findById(id: Int): User?

    fun findByUsername(username: String): User?

    fun list(userDto: UserDto, pageParam: PageParam): List<User>
}