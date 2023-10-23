fun main() {
    val values = List(10) {
        fibonacci(it)
    }
    println(values)
}

fun fibonacci(n: Int): Int {
    return when (n) {
        0 -> 0
        1 -> 1
        else -> fibonacci(n - 1) + fibonacci(n - 2)
    }
}

























//fun main() {
//    val iterator = fibonacciNumber().iterator()
//    repeat(10) {
//        print("${iterator.next()} ")
//    }
//}
//
//fun fibonacciNumber() = sequence {
//    var cur = 0
//    var next = 1
//    while (true) {
//        yield(cur)
//        val tmp = cur + next
//        cur = next
//        next = tmp
//    }
//}