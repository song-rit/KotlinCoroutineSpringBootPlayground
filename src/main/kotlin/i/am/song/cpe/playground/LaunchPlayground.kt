package i.am.song.cpe.playground

import i.am.song.cpe.common.GreetingService
import i.am.song.cpe.common.RecordTimeInstance

class LaunchPlayground {

    private val greetingService = GreetingService()

    fun doGreetingOnMainThread() {
        // block the main thread
        RecordTimeInstance.initExecuteTime()
        greetingService.greeting("hello coroutine")
        Thread.sleep(1)
        greetingService.greeting("hello coroutine")

    }

    fun doGreetingByLaunch() {

    }
}