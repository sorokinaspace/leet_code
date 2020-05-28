package challenge_may_2020

fun countBits(num: Int): IntArray {
    val res = IntArray(num + 1)

    for (i in 0..num) {
        res[i] = res[i shr 1] + (i and 1)
    }

    return res
}

fun main() {
    Test.assert(countBits(2).contentEquals(intArrayOf(0, 1, 1)))
    Test.assert(countBits(5).contentEquals(intArrayOf(0, 1, 1, 2, 1, 2)))
}