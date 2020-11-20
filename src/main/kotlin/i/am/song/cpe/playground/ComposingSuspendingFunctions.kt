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

    private suspend fun failedConcurrentSum(): Int = coroutineScope {
        val one = async<Int> {
            try {
                delay(Long.MAX_VALUE)
                10
            } finally {
                println("First child was cancel")
            }
        }

        val two = async<Int> {
            println("Second child throws an exception")
            throw ArithmeticException()
        }
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

    fun doFailedConcurrentSumMethod() {
        runBlocking {
            try {
                failedConcurrentSum()
            } catch (ex: ArithmeticException) {
                println("Computation failed with ArithmeticException")
            }

        }
    }
}