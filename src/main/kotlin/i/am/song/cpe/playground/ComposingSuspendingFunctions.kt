package i.am.song.cpe.playground

import i.am.song.cpe.common.GreetingService
import i.am.song.cpe.common.RecordTimeInstance
import kotlinx.coroutines.*

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

    // The result type of somethingUsefulOneAsync is Deferred<Int>
    private fun somethingUsefulOneAsync() = GlobalScope.async {
        doSomethingUsefulOne()
    }

    // The result type of somethingUsefulTwoAsync is Deferred<Int>
    private fun somethingUsefulTwoAsync() = GlobalScope.async {
        doSomethingUsefulTwo()
    }

    private suspend fun concurrentSum(): Int = coroutineScope {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
        one.await() + two.await()
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

    fun doSumByConcurrentUsingAsyncGlobalScope() {
        RecordTimeInstance.initExecuteTime()
        runBlocking {
            val one = somethingUsefulOneAsync()
            val two = somethingUsefulTwoAsync()
            // CoroutineStart.LAZY, it only start coroutine when it's result required by await.
            greetingService.printByRecord("The answer is ${one.await() + two.await()}")
        }
    }

    fun doSumUsingConcurrentMethod() {
        RecordTimeInstance.initExecuteTime()
        runBlocking {
            greetingService.printByRecord("The answer is ${concurrentSum()}")
        }
    }

}