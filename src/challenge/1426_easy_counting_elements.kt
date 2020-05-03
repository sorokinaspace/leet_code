package challenge

fun countElements(arr: IntArray): Int {
    val uniques = arr.toSortedSet()
    var result = 0

    arr.forEach {
        if (uniques.contains(it + 1)) {
            result++
        }
    }
    return result
}

fun main() {
    Test.assert(countElements(intArrayOf(1, 2, 3)), 2)
    Test.assert(countElements(intArrayOf(1, 1, 3, 3, 5, 5, 7, 7)), 0)
    Test.assert(countElements(intArrayOf(1, 3, 2, 3, 5, 0)), 3)
    Test.assert(countElements(intArrayOf(1, 1, 2, 2)), 2)
}