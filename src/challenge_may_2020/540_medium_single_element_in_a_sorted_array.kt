package challenge_may_2020

// O(N)
fun singleNonDuplicate2(nums: IntArray): Int {

    var i = 0

    while (i < nums.lastIndex) {
        if (nums[i] != nums[i + 1]) {
            return when {
                i == 0 -> nums[i]
                nums[i] != nums[i - 1] -> nums[i]
                else -> nums[i + 1]
            }
        } else {
            i += 2
        }
    }

    return nums[nums.lastIndex]
}

// O(log N)
fun singleNonDuplicate(nums: IntArray): Int {

    var start = 0
    var end = nums.lastIndex

    var i = 0

    while (start < end) {
        i = start + (end - start) / 2

        println("nums[$i] = ${nums[i]}, start = $start, end = $end")

        val sameLeft = if (i > 0) nums[i] == nums[i - 1] else false
        val sameRight = if (i < nums.lastIndex) nums[i] == nums[i + 1] else false

        val leftDiff = if (sameLeft) 1 else 0
        val rightDiff = if (sameRight) 1 else 0

        if (!sameLeft && !sameRight) {
            return nums[i]
        } else if ((i - leftDiff - start) % 2 > 0) {
            end = i - leftDiff
        } else {
            start = i + 1 + rightDiff
        }
    }

    return nums[end]
}

fun main() {
    Test.assert(singleNonDuplicate(intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8)), 2)
    Test.assert(singleNonDuplicate(intArrayOf(3, 3, 7, 7, 10, 11, 11)), 10)
    Test.assert(singleNonDuplicate(intArrayOf(1)), 1)
    Test.assert(singleNonDuplicate(intArrayOf(1, 1, 2)), 2)
    Test.assert(singleNonDuplicate(intArrayOf(1, 1, 2, 3, 3)), 2)
    Test.assert(singleNonDuplicate(intArrayOf(1, 1, 2, 2, 3)), 3)
    Test.assert(singleNonDuplicate(intArrayOf(1, 1, 2, 2, 4, 4, 5, 5, 9)), 9)
}