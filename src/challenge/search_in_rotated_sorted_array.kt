package challenge

fun search(nums: IntArray, target: Int): Int {

    if (nums.isEmpty())
        return -1

    var start = 0
    var end = nums.size - 1

    while (nums[start] > nums[end]) {
        val zero = start + (end - start) / 2

        if (nums[zero] > nums[end]) {
            if (start < zero)
                start = zero
            else break
        } else
            end = zero
    }

    println("Moved ${nums[start]} -> ${nums[end]}, target $target")

    if (target <= nums[start] && target >= nums[0]) {
        end = start
        start = 0
    } else if (target >= nums[end] && target <= nums[nums.size - 1]) {
        end = nums.size - 1
    } else if (nums[start] > nums[end]) {
        return -1
    }

    println("${nums[start]} -> ${nums[end]}, target $target")

    do {
        if (nums[start] == target) return start
        else if (nums[end] == target) return end

        val medium = start + (end - start) / 2

        if (nums[medium] == target) return medium
        if (nums[medium] > target) end = medium else start = medium

        if (end - start == 1) break
    } while (start < end)

    return -1
}

fun main() {
    Test.assert(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0) == 4)
    Test.assert(search(intArrayOf(1), 1) == 0)
    Test.assert(search(intArrayOf(3, 1), 1) == 1)
    Test.assert(search(intArrayOf(3, 5, 1), 5) == 1)
    Test.assert(search(intArrayOf(3, 5, 1), 1) == 2)
    Test.assert(search(intArrayOf(3, 5, 1), 3) == 0)
    Test.assert(search(intArrayOf(1, 3, 5), 1) == 0)
    Test.assert(search(intArrayOf(5, 1, 3), 3) == 2)
    Test.assert(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 5) == 1)
    Test.assert(search(intArrayOf(1, 3, 5), 3) == 1)
}