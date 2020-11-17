package i.am.song.cpe.playground

import i.am.song.cpe.common.GreetingService
import i.am.song.cpe.common.RecordTimeInstance
import kotlinx.coroutines.*

class SuspendPlayground {

    private val greetingService = GreetingService()

    suspend fun doGreetingByRunBlocking() = withContext(Dispatchers.Default){
        RecordTimeInstance.initExecuteTime()
        greetingService.greeting("hello coroutine 1")
        delay(1000)
        greetingService.greeting("hello coroutine 2")
        delay(1000)
        greetingService.greeting("hello coroutine 3")

    }

    suspend fun getGreetingConcatStringByRunBlocking() : String = withContext(Dispatchers.Default){
        RecordTimeInstance.initExecuteTime()
        var result = ""
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
        return@withContext result
    }
}