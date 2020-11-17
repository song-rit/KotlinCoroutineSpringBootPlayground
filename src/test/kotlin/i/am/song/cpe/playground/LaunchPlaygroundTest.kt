package i.am.song.cpe.playground

import org.junit.jupiter.api.Test

class LaunchPlaygroundTest {

    private val launchPlayground = LaunchPlayground()

    @Test
    fun doGreetingInMainThreadTest() {
        launchPlayground.doGreetingOnMainThread()
    }

    @Test
    fun doGreetingByLaunchWithGlobalScopeTest() {
        launchPlayground.doGreetingByLaunchWithGlobalScope()
        Thread.sleep(4000)
    }
}