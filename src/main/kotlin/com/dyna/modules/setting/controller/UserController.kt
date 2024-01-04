package com.dyna.modules.setting.controller
import com.dyna.domain.entity.Response
import com.dyna.domain.entity.R
import com.dyna.modules.setting.domain.dto.UserDto
import com.dyna.domain.dto.PageParam
import com.dyna.modules.setting.service.UserService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {

    @Operation(summary = "获取用户列表")
    @GetMapping("/list")
    fun list(@RequestParam userDto: UserDto, @RequestParam pageParam: PageParam): Response<String> {
        return R.success("hello, world")
    }

    @Operation(summary = "添加用户")
    @PostMapping("/add")
    fun add(@RequestBody userDto: UserDto): Response<String> {
        userDto.id = null
        userService.add(userDto)
        return R.success("hello, world")
    }
}