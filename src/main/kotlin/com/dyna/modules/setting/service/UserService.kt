package com.dyna.modules.setting.service

import com.dyna.modules.setting.domain.entity.User

interface UserService {
    fun findById(id: Int): User?

    fun findByUsername(username: String): User?
}