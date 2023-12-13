package com.dyna.controller

import com.dyna.config.MinioConfig
import com.dyna.domain.entity.R
import com.dyna.domain.entity.Response
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/file")
class FileController(val minioConfig: MinioConfig) {
    @PostMapping("/upload")
    fun upload(@RequestPart file: MultipartFile): Response<String> {
        val filepath = minioConfig.uploadFile(file)
        return R.success(filepath)
    }
}