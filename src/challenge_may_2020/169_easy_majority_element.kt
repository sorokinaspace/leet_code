package challenge_may_2020

fun majorityElement(nums: IntArray): Int {
    return nums.sorted()[nums.size / 2]
}

fun main() {
    Test.assert(majorityElement(intArrayOf(1)), 1)
    Test.assert(majorityElement(intArrayOf(3, 2, 3)), 3)
    Test.assert(majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)), 2)
}