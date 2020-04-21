package challenge

import common.BinaryMatrix
import common.BinaryMatrixImpl

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * class BinaryMatrix {
 *     fun get(x:Int, y:Int):Int {}
 *     fun dimensions():List<Int> {}
 * }
 */

fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
    var result = -1

    val dims = binaryMatrix.dimensions()
    val xLen = dims[0] - 1

    var currentX = xLen
    var currentY = dims[1] - 1

    val ignoreX = mutableListOf<Int>()

    while (currentX > -1 && currentY > -1) {
        println("Current [$currentX][$currentY]")

        if (binaryMatrix.get(currentX, currentY) == 1) {
            result = currentY
            currentY--
        } else {
            ignoreX.add(currentX)

            currentX = -1

            for (i in 0..xLen) {
                if (!ignoreX.contains(i)) {
                    if (binaryMatrix.get(i, currentY) == 1) {
                        currentX = i
                        println("Jump to X=$i")
                        break
                    } else {
                        ignoreX.add(i)
                        println("Add to ignore X=$i")
                    }
                }
            }

            if (currentX == -1) {
                println("No new X, break")
                break
            }
        }
    }

    println("Result $result, matrix $binaryMatrix")

    return result
}

fun main() {

    Test.assert(leftMostColumnWithOne(BinaryMatrixImpl(arrayOf(intArrayOf(0, 0), intArrayOf(1, 1)))), 0)
    Test.assert(leftMostColumnWithOne(BinaryMatrixImpl(arrayOf(intArrayOf(0, 0), intArrayOf(0, 1)))), 1)
    Test.assert(leftMostColumnWithOne(BinaryMatrixImpl(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0)))), -1)
    Test.assert(
        leftMostColumnWithOne(
            BinaryMatrixImpl(
                arrayOf(
                    intArrayOf(0, 0, 0, 1),
                    intArrayOf(0, 0, 1, 1),
                    intArrayOf(0, 1, 1, 1)
                )
            )
        ) == 1
    )
    Test.assert(
        leftMostColumnWithOne(
            BinaryMatrixImpl(
                arrayOf(
                    intArrayOf(1, 1, 1, 1, 1),
                    intArrayOf(0, 0, 0, 1, 1),
                    intArrayOf(0, 0, 1, 1, 1),
                    intArrayOf(0, 0, 0, 0, 1),
                    intArrayOf(0, 0, 0, 0, 0)
                )
            )
        ) == 0
    )

}