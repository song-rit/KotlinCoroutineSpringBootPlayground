package i.am.song.cpe.common

class GreetingService {

    private val className = this::class.simpleName.toString()

    fun greeting(msg: String) {
        RecordTimeInstance.printStartExecuteTime(className)
        printMessage(msg)
        RecordTimeInstance.printEndExecuteTime(className)
    }

    private fun printMessage(msg: String) {
        println("$className #${Thread.currentThread().id} -> ${RecordTimeInstance.currentExecuteTime()} millisecond (current), msg $msg ")
    }
}
