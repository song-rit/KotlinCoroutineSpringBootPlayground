package i.am.song.cpe.common

class GreetingService {

    fun greeting() {
        println("hello coroutine")
    }

    fun greeting(msg: String) {
        println("hello: $msg")
    }
}