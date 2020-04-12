package problems

import kotlin.math.max

fun strongPasswordChecker(s: String): Int {

    if (s.isEmpty()) return 6

    val addLen = if (s.length < 6) 6 - s.length else 0
    val removeLen = if (s.length > 20) s.length - 20 else 0
    var upperCase = 0
    var lowerCase = 0
    var digit = 0

    var duplicates = 0
    var temp = 0
    for (i in s.indices) {
        val duplicate = i < s.length - 1 && s[i] == s[i + 1]

        if (duplicate) {
            temp++
        } else if (temp > 0) {
            temp++

            duplicates += if (temp > 2) temp / 3 else 0

            temp = 0
        }

        when {
            s[i] in 'A'..'Z' -> upperCase++
            s[i] in 'a'..'z' -> lowerCase++
            s[i] in '0'..'9' -> digit++
        }
    }


    val add = (if (digit > 0) 0 else 1) + (if (upperCase > 0) 0 else 1) + (if (lowerCase > 0) 0 else 1)
    println("Len ${s.length}, duplicates $duplicates, upper $upperCase, lower $lowerCase, digit $digit -> add $add")

    if (addLen > 0) {
        val duplicatesLeft = max(0,duplicates - addLen)
        val addAbs = max(0, add - duplicatesLeft - addLen)
        val result = addLen + addAbs + duplicatesLeft
        println("RESULT $result for ADD $addLen -> $addAbs, duplicatesLeft $duplicatesLeft")
        return result
    } else {
        val duplicatesLeft = max(0, duplicates - removeLen)
        val addAbs = max(0, add - duplicatesLeft)
        val result = removeLen + duplicatesLeft + addAbs
        println("RESULT $result for REMOVE $removeLen -> add $addAbs, duplicates $duplicatesLeft")
        return result
    }
}

fun main() {
    Test.assert(strongPasswordChecker("..."), 3, "...")
    Test.assert(strongPasswordChecker("aaAA11"), 0, "aaAA11")
    Test.assert(strongPasswordChecker("AAAAA"), 2, "5xA")
    Test.assert(strongPasswordChecker("AAAAAAAAAAAAAAAAAAAA"), 6, "20xA")
    Test.assert(strongPasswordChecker("aaaabbaaabbaaa123456A"), 3, "aaaabbaaabbaaa123456A")
    Test.assert(strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaa"), 7 , "aaaaaaaaaaaaaaaaaaaaa")
    Test.assert(strongPasswordChecker("1234567890123456Baaaaa"), 3, "1234567890123456Baaaaa")
}