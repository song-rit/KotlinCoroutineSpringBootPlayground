package i.am.song.cpe.playground

import i.am.song.cpe.common.GreetingService
import i.am.song.cpe.common.RecordTimeInstance
import kotlinx.coroutines.*
import org.springframework.cglib.core.Block

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
        RecordTimeInstance.initExecuteTime()
        GlobalScope.launch(Dispatchers.Default) {
            greetingService.greeting("hello coroutine 1")
            delay(1000)
            greetingService.greeting("hello coroutine 2")
            delay(1000)
            greetingService.greeting("hello coroutine 3")
        }
    }
}