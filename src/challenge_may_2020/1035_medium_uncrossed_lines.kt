package challenge_may_2020

import kotlin.math.max

fun maxUncrossedLines(A: IntArray, B: IntArray): Int {

    val matrix = Array(A.size) {
        IntArray(B.size)
    }

    for (i in 0..A.lastIndex) {
        for (j in 0..B.lastIndex) {
            val iPrev = if (i > 0) i - 1 else 0
            val jPrev = if (j > 0) j - 1 else 0

            if (A[i] == B[j]) {
                matrix[i][j] = if (i == 0 || j == 0) 1 else matrix[iPrev][jPrev] + 1
            } else {
                matrix[i][j] = max(matrix[iPrev][j], matrix[i][jPrev])
            }
        }
    }

    return matrix[A.lastIndex][B.lastIndex]
}

fun main() {
    Test.assert(maxUncrossedLines(intArrayOf(1, 4, 2), intArrayOf(1, 2, 4)), 2)
    Test.assert(maxUncrossedLines(intArrayOf(2, 5, 1, 2, 5), intArrayOf(10, 5, 2, 1, 5, 2)), 3)
    Test.assert(maxUncrossedLines(intArrayOf(1, 3, 7, 1, 7, 5), intArrayOf(1, 9, 2, 5, 1)), 2)
    Test.assert(maxUncrossedLines(intArrayOf(2, 3, 1), intArrayOf(3, 1, 3, 3, 3, 3)), 2)
    Test.assert(maxUncrossedLines(intArrayOf(3), intArrayOf(3, 3, 2)), 1)
}