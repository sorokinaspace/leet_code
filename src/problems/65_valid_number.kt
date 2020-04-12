package problems

fun isNumber(s: String): Boolean {

    val states = listOf(
        emptyMap(),
        mapOf("blank" to 1, "sign" to 2, "digit" to 3, "." to 4),
        mapOf("digit" to 3, "." to 4),
        mapOf("digit" to 3, "." to 5, "e" to 6, "blank" to 9),
        mapOf("digit" to 5),
        mapOf("digit" to 5, "e" to 6, "blank" to 9),
        mapOf("sign" to 7, "digit" to 8),
        mapOf("digit" to 8),
        mapOf("digit" to 8, "blank" to 9),
        mapOf("blank" to 9)
    )

    var currentState = 1

    s.forEach { c ->
        val case = when {
            '+' == c || '-' == c -> "sign"
            "0123456789".contains(c) -> "digit"
            '.' == c -> "."
            'e' == c -> "e"
            ' ' == c -> "blank"
            else -> null
        }

        currentState = states[currentState][case] ?: return false
    }

    return currentState in listOf(3, 5, 8, 9)
}

fun main() {
//    Some examples:
//    "0" => true
//    " 0.1 " => true
//    "abc" => false
//    "1 a" => false
//    "2e10" => true
//    " -90e3   " => true
//    " 1e" => false
//    "e3" => false
//    " 6e-1" => true
//    " 99e2.5 " => false
//    "53.5e93" => true
//    " --6 " => false
//    "-+3" => false
//    "95a54e53" => false

    Test.assert(isNumber(""), false, "")
    Test.assert(isNumber("."), false, ".")
    Test.assert(isNumber("0"), true, "0")
    Test.assert(isNumber(" 0.1 "), true, " 0.1 ")
    Test.assert(isNumber("abc"), false, "abc")
    Test.assert(isNumber("1 a"), false, "1 a")
    Test.assert(isNumber("2e10"), true, "2e10")
    Test.assert(isNumber(" -90e3   "), true, " -90e3   ")
    Test.assert(isNumber(" 1e"), false, " 1e")
    Test.assert(isNumber("e3"), false, "e3")
    Test.assert(isNumber(" 6e-1"), true, " 6e-1")
    Test.assert(isNumber(" 99e2.5 "), false, " 99e2.5 ")
    Test.assert(isNumber("53.5e93"), true, "53.5e93")
    Test.assert(isNumber(" --6 "), false, " --6 ")
    Test.assert(isNumber("-+3"), false, "-+3")
    Test.assert(isNumber("95a54e53"), false, "95a54e53")
}