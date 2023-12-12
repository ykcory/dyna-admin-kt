package com.dyna.modules.setting.mapper

import com.dyna.modules.setting.domain.entity.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {
    fun findById(id: Int): User?

    @Select("select * from setting_user where username = #{username}")
    fun findByUsername(username: String): User?
}