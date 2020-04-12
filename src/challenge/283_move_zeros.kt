package challenge

fun moveZeroes(nums: IntArray) {

    var lastNonZero = nums.size - 1

    while (lastNonZero >= 0) {
        val item = nums[lastNonZero]
        if (item == 0) {
            lastNonZero--
            continue
        } else {
            var zeroIndex = lastNonZero - 1

            while (zeroIndex in 0 until lastNonZero) {
                if (nums[zeroIndex] == 0) {
                    nums[zeroIndex] = nums[zeroIndex + 1]
                    nums[zeroIndex + 1] = 0

                    zeroIndex++
                } else {
                    zeroIndex--
                }
            }

            lastNonZero--
        }
    }
}

fun main() {

    val array = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(array)
    Test.assert(array.contentEquals(intArrayOf(1, 3, 12, 0, 0)))

    val array2 = intArrayOf(0, 1)
    moveZeroes(array2)
    Test.assert(array2.contentEquals(intArrayOf(1, 0)))
}