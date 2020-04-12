package challenge

import kotlin.math.max

fun maxSubArray(nums: IntArray): Int {

    var maximum = Integer.MIN_VALUE
    var current = 0
    var addNew = true

    nums.forEach { num ->

        if (addNew) {
            current = max(current + num, num)
        } else {
            current += num
        }

        maximum = max(maximum, current)

        addNew = num < 0
    }

    return maximum
}

fun main() {
    Test.assert(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)), 6)
    Test.assert(maxSubArray(intArrayOf(1)), 1)
    Test.assert(maxSubArray(intArrayOf(-1)), -1)
}