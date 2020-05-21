package challenge_may_2020

import kotlin.math.min

fun countSquares(matrix: Array<IntArray>): Int {

    val result = Array(matrix.size + 1) {
        IntArray(matrix.first().size + 1)
    }

    var count = 0

    for (row in 1..result.lastIndex) {
        for (column in 1..result[row].lastIndex) {

            if (matrix[row - 1][column - 1] == 1) {
                val top = result[row - 1][column]
                val left = result[row][column - 1]
                val diagonal = result[row - 1][column - 1]

                result[row][column] = min(min(top, left), diagonal) + 1

                count += result[row][column]
            }
        }
    }

    return count
}

fun main() {
    Test.assert(countSquares(arrayOf(
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(0, 1, 1, 1))), 15)

    Test.assert(countSquares(arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0))), 7)

    Test.assert(countSquares(arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0)
    )), 8)
}