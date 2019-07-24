package com.freesoft.reactiveresiliencedemo

import io.vavr.collection.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.actuate.health.Status
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit4.SpringRunner
import javax.inject.Inject

@DirtiesContext
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [ReactiveResilienceDemoApplication::class])
class ReactiveResilienceDemoApplicationTests {

    @Inject
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun contextLoads() {
        assertNotNull(restTemplate)
    }

    @Test
    fun given5FailureRequests_whenSubmittingThe_thenOpenAndCloseCircuitBreaker() {
        repeat(5) { aFailure("first") }

        checkCircuitBreakerStatus("firstAdapterCircuitBreaker", Status.DOWN)

        Thread.sleep(2000)

        repeat(3) { aSuccess("first") }

        checkCircuitBreakerStatus("firstAdapterCircuitBreaker", Status.UP)
    }

    private fun aFailure(adapterName: String) {
        val response = restTemplate.getForEntity("/$adapterName/failure", String::class.java)
        assertThat(response.statusCode == HttpStatus.INTERNAL_SERVER_ERROR)
    }

    private fun aSuccess(adapterName: String) {
        val response = restTemplate.getForEntity("/$adapterName/success", String::class.java)
        assertThat(response.statusCode == HttpStatus.OK)
    }

    private fun checkCircuitBreakerStatus(circuitBreakerName: String, status: Status) {
        val response = restTemplate.getForEntity("/actuator/health", HealthCheckResponse::class.java)
        assertNotNull(response)
        assertNotNull(response.body?.details)
        val circuitBreakerDetails = response.body?.details?.get(circuitBreakerName)
        assertNotNull(circuitBreakerDetails)
        assertThat(circuitBreakerDetails?.get("status") == status.toString())
    }
}
