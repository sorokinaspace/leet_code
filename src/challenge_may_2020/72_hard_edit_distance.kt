package challenge_may_2020

import Test
import kotlin.math.min

fun minDistance(word1: String, word2: String): Int {
    val M = word1.length
    val N = word2.length
    val dp = Array(M + 1) { IntArray(N + 1) }
    if (M * N == 0) return M + N
    for (i in 0..M) {
        dp[i][0] = i
    }
    for (i in 0..N) {
        dp[0][i] = i
    }
    for (i in 1..M) {
        for (j in 1..N) {
            if (word1[i - 1] == word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = min(dp[i - 1][j], min(dp[i][j - 1], dp[i - 1][j - 1])) + 1
            }
        }
    }
    return dp[M][N]
}

fun main() {
    Test.assert(minDistance("horse", "ros"), 3)
    Test.assert(minDistance("intention", "execution"), 5)
}