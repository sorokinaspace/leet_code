package challenge_may_2020

import java.lang.StringBuilder

fun findComplement(num: Int): Int {
    val str = StringBuilder()
    Integer.toBinaryString(num).forEach {
        if (it == '1') str.append('0') else str.append('1')
    }
    return Integer.parseUnsignedInt(str.toString(), 2)
}

fun main() {
    Test.assert(findComplement(5), 2)
    Test.assert(findComplement(1), 0)
}