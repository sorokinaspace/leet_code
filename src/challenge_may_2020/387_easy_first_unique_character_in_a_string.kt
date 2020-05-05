package challenge_may_2020

fun firstUniqChar(s: String): Int {
    val map = mutableMapOf<Char, Int>()

    s.forEachIndexed { index, char ->
        map[char] = if (map.containsKey(char)) -1 else index
    }

    return map.values.firstOrNull { it != -1 } ?: -1
}

fun main() {
    Test.assert(firstUniqChar("leetcode"), 0)
    Test.assert(firstUniqChar("loveleetcode"), 2)
}