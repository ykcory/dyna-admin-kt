package com.dyna.config

import cn.hutool.core.date.DateUtil
import cn.hutool.core.io.file.FileNameUtil
import cn.hutool.core.util.IdUtil
import io.minio.MinioClient
import io.minio.PutObjectArgs
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.multipart.MultipartFile

@Configuration
class MinioConfig {
    @Value("\${minio.endpoint}")
    val endpoint: String = ""

    @Value("\${minio.bucket-name}")
    val bucketName: String = ""

    @Value("\${minio.access-key}")
    val accessKey: String = ""

    @Value("\${minio.secret-key}")
    val secureKey: String = ""

    @Bean
    fun minioClient(): MinioClient {
        return MinioClient.builder()
            .endpoint(endpoint)
            .credentials(accessKey, secureKey)
            .build()
    }

    fun uploadFile(file:MultipartFile): String {
        val inputStream = file.inputStream
        val path = "temp/" + DateUtil.thisYear() + "/"

        var fileName = IdUtil.objectId()
        val exName = FileNameUtil.extName(file.originalFilename)
        if (exName!= "") {
            fileName += ".$exName"
        }

        val filepath = path + fileName

        minioClient().putObject(
            PutObjectArgs.builder()
               .bucket(bucketName)
               .`object`(filepath)
               .stream(inputStream, file.size, -1)
               .build()
        )

        return filepath
    }
}