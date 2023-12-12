package com.dyna

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DynaAdminApplication

fun main(args: Array<String>) {
    runApplication<DynaAdminApplication>(*args)
}
