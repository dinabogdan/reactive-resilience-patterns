package com.freesoft.reactiveresiliencedemo.infrastructure

import io.github.resilience4j.retry.annotation.Retry
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.CompletableFuture

@Retry
@Component("firstAdapter")
class FirstAdapter : Adapter {
    override fun failure(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun success(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ignoreException(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun failureFlux(): Flux<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun monoSuccess(): Mono<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun monoFailure(): Mono<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun failureWithFallback(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun futureSuccess(): CompletableFuture<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun futureFailure(): CompletableFuture<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}