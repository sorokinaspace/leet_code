package challenge_may_2020

fun isPerfectSquare(num: Int): Boolean {
    var x = num.toLong()

    while (x * x > num) {
        x = (x + num / x) / 2
    }

    return x * x == num.toLong()
}

fun main() {
    Test.assert(isPerfectSquare(16))
    Test.assert(!isPerfectSquare(14))
    Test.assert(isPerfectSquare(1))
    Test.assert(!isPerfectSquare(2147483647))
}