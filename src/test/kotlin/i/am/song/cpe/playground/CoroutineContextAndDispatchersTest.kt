package i.am.song.cpe.playground

import i.am.song.cpe.common.runWithRecord
import org.junit.jupiter.api.Test

class CoroutineContextAndDispatchersTest {

    private val coroutineContextAndDispatchers = CoroutineContextAndDispatchers()

    @Test
    fun dispatcherAndThreadTest() {
        runWithRecord {
            coroutineContextAndDispatchers.dispatcherAndThread()
        }
    }

    @Test
    fun unconfinedVsConfinedDispatcherTest() {
        runWithRecord {
            coroutineContextAndDispatchers.unconfinedVsConfinedDispatcher()

        }
    }
}