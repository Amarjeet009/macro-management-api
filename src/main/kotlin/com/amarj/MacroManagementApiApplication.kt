package com.amarj

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MacroManagementApiApplication

fun main(args: Array<String>) {
	runApplication<MacroManagementApiApplication>(*args)
}
