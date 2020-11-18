package i.am.song.cpe.playground

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class CancellationAndTimeoutPlaygroundTest {

    private val cancellationAndTimeoutPlayground = CancellationAndTimeoutPlayground()

    @Test
    fun getGreetingConcatStringWithCancelAbleTest() {
        val time = measureTimeMillis() {
            runBlocking {
                cancellationAndTimeoutPlayground.doGreetingConcatStringWithCancelAble()
            }
        }
        println("total time: $time")
    }

    @Test
    fun doGreetingConcatStringWithCancelAndJoinTest() {
        val time = measureTimeMillis() {
            runBlocking {
                cancellationAndTimeoutPlayground.doGreetingConcatStringWithCancelAndJoin()
            }
        }
        println("total time: $time")
    }

    @Test
    fun doGreetingConcatStringAndHandlerCancellationExceptionTest() {
        val time = measureTimeMillis() {
            runBlocking {
                cancellationAndTimeoutPlayground.doGreetingConcatStringAndHandlerCancellationException()
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
}