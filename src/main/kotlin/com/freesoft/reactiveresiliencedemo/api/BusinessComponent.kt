package com.freesoft.reactiveresiliencedemo.api

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.CompletableFuture

interface BusinessComponent {

    fun failure(): String

    fun success(): String

    fun ignore(): String

    fun failureWithFallback(): String

    fun fluxFailure(): Flux<String>

    fun fluxSuccess(): Flux<String>

    fun monoSuccess(): Mono<String>

    fun monoFailure(): Mono<String>

    fun futureSuccess(): CompletableFuture<String>

    fun futureFailure(): CompletableFuture<String>
}