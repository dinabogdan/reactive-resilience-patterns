package com.freesoft.reactiveresiliencedemo.application.service

import com.freesoft.reactiveresiliencedemo.api.BusinessComponent
import com.freesoft.reactiveresiliencedemo.application.Adapter
import com.freesoft.reactiveresiliencedemo.application.service.ThirdBusinessComponent.Companion.BUSINESS_COMPONENT_NAME
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.CompletableFuture

@Component(BUSINESS_COMPONENT_NAME)
class ThirdBusinessComponent(private val thirdAdapter: Adapter) : BusinessComponent {

    companion object {
        const val BUSINESS_COMPONENT_NAME = "thirdBusinessComponent"
    }

    override fun failure(): String = thirdAdapter.failure()

    override fun success(): String = thirdAdapter.success()

    override fun ignore(): String = thirdAdapter.ignoreException()

    override fun failureWithFallback(): String = thirdAdapter.failureWithFallback()

    override fun fluxFailure(): Flux<String> = thirdAdapter.failureFlux()

    override fun fluxSuccess(): Flux<String> = thirdAdapter.fluxSuccess()

    override fun monoSuccess(): Mono<String> = thirdAdapter.monoSuccess()

    override fun monoFailure(): Mono<String> = thirdAdapter.monoFailure()

    override fun futureSuccess(): CompletableFuture<String> = thirdAdapter.futureSuccess()

    override fun futureFailure(): CompletableFuture<String> = thirdAdapter.futureFailure()
}