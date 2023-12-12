package com.dyna.utils

import com.alibaba.fastjson2.JSON
import org.springframework.data.redis.serializer.RedisSerializer
import org.springframework.lang.Nullable

class FastJson2RedisSerializer: RedisSerializer<Any> {
    override fun serialize(@Nullable value: Any?): ByteArray? {
        if (value == null) {
            return null
        }
        return JSON.toJSONString(value).toByteArray()
    }

    override fun deserialize(bytes: ByteArray?): Any? {
        if (bytes == null) {
            return null
        }
        return JSON.parse(bytes)
    }

}