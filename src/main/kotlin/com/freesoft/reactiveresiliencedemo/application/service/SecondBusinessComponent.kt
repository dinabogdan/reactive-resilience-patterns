package com.freesoft.reactiveresiliencedemo.application.service

import com.freesoft.reactiveresiliencedemo.api.BusinessComponent
import com.freesoft.reactiveresiliencedemo.application.Adapter
import com.freesoft.reactiveresiliencedemo.application.service.SecondBusinessComponent.Companion.BUSINESS_COMPONENT_NAME
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.CompletableFuture

@Component(BUSINESS_COMPONENT_NAME)
class SecondBusinessComponent(private val secondAdapter: Adapter) : BusinessComponent {

    companion object {
        const val BUSINESS_COMPONENT_NAME = "secondBusinessComponent"
    }

    override fun failure(): String = secondAdapter.failure()

    override fun success(): String = secondAdapter.success()

    override fun ignore(): String = secondAdapter.ignoreException()

    override fun failureWithFallback(): String = secondAdapter.failureWithFallback()

    override fun fluxFailure(): Flux<String> = secondAdapter.failureFlux()

    override fun fluxSuccess(): Flux<String> = secondAdapter.fluxSuccess()

    override fun monoSuccess(): Mono<String> = secondAdapter.monoSuccess()

    override fun monoFailure(): Mono<String> = secondAdapter.monoFailure()

    override fun futureSuccess(): CompletableFuture<String> = secondAdapter.futureSuccess()

    override fun futureFailure(): CompletableFuture<String> = secondAdapter.futureFailure()
}