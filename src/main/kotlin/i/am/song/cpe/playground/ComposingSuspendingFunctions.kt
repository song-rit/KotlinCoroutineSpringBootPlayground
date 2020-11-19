package i.am.song.cpe.playground

import i.am.song.cpe.common.GreetingService
import i.am.song.cpe.common.RecordTimeInstance
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class ComposingSuspendingFunctions {

    private val greetingService = GreetingService();

    private suspend fun doSomethingUsefulOne(): Int {
        delay(1000L)
        return 5
    }

    private suspend fun doSomethingUsefulTwo(): Int {
        delay(1000L)
        return 10
    }

    fun doSumBySequential() {
        RecordTimeInstance.initExecuteTime()
        runBlocking {
            val one = doSomethingUsefulOne()
            val two = doSomethingUsefulTwo()
            greetingService.printByRecord("The answer is ${one + two}")
        }
    }

    fun doSumByConcurrentUsingAsync() {
        RecordTimeInstance.initExecuteTime()
        runBlocking {
            val one = async { doSomethingUsefulOne() }
            val two = async { doSomethingUsefulTwo() }
            greetingService.printByRecord("The answer is ${one.await() + two.await()}")
        }
    }

    fun doSumByConcurrentUsingAsyncAndLazyStart() {
        RecordTimeInstance.initExecuteTime()
        runBlocking {
            val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
            val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
            // CoroutineStart.LAZY, it only start coroutine when it's result required by await.
            one.start() // start async
            two.start() // start async
            greetingService.printByRecord("The answer is ${one.await() + two.await()}")
        }
    }

}