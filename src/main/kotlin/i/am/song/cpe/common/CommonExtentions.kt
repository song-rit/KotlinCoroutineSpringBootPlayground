package i.am.song.cpe.common

import kotlin.system.measureTimeMillis

 fun runWithRecord(u: () -> Unit?) {
     val time = measureTimeMillis() {
         run(u)
     }
     println("total time: $time")
}

