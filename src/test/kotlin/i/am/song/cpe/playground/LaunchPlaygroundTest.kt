package i.am.song.cpe.playground

import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class LaunchPlaygroundTest {

    private val launchPlayground = LaunchPlayground()

    @Test
    fun doGreetingInMainThreadTest() {
        val time = measureTimeMillis() {
            launchPlayground.doGreetingOnMainThread()
            Thread.sleep(1)
        }
        println("total time: $time")
    }

    @Test
    fun doGreetingByLaunchWithGlobalScopeTest() {
        val time = measureTimeMillis() {
            launchPlayground.doGreetingByLaunchWithGlobalScope()
            Thread.sleep(3000)
        }
        println("total time: $time")
    }

    @Test
    fun getGreetingConcatStringByLaunchWithGlobalScopeTest() {
        val time = measureTimeMillis() {
            val result = launchPlayground.getGreetingConcatStringByLaunchWithGlobalScope()
            println("result: $result")
        }
        println("total time: $time")
    }
}