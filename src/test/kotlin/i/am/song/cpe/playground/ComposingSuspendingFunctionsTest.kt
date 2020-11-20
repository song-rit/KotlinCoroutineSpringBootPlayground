package i.am.song.cpe.playground

import i.am.song.cpe.common.runWithRecord
import org.junit.jupiter.api.Test

class ComposingSuspendingFunctionsTest {

    private val composingSuspendingFunctions = ComposingSuspendingFunctions()

    @Test
    fun doSumBySequentialTest() {
        runWithRecord { composingSuspendingFunctions.doSumBySequential() }
    }

    @Test
    fun doSumByConcurrentUsingAsyncTest() {
        runWithRecord { composingSuspendingFunctions.doSumByConcurrentUsingAsync() }
    }

    @Test
    fun doSumByConcurrentUsingAsyncAndLazyStartTest() {
        runWithRecord { composingSuspendingFunctions.doSumByConcurrentUsingAsyncAndLazyStart() }
    }

    @Test
    fun doSumByConcurrentUsingAsyncGlobalScopeTest() {
        runWithRecord { composingSuspendingFunctions.doSumByConcurrentUsingAsyncGlobalScope() }
    }

    @Test
    fun doSumUsingConcurrentMethodTest() {
        runWithRecord { composingSuspendingFunctions.doSumUsingConcurrentMethod() }
    }

    @Test
    fun doFailedConcurrentSumMethodTest() {
        runWithRecord { composingSuspendingFunctions.doFailedConcurrentSumMethod() }
    }
}