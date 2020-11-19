package i.am.song.cpe.playground

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class CancellationAndTimeoutPlaygroundTest {

    private val cancellationAndTimeoutPlayground = CancellationAndTimeoutPlayground()

    @Test
    fun getGreetingWithCancelAbleTest() {
        val time = measureTimeMillis() {
            runBlocking {
                cancellationAndTimeoutPlayground.doGreetingWithCancelAble()
            }
        }
        println("total time: $time")
    }

    @Test
    fun doGreetingWithCancelAndJoinTest() {
        val time = measureTimeMillis() {
            runBlocking {
                cancellationAndTimeoutPlayground.doGreetingWithCancelAndJoin()
            }
        }
        println("total time: $time")
    }

    @Test
    fun doGreetingAndHandlerCancellationExceptionTest() {
        val time = measureTimeMillis() {
            runBlocking {
                cancellationAndTimeoutPlayground.doGreetingAndHandlerCancellationException()
            }
        }
        println("total time: $time")
    }

    @Test
    fun doGreetingAndHandlerCancellationExceptionWithNonCancellableTest() {
        val time = measureTimeMillis() {
            runBlocking {
                cancellationAndTimeoutPlayground.doGreetingAndHandlerCancellationExceptionWithNonCancellable()
            }
        }
        println("total time: $time")
    }

    @Test
    fun doGreetingWithTimeoutTest() {
        val time = measureTimeMillis() {
            runBlocking {
                cancellationAndTimeoutPlayground.doGreetingWithTimeout()
            }
        }
        println("total time: $time")
    }

    @Test
    fun doGreetingWithTimeoutAndHandlerFinallyTest() {
        val time = measureTimeMillis() {
            runBlocking {
                cancellationAndTimeoutPlayground.doGreetingWithTimeoutAndHandlerFinally()
            }
        }
        println("total time: $time")
    }


}