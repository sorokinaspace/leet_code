package problems

fun wordPattern2(pattern: String, str: String): Boolean {
    println("START $pattern -> $str")


    if (str.length < pattern.length) {
//        println("Sting is too short")
        return false
    } else if (str.isEmpty()) {
//        println("Both are empty")
        return true
    }

    val patterList = pattern.toMutableList()

    while (patterList.isNotEmpty()) {
        val char = patterList.first()
        val charCount = patterList.count { it == char }
        val parts = pattern.split(char).filter { it.isNotEmpty() }

        println("Char $char: $parts")

        if (parts.size > 1) {
            val reduceLen = parts.maxBy { it.length }?.length ?: Int.MAX_VALUE
            println("Max length = $reduceLen")

            val s = str.first()
            val count = str.count { s == it }

            val strParts = str.split(s).filter { it.length - reduceLen > 0 && it.isNotEmpty() }.map { it.substring(0, it.length - reduceLen) }
            println("Found $count of $s and splited str onto $strParts")

            if (strParts.size < charCount) {
                println("Less str substrings than char count")
                return false
            }

            for (i in 0 until strParts.size) {
                strParts
            }
        }

        patterList.removeAll { it == char }
    }

    println("END $pattern -> $str")
    return false
}

//fun dropSimilar(parts: List<String>, min: Int): Boolean {
//
//}

fun main() {
//    Test.assertIsTrue(wordPattern2("abcd", "asd"), false, "abcd -> asd")
//    Test.assertIsTrue(wordPattern2("abcd", "sldfjnskjnfsd"), true, "abcd -> sldfjnskjnfsd")
    Test.assert(wordPattern2("abab", "redblueredblue"), true, "abab -> redblueredblue")
//    Test.assertIsTrue(wordPattern2("aaaa", "asdasdasdasd"), true, "aaaa -> asdasdasdasd")
//    Test.assertIsTrue(wordPattern2("aaaa", "asaasaasaasa"), true, "aaaa -> asaasaasaasa")
//    Test.assertIsTrue(wordPattern2("aabb", "xyzabcxzyabc"), false, "aabb -> xyzabcxzyabc")

}