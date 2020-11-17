package i.am.song.cpe.playground

import i.am.song.cpe.common.GreetingService

class LaunchPlayground {

    private val greetingService = GreetingService()

    fun doGreetingInMainThread() {
        // block the main thread
        greetingService.greeting()
    }
}