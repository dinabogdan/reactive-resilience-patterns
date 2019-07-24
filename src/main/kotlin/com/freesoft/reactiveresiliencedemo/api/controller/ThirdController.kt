package com.freesoft.reactiveresiliencedemo.api.controller

import com.freesoft.reactiveresiliencedemo.api.BusinessComponent
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/third")
class ThirdController(private val thirdBusinessComponent: BusinessComponent) {

    @GetMapping("/failure")
    fun failure() = thirdBusinessComponent.failure()

    @GetMapping("/success")
    fun success() = thirdBusinessComponent.success()

    @GetMapping("/ignore")
    fun ignore() = thirdBusinessComponent.ignore()

    @GetMapping("/mono/success")
    fun monoSuccess() = thirdBusinessComponent.monoSuccess()

    @GetMapping("/mono/failure")
    fun monoFailure() = thirdBusinessComponent.monoFailure()

    @GetMapping("/flux/success")
    fun fluxSuccess() = thirdBusinessComponent.fluxSuccess()

    @GetMapping("/flux/failure")
    fun fluxFailure() = thirdBusinessComponent.fluxFailure()

    @GetMapping("/future/success")
    fun futureSuccess() = thirdBusinessComponent.futureSuccess()

    @GetMapping("/future/failure")
    fun futureFailure() = thirdBusinessComponent.futureFailure()
}