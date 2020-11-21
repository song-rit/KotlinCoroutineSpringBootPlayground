package i.am.song.cpe.playground

import kotlinx.coroutines.*

class CoroutineContextAndDispatchers {

    fun dispatcherAndThread() {
        runBlocking {

            GlobalScope.launch {
                launch { // context of the parent, main runBlocking coroutine
                    println("main GlobalScope      : I'm working in thread ${Thread.currentThread().name}")
                }
            }

            launch { // context of the parent, main runBlocking coroutine
                println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
                println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
                println("Default               : I'm working in thread ${Thread.currentThread().name}")
            }

            launch(newSingleThreadContext("MyOwnThread")) { // will get its own new thread
                println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")

                launch { // context of the parent, main runBlocking coroutine
                    println("main newSingleThreadContext      : I'm working in thread ${Thread.currentThread().name}")
                }
            }

        }
    }
}