package com.dyna.handlers

import org.springframework.stereotype.Component
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject
import org.springframework.security.core.context.SecurityContextHolder
import java.time.LocalDateTime

@Component
class MyMetaObjectHandler() : MetaObjectHandler{
    override fun insertFill(metaObject: MetaObject?) {
        if (metaObject!= null) {
            val createAt = LocalDateTime.now()
            this.setFieldValByName("createAt", createAt, metaObject)
            val user = SecurityContextHolder.getContext().authentication
            println("user:$user")
        }
    }

    override fun updateFill(metaObject: MetaObject?) {
        if (metaObject!= null) {
            val createAt = LocalDateTime.now()
            this.setFieldValByName("updateAt", createAt, metaObject)
            val user = SecurityContextHolder.getContext().authentication
            println("user:$user")
        }
    }
}