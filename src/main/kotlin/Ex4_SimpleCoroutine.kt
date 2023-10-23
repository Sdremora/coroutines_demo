import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main() = runBlocking {
    var value = 0
    println(value)
    delay(100)
    value = value + 1
    println(value)
    delay(100)
    val field = "$value!"
    delay(100)
    println(field)
}