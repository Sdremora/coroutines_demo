import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

//fun main() = runBlocking {
//    val jobs = List(100_000) {
//        launch {
//            delay(1000)
//            print(".")
//        }
//    }
//    jobs.forEach { it.join() }
//    println("\nfinish")
//}

fun main() = runBlocking {
    val jobs = List(10_000) {
        thread {
            Thread.sleep(1000)
            print(".")
        }
    }
    jobs.forEach { it.join() }
    println("\nfinish")
}