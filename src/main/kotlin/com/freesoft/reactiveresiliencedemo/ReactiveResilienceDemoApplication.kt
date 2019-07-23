package com.freesoft.reactiveresiliencedemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveResilienceDemoApplication

fun main(args: Array<String>) {
	runApplication<ReactiveResilienceDemoApplication>(*args)
}
