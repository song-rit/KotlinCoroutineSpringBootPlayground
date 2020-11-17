package i.am.song.cpe.playground

import org.junit.jupiter.api.Test

class LaunchPlaygroundTest {

    private val launchPlayground = LaunchPlayground()

    @Test
    fun doGreetingInMainThreadTest() {
        launchPlayground.doGreetingInMainThread()
    }
}