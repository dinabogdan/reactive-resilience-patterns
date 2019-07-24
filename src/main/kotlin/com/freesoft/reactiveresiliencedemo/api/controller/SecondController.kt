package com.freesoft.reactiveresiliencedemo.api.controller

import com.freesoft.reactiveresiliencedemo.api.BusinessComponent
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/second")
class SecondController(private val secondBusinessComponent: BusinessComponent) {

    @GetMapping("/failure")
    fun failure() = secondBusinessComponent.failure()

    @GetMapping("/success")
    fun success() = secondBusinessComponent.success()

    @GetMapping("/ignore")
    fun ignore() = secondBusinessComponent.ignore()

    @GetMapping("/mono/success")
    fun monoSuccess() = secondBusinessComponent.monoSuccess()

    @GetMapping("/mono/failure")
    fun monoFailure() = secondBusinessComponent.monoFailure()

    @GetMapping("/flux/success")
    fun fluxSuccess() = secondBusinessComponent.fluxSuccess()

    @GetMapping("/flux/failure")
    fun fluxFailure() = secondBusinessComponent.fluxFailure()

    @GetMapping("/future/success")
    fun futureSuccess() = secondBusinessComponent.futureSuccess()

    @GetMapping("/future/failure")
    fun futureFailure() = secondBusinessComponent.futureFailure()

}