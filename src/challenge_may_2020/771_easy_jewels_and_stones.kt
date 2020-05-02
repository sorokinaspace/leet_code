package challenge_may_2020

fun numJewelsInStones(J: String, S: String): Int {

    var result = 0

    S.forEach {
        if (J.contains(it)) result++
    }

    return result
}

fun main() {
    Test.assert(numJewelsInStones("aA", "aAAbbbb"), 3)
    Test.assert(numJewelsInStones("z", "ZZ"), 0)
}