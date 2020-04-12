package challenge

fun isHappy(n: Int): Boolean {

    var result = n
    val results = hashSetOf(result)

    while (true) {
        var sum = 0
        do {
            sum += with(result % 10) { this * this }
            result /= 10

        } while (result > 0)

        result = sum

        if (result == 1) {
            return true
        } else if (!results.add(result)) {
            return false
        }
    }
}

fun main() {
    Test.assert(isHappy(19), true)
    Test.assert(isHappy(2), false)
}