package i.am.song.cpe.playground

import i.am.song.cpe.common.GreetingService
import i.am.song.cpe.common.RecordTimeInstance
import kotlinx.coroutines.*

class CancellationAndTimeoutPlayground {
    private val greetingService = GreetingService()

    suspend fun getGreetingConcatStringWithCancelAble() : String = withContext(Dispatchers.Default){
        RecordTimeInstance.initExecuteTime()
        var result = ""
        val job1 = launch {
            repeat(1_000) {
                greetingService.getGreetingWithSuspend("job1 : $it")
                delay(1000)
            }
        }

        val job2 = launch {
            repeat(50) {
                greetingService.getGreetingWithSuspend("job2 : $it")
                delay(1000)
            }
        }

        delay(5000)
        job1.cancel()
        println("job1 canceled")
        delay(5000)
        job2.cancel()
        println("job2 canceled")


        return@withContext result
    }
}