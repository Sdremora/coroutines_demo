import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.Executors
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

//fun main() {
//    val client = OkHttpClient()
//    val request = Request.Builder()
//        .url("https://httpbin.org/get")
//        .build()
//
//    client.newCall(request)
//        .enqueue(
//            object : okhttp3.Callback {
//                override fun onFailure(call: okhttp3.Call, e: IOException) {
//                    println("Ошибка при выполнении запроса: ${e.message}")
//                }
//
//                override fun onResponse(call: okhttp3.Call, response: Response) {
//                    if (response.isSuccessful) {
//                        val responseBody = response.body?.string()
//                        println("Ответ от сервера: $responseBody")
//                    } else {
//                        println("Неуспешный запрос. Код состояния: ${response.code}")
//                    }
//                }
//            })
//}


fun main() {
    val executor = Executors.newSingleThreadScheduledExecutor()

    runBlocking(executor.asCoroutineDispatcher()) {
        val response = httpCall()
        if (response.isSuccessful) {
            val responseBody = response.body?.string()
            println("Ответ от сервера: $responseBody")
        } else {
            println("Неуспешный запрос. Код состояния: ${response.code}")
        }
    }
    println("finish")
}

suspend fun httpCall(): Response {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://httpbin.org/get")
        .build()
    return suspendCoroutine { continuation ->
        client.newCall(request)
            .enqueue(
                object : okhttp3.Callback {
                    override fun onFailure(call: okhttp3.Call, e: IOException) {
                        continuation.resumeWithException(e)
                    }

                    override fun onResponse(call: okhttp3.Call, response: Response) {
                        println("=>>> ${Thread.currentThread().name}")
                        continuation.resume(response)
                    }
                })
    }
}