package i.am.song.cpe.playground

import i.am.song.cpe.common.GreetingService
import i.am.song.cpe.common.RecordTimeInstance
import kotlinx.coroutines.*

class RunBlockingPlayground {

    private val greetingService = GreetingService()

    fun doGreetingByRunBlocking() {
        RecordTimeInstance.initExecuteTime()

        //blocks the main thread
        runBlocking(Dispatchers.Default) {
            greetingService.greeting("hello coroutine 1")
            delay(1000)
            greetingService.greeting("hello coroutine 2")
            delay(1000)
            greetingService.greeting("hello coroutine 3")
        }
    }

    fun getGreetingConcatStringByRunBlocking(): String {
        RecordTimeInstance.initExecuteTime()
        var result = ""

        //blocks the main thread
        runBlocking(Dispatchers.Default) {
            result += greetingService.getGreeting("hello coroutine 1") + " | "
            delay(1000)
            result += greetingService.getGreeting("hello coroutine 2") + " | "
            delay(1000)
            result += greetingService.getGreeting("hello coroutine 3") + " | "
            delay(1000)
            result += greetingService.getGreeting("hello coroutine 4") + " | "
            delay(1000)
            result += greetingService.getGreeting("hello coroutine 5")
        }
        return result
    }
}