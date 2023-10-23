import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

fun main() {
    println("${Thread.currentThread().name} start")
    runBlocking {
        val result = funcThatCanBeSuspended()
        println(result)
    }
    println("${Thread.currentThread().name} finish")
}

suspend fun funcThatCanBeSuspended() = suspendCoroutine { continuation ->
    heavyFunc(continuation)
    println("after heavyFunc call")
}

fun heavyFunc(continuation: Continuation<String>) {
    println("!!")
    thread {
        println("${Thread.currentThread().name} Before sleep")
        Thread.sleep(1000)
        println("${Thread.currentThread().name} After sleep")
        continuation.resume("i am ready!")
        Thread.sleep(1000)
        println("===>")
    }
}