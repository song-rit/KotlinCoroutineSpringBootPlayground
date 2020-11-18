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
                val result = cancellationAndTimeoutPlayground.getGreetingConcatStringWithCancelAble()
                println("result: $result")
            }
        }
        println("total time: $time")
    }
}