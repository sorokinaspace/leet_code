package challenge

fun checkValidString(s: String): Boolean {

    val str = StringBuilder()

    s.forEach {
        if (it == '*') str.append(it)
        else if ('(' == it) str.append(it)
        else if (')' == it) {
            str.lastIndexOf('(').run {
                if (this >= 0) {
                    str.deleteCharAt(this)
                } else {
                    str.lastIndexOf('*').run {
                        if (this >= 0) {
                            str.deleteCharAt(this)
                        } else {
                            return false
                        }
                    }
                }
            }
        }
    }

    var star = 0
    var open = 0

    str.forEach {
        when (it) {
            '(' -> open++
            '*' -> if (open > star) star++
        }
    }
    return open <= star
}

fun main() {
    Test.assert(checkValidString("()"))
    Test.assert(checkValidString("(*)"))
    Test.assert(checkValidString("(*))"))
    Test.assert(!checkValidString("(   (*)  (*  ))  (  (*"))
    Test.assert(!checkValidString("(())(())(((()*()()()))()((()()(*()())))(((*)()"))
}