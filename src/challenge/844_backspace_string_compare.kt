package challenge

fun backspaceCompare(S: String, T: String): Boolean {
    var indexS = S.length - 1
    var indexT = T.length - 1

    while (indexS >= 0 || indexT >= 0) {
        var backspaceS = 0
        var charS: Char? = null

        while (indexS >= 0 && charS == null) {
            when {
                S[indexS] == '#' -> backspaceS++
                backspaceS > 0 -> backspaceS--
                else -> charS = S[indexS]
            }
            indexS--
        }

        var charT: Char? = null
        var backspaceT = 0

        while (indexT >= 0 && charT == null) {
            when {
                T[indexT] == '#' -> backspaceT++
                backspaceT > 0 -> backspaceT--
                else -> charT = T[indexT]
            }
            indexT--
        }

        if (charS != charT) {
            return false
        }
    }

    return true
}

fun main() {
    Test.assert(backspaceCompare("ab#c", "ad#c"), true)
    Test.assert(backspaceCompare("ab##", "c#d#"), true)
    Test.assert(backspaceCompare("a##c", "#a#c"), true)
    Test.assert(backspaceCompare("a#c", "b"), false)
}