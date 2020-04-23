package challenge

fun rangeBitwiseAnd(m: Int, n: Int): Int {

    val start = System.currentTimeMillis()

    var result = m

    if (m in 1 until n) {
        for (i in (m + 1)..n) {
            result = result and i
        }
    }

    val end = System.currentTimeMillis()

    println("Time ${end - start}")

    return result
}

fun main() {
    Test.assert(rangeBitwiseAnd(5, 7), 4)
    Test.assert(rangeBitwiseAnd(0, 1), 0)
    Test.assert(rangeBitwiseAnd(0, 0), 0)
    Test.assert(rangeBitwiseAnd(1, 1), 1)
    Test.assert(rangeBitwiseAnd(0, 2147483647), 0)
    Test.assert(rangeBitwiseAnd(2147483647, 2147483647), 2147483647)
    Test.assert(rangeBitwiseAnd(1, 2), 0)
}