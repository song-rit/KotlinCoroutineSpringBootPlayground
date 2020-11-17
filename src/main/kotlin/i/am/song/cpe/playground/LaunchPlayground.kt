package i.am.song.cpe.playground

import i.am.song.cpe.common.GreetingService
import i.am.song.cpe.common.RecordTimeInstance
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LaunchPlayground {

    private val greetingService = GreetingService()

    fun doGreetingOnMainThread() {
        // block the main thread
        RecordTimeInstance.initExecuteTime()
        greetingService.greeting("hello coroutine 1")
        Thread.sleep(1000)
        greetingService.greeting("hello coroutine 2")
    }

    fun doGreetingByLaunchWithGlobalScope() {
        GlobalScope.launch {
            greetingService.greeting("hello coroutine 1")
            delay(1000)
            greetingService.greeting("hello coroutine 2")
        }
    }
}