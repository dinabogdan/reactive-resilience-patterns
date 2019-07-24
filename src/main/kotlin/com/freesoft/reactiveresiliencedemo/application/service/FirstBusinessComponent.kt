package com.freesoft.reactiveresiliencedemo.application.service

import com.freesoft.reactiveresiliencedemo.api.BusinessComponent
import com.freesoft.reactiveresiliencedemo.application.Adapter
import com.freesoft.reactiveresiliencedemo.application.service.FirstBusinessComponent.Companion.BUSINESS_COMPONENT_NAME
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.CompletableFuture

@Component(BUSINESS_COMPONENT_NAME)
class FirstBusinessComponent(private val firstAdapter: Adapter) : BusinessComponent {

    companion object {
        const val BUSINESS_COMPONENT_NAME = "firstBusinessComponent"
    }

    override fun failure(): String = firstAdapter.failure()

    override fun success(): String = firstAdapter.success()

    override fun ignore(): String = firstAdapter.ignoreException()

    override fun failureWithFallback(): String = firstAdapter.failureWithFallback()

    override fun fluxFailure(): Flux<String> = firstAdapter.failureFlux()

    override fun fluxSuccess(): Flux<String> = firstAdapter.fluxSuccess()

    override fun monoSuccess(): Mono<String> = firstAdapter.monoSuccess()

    override fun monoFailure(): Mono<String> = firstAdapter.monoFailure()

    override fun futureSuccess(): CompletableFuture<String> = firstAdapter.futureSuccess()

    override fun futureFailure(): CompletableFuture<String> = firstAdapter.futureFailure()
}