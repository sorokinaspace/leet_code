package challenge_may_2020

fun findAnagrams(s: String, p: String): List<Int> {
    val res = mutableListOf<Int>()

    val dict = mutableMapOf<Char, Int>()

    p.forEach {
        dict[it] = (dict[it] ?: 0) + 1
    }

    val lastIndex = p.lastIndex
    val dictChars = mutableMapOf<Char, Int>()

    for (i in 0..s.lastIndex) {
        dictChars[s[i]] = (dictChars[s[i]] ?: 0) + 1
        if (dict == dictChars) {
            res.add(i - lastIndex)
        }
        println("Dict: $dictChars")

        if (i >= lastIndex) {
            with(s[i - lastIndex]) {
                val newCount = (dictChars[this] ?: 0) - 1
                if (newCount == 0) {
                    dictChars.remove(this)
                } else {
                    dictChars[this] = newCount
                }
            }
        }
    }

    println("Res: $res")

    return res
}

fun main() {
    Test.assert(findAnagrams("cbaebabacd", "abc") == listOf(0, 6))
    Test.assert(findAnagrams("abab", "ab") == listOf(0, 1, 2))
    Test.assert(findAnagrams("baa", "aa") == listOf(1))
}