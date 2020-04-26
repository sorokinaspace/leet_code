package challenge

import kotlin.math.max

// if i == 0 || j == 0 -> DP[i - 1][j - 1] == 0
// if text1[i] == text2[j] -> DP[i][j] = DP[i - 1][j - 1] + 1
// otherwise -> DP[i][j] = max(DP[i - 1][j], DP[i][j - 1])

fun longestCommonSubsequence(text1: String, text2: String): Int {

    val matrix = Array(text1.length) {
        IntArray(text2.length)
    }

    for (i in 0..text1.lastIndex) {
        for (j in 0..text2.lastIndex) {
            val iPrev = if (i > 0) i - 1 else 0
            val jPrev = if (j > 0) j - 1 else 0

            if (text1[i] == text2[j]) {
                matrix[i][j] = if (i == 0 || j == 0) 1 else matrix[iPrev][jPrev] + 1
            } else {
                matrix[i][j] = max(matrix[iPrev][j], matrix[i][jPrev])
            }
        }
    }

    matrix.forEach {
        println()
        it.forEach {
            print(" $it")
        }
    }
    println()

    return matrix[text1.lastIndex][text2.lastIndex]
}

fun main() {
    Test.assert(longestCommonSubsequence("abcde", "ace"), 3)
    Test.assert(longestCommonSubsequence("abc", "abc"), 3)
    Test.assert(longestCommonSubsequence("abc", "def"), 0)
    Test.assert(longestCommonSubsequence("ezupkr", "ubmrapg"), 2)
    Test.assert(longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"), 2)
    Test.assert(longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"), 4)
    Test.assert(
        longestCommonSubsequence(
            "lcnqdmvsdopkvqvejijcdyxetuzonuhuzkpelmva",
            "bklgfivmpozinybwlovcnafqfybodkhabyrglsnen"
        ), 9
    )
}