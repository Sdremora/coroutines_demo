import java.util.concurrent.CompletableFuture

fun main() {
    val future = CompletableFuture
        .supplyAsync { fetchUserData() }
        .thenApply { userData: String -> processUserData(userData) }
        .thenApply { processedData: String -> finalProcessing(processedData) }
        .thenApply { finalResult: String ->
            println("Результат: $finalResult")
            finalResult
        }
        .exceptionally { ex: Throwable ->
            println("Произошла ошибка: " + ex.message)
            null
        }
    future.join()
}

fun fetchUserData(): String {
    Thread.sleep(1000)
    return "Пользовательские данные"
}

fun processUserData(userData: String): String {
    Thread.sleep(500)
    return "Обработанные данные: $userData"
}

fun finalProcessing(processedData: String): String {
    Thread.sleep(300)
    return "Итоговый результат: $processedData"
}