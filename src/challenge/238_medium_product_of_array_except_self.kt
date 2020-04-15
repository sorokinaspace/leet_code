package challenge

fun productExceptSelf(nums: IntArray): IntArray {

    val result = IntArray(nums.size)

    result[0] = 1
    for (i in 1 until nums.size) {
        result[i] = nums[i - 1] * result[i - 1]
    }

    var right = 1
    for (i in nums.size - 1 downTo 0) {
        result[i] = result[i] * right
        right *= nums[i]
    }

    return result
}

fun main() {
    Test.assert(productExceptSelf(intArrayOf(1, 2, 3, 4)).contentEquals(intArrayOf(24, 12, 8, 6)))
    Test.assert(productExceptSelf(intArrayOf(0, 1)).contentEquals(intArrayOf(1, 0)))
    Test.assert(productExceptSelf(intArrayOf(0, 0)).contentEquals(intArrayOf(0, 0)))
    Test.assert(productExceptSelf(intArrayOf(9, 0, -2)).contentEquals(intArrayOf(0, -18, 0)))
}