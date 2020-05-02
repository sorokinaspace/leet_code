package challenge_may_2020

fun numJewelsInStones(J: String, S: String): Int {

    var result = 0

    J.forEach { jewel ->
        result += S.count { it == jewel }
    }

    return result
}

fun main() {
    Test.assert(numJewelsInStones("aA", "aAAbbbb"), 3)
    Test.assert(numJewelsInStones("z", "ZZ"), 0)
}