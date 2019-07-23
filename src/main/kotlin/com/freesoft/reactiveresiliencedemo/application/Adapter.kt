package com.freesoft.reactiveresiliencedemo.application

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.CompletableFuture

interface Adapter {
    fun failure(): String

    fun success(): String

    fun ignoreException(): String

    fun fluxSuccess(): Flux<String>

    fun failureFlux(): Flux<String>

    fun monoSuccess(): Mono<String>

    fun monoFailure(): Mono<String>

    fun failureWithFallback(): String

    fun futureSuccess(): CompletableFuture<String>

    fun futureFailure(): CompletableFuture<String>
}