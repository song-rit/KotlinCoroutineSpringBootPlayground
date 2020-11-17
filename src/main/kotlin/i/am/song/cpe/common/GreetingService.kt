package i.am.song.cpe.common

class GreetingService {

    private val className = this::class.simpleName.toString()

    fun greeting(msg: String) {
        printMessage(msg)
    }

    private fun printMessage(msg: String) {
        println("$className #(name: ${Thread.currentThread().name}, id: ${Thread.currentThread().id} ) -> ${RecordTimeInstance.currentExecuteTime()} millisecond, msg $msg ")
    }
}
