package challenge_may_2020

/**
 * On one line if:
 * (𝑦2−𝑦1) / (𝑥2−𝑥1) = (𝑦3−𝑦1) / (𝑥3−𝑥1)
  */
fun checkStraightLine(coordinates: Array<IntArray>): Boolean {

    if (coordinates.size > 2) {
        val first: Pair<Int, Int> = coordinates[0].run { this[0] to this[1] }
        val second: Pair<Int, Int> = coordinates[1].run { this[0] to this[1] }

        for (i in 2..coordinates.lastIndex) {
            val last: Pair<Int, Int> = coordinates[i].run { this[0] to this[1] }

            val xLeftDiff = (second.first - first.first).toFloat()
            val yLeftDiff = second.second - first.second

            val xRightDiff: Float = (last.first - first.first).toFloat()
            val yRightDiff = last.second - first.second

            if (xLeftDiff == 0f && xRightDiff == 0f ||
                (yLeftDiff / xLeftDiff) == (yRightDiff / xRightDiff)
            ) {
                println("Pass [${last.first}, ${last.second}]")
            } else {
                println("Not on line [${last.first}, ${last.second}]")
                return false
            }
        }
    }
    return true
}

fun main() {
    Test.assert(
        checkStraightLine(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(5, 6),
                intArrayOf(6, 7)
            )
        )
    )

    Test.assert(
        !checkStraightLine(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(2, 2),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(5, 6),
                intArrayOf(7, 7)
            )
        )
    )

    Test.assert(
        checkStraightLine(
            arrayOf(
                intArrayOf(-3, -2),
                intArrayOf(-1, -2),
                intArrayOf(2, -2),
                intArrayOf(-2, -2),
                intArrayOf(0, -2)
            )
        )
    )

    Test.assert(
        checkStraightLine(
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 3),
                intArrayOf(-4, -7),
                intArrayOf(5, 11)
            )
        )
    )
}