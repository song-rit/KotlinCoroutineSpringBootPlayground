package i.am.song.cpe.common

import java.util.concurrent.TimeUnit

object RecordTimeInstance {
    private var executeTime: Long = 0

    fun initExecuteTime() {
        this.executeTime = currentExecuteTime()
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