package com.freesoft.reactiveresiliencedemo.api.controller

import com.freesoft.reactiveresiliencedemo.api.BusinessComponent
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/first")
class FirstController(private val firstBusinessComponent: BusinessComponent) {

    @GetMapping("/failure")
    fun failure() = firstBusinessComponent.failure()

    @GetMapping("/success")
    fun success() = firstBusinessComponent.success()

    @GetMapping("/ignore")
    fun ignore() = firstBusinessComponent.ignore()

    @GetMapping("/mono/success")
    fun monoSuccess() = firstBusinessComponent.monoSuccess()

    @GetMapping("/mono/failure")
    fun monoFailure() = firstBusinessComponent.monoFailure()

    @GetMapping("/flux/success")
    fun fluxSuccess() = firstBusinessComponent.fluxSuccess()

    @GetMapping("/flux/failure")
    fun fluxFailure() = firstBusinessComponent.fluxFailure()

    @GetMapping("/future/success")
    fun futureSuccess() = firstBusinessComponent.futureSuccess()

    @GetMapping("/future/failure")
    fun futureFailure() = firstBusinessComponent.futureFailure()
}