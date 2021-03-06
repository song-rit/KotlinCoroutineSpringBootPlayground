package i.am.song.cpe.playground

import i.am.song.cpe.common.log
import kotlinx.coroutines.*

class CoroutineContextAndDispatchers {

    fun dispatcherAndThread() {
        runBlocking {

            GlobalScope.launch {
                launch {
                    // context of the parent, main runBlocking coroutine
                    println("main GlobalScope      : I'm working in thread ${Thread.currentThread().name}")
                }
            }

            launch {
                // context of the parent, main runBlocking coroutine
                println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Unconfined) {
                // not confined -- will work with main thread
                println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Default) {
                // will get dispatched to DefaultDispatcher
                println("Default               : I'm working in thread ${Thread.currentThread().name}")
            }

            launch(newSingleThreadContext("MyOwnThread")) {
                // will get its own new thread
                println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")

                launch {
                    // context of the parent, main runBlocking coroutine
                    println("main newSingleThreadContext      : I'm working in thread ${Thread.currentThread().name}")
                }
            }

        }
    }

    fun unconfinedVsConfinedDispatcher() {
        runBlocking {
            launch(Dispatchers.Unconfined) {
                // not confined -- will work with main thread
                println("Unconfined      : I'm working in thread ${Thread.currentThread().name}")
                delay(500)
                println("Unconfined      : After delay in thread ${Thread.currentThread().name}")
            }
            launch {
                // context of the parent, main runBlocking coroutine
                println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
                delay(1000)
                println("main runBlocking: After delay in thread ${Thread.currentThread().name}")
            }
        }

    }

    fun debugCoroutineWithLogging() {
        runBlocking {
            val a = async {
                log("I'm computing a piece of the answer")
                10
            }
            val b = async {
                log("I'm computing another piece of the answer")
                20
            }

            log("The answer is ${a.await() * b.await()}")
        }

    }
}