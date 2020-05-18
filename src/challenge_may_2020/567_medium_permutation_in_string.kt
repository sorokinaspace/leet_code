package challenge_may_2020

fun checkInclusion(s1: String, s2: String): Boolean {
    val dict = mutableMapOf<Char, Int>()

    s1.forEach {
        dict[it] = (dict[it] ?: 0) + 1
    }

    val lastIndex = s1.lastIndex
    val dictChars = mutableMapOf<Char, Int>()

    for (i in 0..s2.lastIndex) {
        dictChars[s2[i]] = (dictChars[s2[i]] ?: 0) + 1
        if (dict == dictChars) {
            return true
        }

        if (i >= lastIndex) {
            with(s2[i - lastIndex]) {
                val newCount = (dictChars[this] ?: 0) - 1
                if (newCount == 0) {
                    dictChars.remove(this)
                } else {
                    dictChars[this] = newCount
                }
            }
        }
    }

    return false
}

fun main() {
    Test.assert(checkInclusion("ab", "eidbaooo"))
    Test.assert(!checkInclusion("ab", "eidboaoo"))
}