package challenge_may_2020

import Test
import kotlin.math.max
import kotlin.math.min

fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
    val res = MutableList(0) {
        IntArray(2)
    }

    var i = 0
    var j = 0

    while (i < A.size && j < B.size) {
        val low = max(A[i][0], B[j][0])
        val high = min(A[i][1], B[j][1])
        if (low <= high) res.add(intArrayOf(low, high))
        if (A[i][1] < B[j][1]) i++ else j++
    }

    return res.toTypedArray()
}

fun main() {
    Test.assert(intervalIntersection(
            arrayOf(intArrayOf(0, 2),
                    intArrayOf(5, 10),
                    intArrayOf(13, 23),
                    intArrayOf(24, 25)),
            arrayOf(intArrayOf(1, 5),
                    intArrayOf(8, 12),
                    intArrayOf(15, 24),
                    intArrayOf(25, 26)))
            .contentDeepEquals(
                    arrayOf(intArrayOf(1, 2),
                            intArrayOf(5, 5),
                            intArrayOf(8, 10),
                            intArrayOf(15, 23),
                            intArrayOf(24, 24),
                            intArrayOf(25, 25))
            )
    )

    Test.assert(intervalIntersection(
            arrayOf(intArrayOf(8, 15)),
            arrayOf(intArrayOf(2, 6),
                    intArrayOf(8, 10),
                    intArrayOf(12, 20)))
            .contentDeepEquals(
                    arrayOf(intArrayOf(8, 10),
                            intArrayOf(12, 15))
            )
    )
    Test.assert(intervalIntersection(
            arrayOf(intArrayOf(5, 14)),
            arrayOf(intArrayOf(4, 5)))
            .contentDeepEquals(
                    arrayOf(intArrayOf(5, 5))
            )
    )
}