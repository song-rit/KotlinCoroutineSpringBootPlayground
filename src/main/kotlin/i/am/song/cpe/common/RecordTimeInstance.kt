package i.am.song.cpe.common

import java.util.concurrent.TimeUnit

object RecordTimeInstance {
    private lateinit var execClassName: String
    private var executeTime: Long = 0

    fun initInstance(execClassName: String) {
        this.execClassName = execClassName
        this.executeTime = currentExecuteTime()
        println("$execClassName #${Thread.currentThread().id} -> ${durationExecuteMillis()} millisecond (start)")
    }

    fun printEndExecuteTime() {
        println("$execClassName #${Thread.currentThread().id} -> ${durationExecuteMillis()} millisecond (end)")
    }

    fun printCurrentExecuteTime() {
        println("$execClassName #${Thread.currentThread().id} -> ${durationExecuteMillis()} millisecond (current)")
    }

    fun currentExecuteTime(): Long {
       return durationExecuteMillis()
    }

    private fun durationExecuteMillis() : Long {
        val diffTime = currentCurrentTime() - executeTime
        return TimeUnit.MILLISECONDS.toMillis(diffTime);
    }

    private fun currentCurrentTime(): Long {
        return System.currentTimeMillis()
    }
}