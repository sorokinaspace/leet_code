package problems

fun wordPattern(pattern: String, str: String): Boolean {

    val strList = str.split(" ").toMutableList()
    val patterList = pattern.toMutableList()

    if (strList.size != pattern.length) {
        return false
    }

    while (patterList.isNotEmpty()) {
        val patItem = patterList.removeAt(0)
        val strItem = strList.removeAt(0)

        for (i in patterList.size - 1 downTo 0) {
            if (patItem == patterList[i]) {
                if (strItem == strList[i]) {
                    strList.removeAt(i)
                    patterList.removeAt(i)
                } else {
                    return false
                }
            } else if (strItem == strList[i]) {
                return false
            }
        }
    }

    return true
}

fun main() {
    Test.assert(wordPattern("abba", "dog cat cat dog"), true,"abba -> dog cat cat dog")
    Test.assert(wordPattern("abba", "dog cat cat fish"),false, "abba -> dog cat cat fish")
    Test.assert(wordPattern("aaaa", "dog cat cat dog"), false, "aaaa -> dog cat cat dog")
    Test.assert(wordPattern("abba", "dog dog dog dog"), false, "abba -> dog dog dog dog")
}