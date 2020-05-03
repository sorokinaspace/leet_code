package challenge_may_2020

fun canConstruct(ransomNote: String, magazine: String): Boolean {

    val magazineLetters = magazine.toMutableList()

    ransomNote.forEach {
        magazineLetters.indexOf(it).let { index ->
            if (index == -1) {
                return false
            } else {
                magazineLetters.removeAt(index)
            }
        }
    }

    return true
}

fun main() {
    Test.assert(!canConstruct("a", "b"))
    Test.assert(!canConstruct("aa", "ab"))
    Test.assert(canConstruct("aa", "aab"))
}