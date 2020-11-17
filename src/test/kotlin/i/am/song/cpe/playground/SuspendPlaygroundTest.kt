package i.am.song.cpe.playground

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class SuspendPlaygroundTest {

    private val suspendPlayground = SuspendPlayground()

    @Test
    fun doGreetingByLaunchWithGlobalScopeTest() {
        val time = measureTimeMillis() {
            runBlocking {
                suspendPlayground.doGreetingByRunBlocking()
            }
        }
        println("total time: $time")
    }

    @Test
    fun getGreetingConcatStringByLaunchWithGlobalScopeTest() {
        val time = measureTimeMillis() {
            runBlocking {
                val result = suspendPlayground.getGreetingConcatStringByRunBlocking()
                println("result: $result")
            }
        }
        println("total time: $time")
    }
}