package com.freesoft.reactiveresiliencedemo.infrastructure

import com.freesoft.reactiveresiliencedemo.application.Adapter
import com.freesoft.reactiveresiliencedemo.application.exception.IgnorableException
import com.freesoft.reactiveresiliencedemo.infrastructure.ThirdAdapter.Companion.ADAPTER_NAME
import io.github.resilience4j.bulkhead.annotation.Bulkhead
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import io.github.resilience4j.retry.annotation.Retry
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpServerErrorException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.io.IOException
import java.util.concurrent.CompletableFuture

@Component(ADAPTER_NAME)
@Retry(name = ADAPTER_NAME)
@CircuitBreaker(name = ADAPTER_NAME)
class ThirdAdapter : Adapter {

    companion object {
        const val ADAPTER_NAME = "thirdAdapter"
    }

    @Bulkhead(name = ADAPTER_NAME)
    override fun failure(): String {
        throw HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Something is bad with the server thrown by $ADAPTER_NAME")
    }

    @Bulkhead(name = ADAPTER_NAME)
    override fun success(): String = "Success response from $ADAPTER_NAME"

    override fun ignoreException(): String {
        throw IgnorableException("Because this is a business exception it will be ignored by the CircuitBreaker of $ADAPTER_NAME")
    }

    @Bulkhead(name = ADAPTER_NAME)
    override fun fluxSuccess(): Flux<String> = Flux.just("Hello", "From $ADAPTER_NAME")

    @Bulkhead(name = ADAPTER_NAME)
    override fun failureFlux(): Flux<String> = Flux.error(IOException("Something bad from $ADAPTER_NAME"))

    @Bulkhead(name = ADAPTER_NAME)
    override fun monoSuccess(): Mono<String> = Mono.just("A reactive success response from $ADAPTER_NAME")

    @Bulkhead(name = ADAPTER_NAME)
    override fun monoFailure(): Mono<String> = Mono.error(IOException("Something bad, again, from $ADAPTER_NAME"))

    @CircuitBreaker(name = ADAPTER_NAME, fallbackMethod = "aFallback")
    override fun failureWithFallback(): String = failure()

    @Bulkhead(name = ADAPTER_NAME, type = Bulkhead.Type.THREADPOOL)
    override fun futureSuccess(): CompletableFuture<String> = CompletableFuture.completedFuture("A future success from $ADAPTER_NAME")

    @Bulkhead(name = ADAPTER_NAME, type = Bulkhead.Type.THREADPOOL)
    override fun futureFailure(): CompletableFuture<String> {
        val future = CompletableFuture<String>()
        future.completeExceptionally(IOException("A future failure from ${ADAPTER_NAME}"))
        return future
    }

    private fun aFallback(exception: Throwable) = "$ADAPTER_NAME recovered ${exception.message}"
}