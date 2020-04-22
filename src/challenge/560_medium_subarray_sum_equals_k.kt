package challenge

import Test

fun subarraySum(nums: IntArray, k: Int): Int {
    var count = 0
    var sum = 0
    val map = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        sum += nums[i]

        if (sum == k) {
            count++
        }

        val diff = map[sum - k]
        if (diff != null) {
            count += diff
        }

        map[sum] = map.getOrDefault(sum, 0) + 1
    }

    return count
}

fun main() {
    Test.assert(subarraySum(intArrayOf(1), 1), 1)
    Test.assert(subarraySum(intArrayOf(1, 1, 1), 2), 2)
    Test.assert(subarraySum(intArrayOf(1, 2, 3), 3), 2)
    Test.assert(subarraySum(intArrayOf(-1, -1, 1), 0), 1)
    Test.assert(subarraySum(intArrayOf(28, 54, 7, -70, 22, 65, -6), 100), 1)
    Test.assert(subarraySum(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 0), 55)
    Test.assert(
        subarraySum(
            intArrayOf(
                -27, 125, 209, -84, -222, -137, 112, -76, 200, -139, 200
                , 61, -215, 121, 318, -128, 121, 216, -132, 165, -19, 89, 193, -59, 203, 8, 140, -128, -201, 199
                , -5, 36, -167, -140, -194, -166, 182, -50, 729, -167, -114, -71, 108, -40, -189, 188, -109, 69
                , -134, 682, 173, -89, -114, -177, 194, -1, 168, -42, -55, -32, 198, 171, 45, 25, -18, 154, -22
                , -192, 213, 86, -16
            ), 223
        ), 10
    )
}