package i.am.song.cpe.common

class GreetingService {

    private val className = this::class.simpleName.toString()

    fun greeting(msg: String) {
        printMessage(msg)
    }

    fun getGreeting(msg: String): String {
        printMessage(msg)
        return msg
    }

    suspend fun getGreetingWithSuspend(msg: String): String {
        printMessage(msg)
        return msg
    }

    private fun printMessage(msg: String) {
        println("$className #(name: ${Thread.currentThread().name}, id: ${Thread.currentThread().id} ) -> ${RecordTimeInstance.currentExecuteTime()} millisecond, msg $msg ")
    }
}
