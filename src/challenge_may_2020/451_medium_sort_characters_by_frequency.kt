package challenge_may_2020

fun frequencySort(s: String): String {
    val map = s.groupBy { it }.map { Pair(it.key, it.value.size) }.sortedByDescending { it.second }
    return map.joinToString("") { it.first.toString().repeat(it.second) }
}

fun main() {
    Test.assert(frequencySort("tree"), "eetr")
    Test.assert(frequencySort("cccaaa"), "cccaaa")
    Test.assert(frequencySort("Aabb"), "bbAa")
}