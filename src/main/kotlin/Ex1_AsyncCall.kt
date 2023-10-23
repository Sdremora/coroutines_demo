//import kotlinx.coroutines.delay
//import kotlinx.coroutines.runBlocking
//import java.util.concurrent.CompletableFuture
//import kotlin.concurrent.thread
//
//fun main() {
//    println("${Thread.currentThread().name} beforeCall")
//    val asyncValue = CompletableFuture.supplyAsync{heavyFunc()}
//    val result = asyncValue.get()
//    println(result)
//    println("${Thread.currentThread().name} afterCall")
//}
//
//fun heavyFunc(): String {
//    println("${Thread.currentThread().name} before sleep")
//    Thread.sleep(1000)
//    return "${Thread.currentThread().name} after sleep"
//}
//
//fun main() {
//    println("before ${Thread.currentThread().name}")
//    val thread = thread {
//        println("${Thread.currentThread().name} In thread 2")
//    }
//    println("after ${Thread.currentThread().name}")
//    thread.join()
//}
//
//fun main() {
//    println("${Thread.currentThread().name} beforeCall")
//    runBlocking {
//        val value = run { nonBlockingHeavyFunc() }
//        println(value)
//    }
//    println("${Thread.currentThread().name} afterCall")
//}
//
//suspend fun nonBlockingHeavyFunc(): String {
//    println("${Thread.currentThread().name} before delay")
//    delay(1000)
//    return "${Thread.currentThread().name} after delay"
//}