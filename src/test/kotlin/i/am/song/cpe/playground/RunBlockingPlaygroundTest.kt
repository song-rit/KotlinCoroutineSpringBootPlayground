package i.am.song.cpe.playground

import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class RunBlockingPlaygroundTest {

    private val runBlockingPlayground = RunBlockingPlayground()

    @Test
    fun doGreetingByLaunchWithGlobalScopeTest() {
        val time = measureTimeMillis() {
            runBlockingPlayground.doGreetingByRunBlocking()
        }
        println("total time: $time")
    }

    @Test
    fun getGreetingConcatStringByLaunchWithGlobalScopeTest() {
        val time = measureTimeMillis() {
            val result = runBlockingPlayground.getGreetingConcatStringByRunBlocking()
            println("result: $result")
        }
        println("total time: $time")
    }
}