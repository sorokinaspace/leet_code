package challenge

import kotlin.math.abs

fun stringShift(s: String, shift: Array<IntArray>): String {

    val moves = squashMoves(shift)

    val leftMoves = moves.remove(0) ?: 0
    val rightMoves = moves.remove(1) ?: 0

    val diff = abs(leftMoves - rightMoves) % s.length

    return if (leftMoves > rightMoves) {
        s.drop(diff) + s.take(diff)
    } else {
        s.takeLast(diff) + s.dropLast(diff)
    }.apply {
        println(this)
    }
}

private fun squashMoves(moves: Array<IntArray>): MutableMap<Int, Int> {

    return mutableMapOf(0 to 0, 1 to 0).apply {
        moves.forEach {
            val direction = it[0]
            val count = it[1]

            this[direction] = (this[direction] ?: 0) + count
        }
    }
}

fun main() {
    Test.assert(stringShift("abc", arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))) == "cab")
    Test.assert(
        stringShift(
            "abcdefg", arrayOf(
                intArrayOf(1, 1),
                intArrayOf(1, 1),
                intArrayOf(0, 2),
                intArrayOf(1, 3)
            )
        ) == "efgabcd"
    )

    Test.assert(
        stringShift(
            "mecsk", arrayOf(
                intArrayOf(1, 4),
                intArrayOf(0, 5),
                intArrayOf(0, 4),
                intArrayOf(1, 1),
                intArrayOf(1, 5)
            )
        ) == "kmecs"
    )

    Test.assert(
        stringShift(
            "xqgwkiqpif", arrayOf(
                intArrayOf(1, 4),
                intArrayOf(0, 7),
                intArrayOf(0, 8),
                intArrayOf(0, 7),
                intArrayOf(0, 6),
                intArrayOf(1, 3),
                intArrayOf(0, 1),
                intArrayOf(1, 7),
                intArrayOf(0, 5),
                intArrayOf(0, 6)
            )
        ) == "qpifxqgwki"
    )
}