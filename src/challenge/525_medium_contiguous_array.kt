package challenge

import Test
import java.util.*
import kotlin.math.max

fun findMaxLength(nums: IntArray): Int {

    val map: MutableMap<Int, Int> = HashMap()
    var maxlen = 0
    var count = 0

    for (i in nums.indices) {
        count += if (nums[i] == 1) 1 else -1

        if (count == 0) {
            maxlen = i + 1
        } else if (map[count] != null) {
            maxlen = max(maxlen, i - map[count]!!)
        } else {
            map[count] = i
        }
    }

    return maxlen
}

fun main() {

    Test.assert(findMaxLength(intArrayOf(0, 1)), 2)
    Test.assert(findMaxLength(intArrayOf(0, 1, 0)), 2)
    Test.assert(findMaxLength(intArrayOf(0, 0, 1, 0, 0, 0, 1, 1)), 6)
    Test.assert(findMaxLength(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)), 0)
    Test.assert(findMaxLength(intArrayOf(0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0)), 2)

    Test.assert(findMaxLength(intArrayOf(0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1
        ,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0
        ,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1)), 68)
}