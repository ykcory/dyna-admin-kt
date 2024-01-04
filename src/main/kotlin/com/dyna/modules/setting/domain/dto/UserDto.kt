package com.dyna.modules.setting.domain.dto
import com.dyna.modules.setting.domain.entity.User

data class UserDto (
    var id: Int?,
    val username: String,
    val realname: String,
    val phone: String?,
    val email: String?,
    val status: Int,
){
    fun toEntity(): User {
        return User(
            id = this.id,
            username = this.username,
            password = null,
            realname = this.realname,
            phone = this.phone,
            email = this.email,
            status = this.status,
            createdAt = null,
            createdBy = null,
            updatedAt = null,
            updatedBy = null
        )
    }
}