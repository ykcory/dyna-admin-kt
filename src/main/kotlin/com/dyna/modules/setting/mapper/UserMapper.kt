package com.dyna.modules.setting.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.dyna.modules.setting.domain.entity.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper : BaseMapper<User> {
    fun findById(id: Int): User?

    @Select("select * from setting_user where username = #{username}")
    fun findByUsername(username: String): User?

    fun list(): List<User>
}