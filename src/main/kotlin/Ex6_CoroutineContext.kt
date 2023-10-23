import kotlinx.coroutines.*
import java.util.concurrent.Executors
import kotlin.coroutines.ContinuationInterceptor

////запчасти контекста
//fun main() {
//    runBlocking {
//        val job = launch(Dispatchers.IO) {
//            val name = this.coroutineContext[CoroutineName]
//            val job = this.coroutineContext[Job]
//            val exceptionHandler = this.coroutineContext[CoroutineExceptionHandler]
//            val executor = this.coroutineContext[ContinuationInterceptor]
//            println("name: $name")
//            println("job: $job")
//            println("handler: $exceptionHandler")
//            println("executor: $executor")
//        }
//    }
//}

// хендлер для ошибок
//fun main() {
//    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
//        println("Caught $exception")
//    }
//
//    val scope = CoroutineScope(CoroutineName("i am yellow") + exceptionHandler)
//    println("${Thread.currentThread().name} Before")
//    scope.launch {
//        try {
//                println("${Thread.currentThread().name} Before")
//                delay(100)
//                throw RuntimeException("BOOM!")
//                println("After")
//            } catch (e: Exception) {
//                println("catch!")
//            }
//    }
//    Thread.sleep(1000)
//    println("Finish")
//}

//  хендлер не перехватывает отмену (и отмену по таймауту)
//fun main() {
//    runBlocking {
//        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
//            println("Caught $exception")
//        }
//        val scope = CoroutineScope(CoroutineName("i am scope"))
//        scope.launch(exceptionHandler) {
//            println("Before")
//
//            try {
//                delay(5000)
//            } catch (e: CancellationException) {
//                println("!!")
//            }
//            println("After")
//        }.invokeOnCompletion { println("finished") }
//        delay(100)
//        scope.cancel()
//        scope.coroutineContext.job.join()
//    }
//}

// отмена = CancellationException, отмена по таймауту TimeoutCancellationException
//fun main() {
//    runBlocking {
//        val exceptionHandler = CoroutineExceptionHandler { _, exception ->
//            println("Caught $exception")
//        }
//        val scope = CoroutineScope(CoroutineName("i am scope"))
//        scope.launch(exceptionHandler) {
//            println("Before")
//            withTimeout(100) {
//                delay(5000)
//            }
////            throw CancellationException("same")
//            println("After")
//        }.invokeOnCompletion { println("finished") }
//        scope.coroutineContext.job.join()
//    }
//}

// Structured concurrency сделано через наследование Job
// SupervisorJob не ломает корутины внутри себе (но при отмене ломает)
//fun main() = runBlocking {
//    val exceptionHandler = CoroutineExceptionHandler { context, exception ->
//        println("Caught $exception")
//    }
////    val scope = CoroutineScope(CoroutineName("i am yellow") )
////    val scope2 = CoroutineScope(CoroutineName("i am red") )
//    val scope = CoroutineScope(CoroutineName("i am yellow") + exceptionHandler + SupervisorJob())
//    scope.launch {
//        delay(500)
//        throw RuntimeException("BOOM!")
//        println("==> First!")
//    }.invokeOnCompletion { println("first finished") }
//    scope.launch {
//        delay(100)
//        println("==> Second!")
//    }.invokeOnCompletion { println("second finished") }
//    scope.launch {
//        delay(700)
//        println("==> Third!")
//    }.invokeOnCompletion { println("third finished") }
//
//    val scopeJob = scope.coroutineContext.job
//    println("ScopeJob has ${scopeJob.children.count()} children")
//    scopeJob.join()
//    println("Finish")
//}

// exception в async можно перехватить при обращении
//fun main() {
//    runBlocking {
//        val scope = CoroutineScope(CoroutineName("xD"))
//        val result = scope.async {
//            println("in async coroutine")
//            delay(100)
//            throw RuntimeException("Boom!")
//            "result"
//        }
//        println("i am ok!")
//        delay(500)
////        result.await()
//        try {
//            result.await()
//        } catch (ex: RuntimeException) {
//            println(ex)
//        }
//        println("i am ok!")
//    }
//    println("Finish")
//}


//fun main() {
//    runBlocking {
//
//        val scope1 = CoroutineScope(CoroutineName("i am yellow"))
//        val scope2 = CoroutineScope(CoroutineName("i am green") + SupervisorJob() + Dispatchers.IO)
////        scope1.launch {
////            print("1")
////            scope2.launch {
////                print(" + 1")
////            }
////
////            launch {
////                delay(200)
////                print(" = 4\n")
////            }
////            delay(100)
////            throw RuntimeException("BOOM2!")
////        }
//        scope2.launch {
//            delay(100)
//            scope2.launch() { throw RuntimeException("BOOM1!") }
//            delay(100)
//            print(" + 2")
//        }
//        scope2.launch{
//            delay(500)
//            print(" = 2\n")
//        }
//        delay(1000)
//        println("Finish")
//    }
//}

//fun main() {
//    runBlocking {
//        withTimeout(100) {
//            this.launch(Dispatchers.IO) {
//                if (isActive) {
//                    Thread.sleep(5000)
//                }
//            }
//        }
//    }
//}

fun main() {
    runBlocking {
        throw RuntimeException("xc")
    }
    println("xD")
}