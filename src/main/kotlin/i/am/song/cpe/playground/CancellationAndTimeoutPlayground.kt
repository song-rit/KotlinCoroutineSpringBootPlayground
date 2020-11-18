package i.am.song.cpe.playground

import i.am.song.cpe.common.GreetingService
import i.am.song.cpe.common.RecordTimeInstance
import kotlinx.coroutines.*
import kotlin.random.Random

class CancellationAndTimeoutPlayground {
    private val greetingService = GreetingService()

    suspend fun doGreetingWithCancelAble() = withContext(Dispatchers.Default) {
        RecordTimeInstance.initExecuteTime()
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
        job1.join()
        println("job1 canceled")
        delay(5000)
        job2.cancel()
        job2.join()
        println("job2 canceled")
    }


    suspend fun doGreetingWithCancelAndJoin() = withContext(Dispatchers.Default) {
        RecordTimeInstance.initExecuteTime()
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            fun isCurrentTimeMoreThanNextTime(): Boolean {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    nextPrintTime += 500L
                    return true
                }
                return false
            }

            var i = 0
            while (i < 20) {
                greetingService.getGreetingWithSuspend("job1 : $i")
                val randomNumber = Random.nextInt(10, 100);
                if (isPalindrome(randomNumber) && isEvenNumber(randomNumber) && isCurrentTimeMoreThanNextTime()) {
                    println("Logic is match, count to ${++i}")
                }
            }
        }

        delay(5000L)
        job.cancelAndJoin()
        println("job canceled")
    }

    private fun isPalindrome(number: Int): Boolean {
        val sourceValue = number.toString()
        val revertSourceValue = sourceValue.reversed()
        if (sourceValue == revertSourceValue) {
            println("Palindrome number is : $number")
            return true
        }
        return false
    }

    private fun isEvenNumber(number: Int): Boolean {
        if (number % 2 == 0) {
            println("Even number is : $number")
            return true
        }
        return false
    }

    suspend fun doGreetingAndHandlerCancellationException() = withContext(Dispatchers.Default) {
        RecordTimeInstance.initExecuteTime()
        val job = launch {
            try {
                repeat(1_000) {
                    greetingService.getGreetingWithSuspend("job : $it")
                    delay(1000)
                }
            } finally {
                greetingService.getGreetingWithSuspend("job : finally")
            }
        }

        delay(5000)
        job.cancelAndJoin()
        println("job canceled")
    }

    suspend fun doGreetingAndHandlerCancellationExceptionWithNonCancellable() = withContext(Dispatchers.Default) {
        RecordTimeInstance.initExecuteTime()
        val job = launch {
            try {
                repeat(1_000) {
                    greetingService.getGreetingWithSuspend("job : $it")
                    delay(1000)
                }
            } finally {
                withContext(NonCancellable) {
                    greetingService.getGreetingWithSuspend("job : finally")
                    delay(1000)
                    greetingService.getGreetingWithSuspend("job : really finally")
                }
            }
        }

        delay(5000)
        job.cancelAndJoin()
        println("job canceled")
    }
}