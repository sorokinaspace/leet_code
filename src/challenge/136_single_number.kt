package challenge

fun singleNumber(nums: IntArray): Int {

    val uniqueSet = mutableSetOf<Int>()

    nums.forEach {
        if (!uniqueSet.add(it)) {
            uniqueSet.remove(it)
        }
    }

    return uniqueSet.single()
}


fun singleNumberWithXor(nums: IntArray): Int {

    var result = 0

    nums.forEach {
        result = result xor it
    }

    return result
}

fun main() {
    Test.assert(singleNumberWithXor(intArrayOf(2, 4, 1, 1, 2)), 4)
}
