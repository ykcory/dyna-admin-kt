package com.dyna.modules.setting.domain.entity

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import java.time.LocalDateTime

@TableName("setting_user")
data class User(
    val id: Int?,
    @get:JvmName("iUsername")
    val username: String,
    @get:JvmName("iPassword")
    val password: String?,
    val realname: String?,
    val phone: String?,
    val email: String?,
    val status: Int?,
    @TableField(fill = FieldFill.INSERT)
    val createdAt: LocalDateTime?,
    @TableField(fill = FieldFill.INSERT)
    val createdBy: String?,
    @TableField(fill = FieldFill.UPDATE)
    val updatedAt: LocalDateTime?,
    @TableField(fill = FieldFill.UPDATE)
    val updatedBy: String?,
) : UserDetails, Serializable {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority>? {
        return null
    }

    override fun getPassword(): String? {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}