package com.dyna.modules.setting.controller
import com.dyna.domain.entity.Response
import com.dyna.domain.entity.R
import com.dyna.modules.setting.service.UserService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {
    @Operation(summary = "获取用户列表")
    @GetMapping("/list")
    fun list(): Response<String> {
        return R.success("hello, world")
    }
}