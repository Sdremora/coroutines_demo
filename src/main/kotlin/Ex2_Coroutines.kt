import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        try {
            val userData = coFetchUserData()
            val processedData = coProcessUserData(userData)
            val result = coFinalProcessing(processedData)
            println("Результат: $result")
        } catch (ex: RuntimeException) {
            println("Произошла ошибка: " + ex.message)
        }
    }
}

suspend fun coFetchUserData(): String {
    delay(1000)
    return "Пользовательские данные"
}

suspend fun coProcessUserData(userData: String): String {
    delay(500)
    return "Обработанные данные: $userData"
}

suspend fun coFinalProcessing(processedData: String): String {
    delay(300)
    return "Итоговый результат: $processedData"
}