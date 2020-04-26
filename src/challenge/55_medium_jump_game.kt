package challenge

import java.util.*

fun canJump(nums: IntArray): Boolean {
    var lastPos = nums.lastIndex

    for (i in nums.lastIndex downTo 0) {
        if (i + nums[i] >= lastPos) {
            lastPos = i
        }
    }

    return 0 == lastPos
}

fun canJump2(nums: IntArray): Boolean {

    nums.firstOrNull()?.let {

        val visited = BooleanArray(nums.size)

        val nodes = Stack<Int>().apply {
            push(0)
        }

        while (nodes.isNotEmpty()) {
            val currentIndex = nodes.pop()

            if (currentIndex == nums.lastIndex) return true

            for (i in 1..nums[currentIndex]) {
                val childIndex = i + currentIndex

                if (childIndex > nums.lastIndex || visited[childIndex]) continue
                else {
                    nodes.push(childIndex)
                    visited[childIndex] = true
                }
            }
        }
    }

    return false
}

fun main() {
    Test.assert(canJump(intArrayOf(2, 3, 1, 1, 4)))
    Test.assert(canJump(intArrayOf(2, 0, 0)))
    Test.assert(canJump(intArrayOf(2, 5, 0, 0)))
    Test.assert(
        canJump(
            intArrayOf(
                8,
                2,
                4,
                4,
                4,
                9,
                5,
                2,
                5,
                8,
                8,
                0,
                8,
                6,
                9,
                1,
                1,
                6,
                3,
                5,
                1,
                2,
                6,
                6,
                0,
                4,
                8,
                6,
                0,
                3,
                2,
                8,
                7,
                6,
                5,
                1,
                7,
                0,
                3,
                4,
                8,
                3,
                5,
                9,
                0,
                4,
                0,
                1,
                0,
                5,
                9,
                2,
                0,
                7,
                0,
                2,
                1,
                0,
                8,
                2,
                5,
                1,
                2,
                3,
                9,
                7,
                4,
                7,
                0,
                0,
                1,
                8,
                5,
                6,
                7,
                5,
                1,
                9,
                9,
                3,
                5,
                0,
                7,
                5
            )
        )
    )
    Test.assert(
        canJump(
            intArrayOf(
                1,
                2,
                2,
                6,
                3,
                6,
                1,
                8,
                9,
                4,
                7,
                6,
                5,
                6,
                8,
                2,
                6,
                1,
                3,
                6,
                6,
                6,
                3,
                2,
                4,
                9,
                4,
                5,
                9,
                8,
                2,
                2,
                1,
                6,
                1,
                6,
                2,
                2,
                6,
                1,
                8,
                6,
                8,
                3,
                2,
                8,
                5,
                8,
                0,
                1,
                4,
                8,
                7,
                9,
                0,
                3,
                9,
                4,
                8,
                0,
                2,
                2,
                5,
                5,
                8,
                6,
                3,
                1,
                0,
                2,
                4,
                9,
                8,
                4,
                4,
                2,
                3,
                2,
                2,
                5,
                5,
                9,
                3,
                2,
                8,
                5,
                8,
                9,
                1,
                6,
                2,
                5,
                9,
                9,
                3,
                9,
                7,
                6,
                0,
                7,
                8,
                7,
                8,
                8,
                3,
                5,
                0
            )
        )
    )
}