package com.dyna.config

import com.dyna.utils.FastJson2RedisSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer


@Configuration
class RedisConfig {
    @Bean
    fun redisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, Any> {
        // String 的序列化
        val stringRedisSerializer = StringRedisSerializer()
        // Json 序列化配置
        val fastJson2RedisSerializer = FastJson2RedisSerializer()
        // 自定义 String Object
        val template = RedisTemplate<String, Any>().apply {
            // key 采用String的序列化方式
            keySerializer = stringRedisSerializer
            // hash 的key也采用 String 的序列化方式
            hashKeySerializer = stringRedisSerializer
            // value 序列化方式采用 jackson
            valueSerializer = fastJson2RedisSerializer
            // hash 的 value 采用 jackson
            hashValueSerializer = fastJson2RedisSerializer
            connectionFactory = redisConnectionFactory
        }
        template.afterPropertiesSet()
        return template
    }
}