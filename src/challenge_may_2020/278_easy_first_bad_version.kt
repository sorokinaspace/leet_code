package challenge_may_2020

/* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */

abstract class VersionControl(private val badVersion: Int) {
    fun isBadVersion(version: Int) = version == badVersion
    abstract fun firstBadVersion(n: Int): Int
}

class Solution(badVersion: Int) : VersionControl(badVersion) {

    override fun firstBadVersion(n: Int): Int {

        var start = 1
        var end = n

        var index = end

        while (end - start > 1) {

            val middle = start + (end - start) / 2

            if (isBadVersion(middle)) {
                if (middle < index) {
                    index = middle
                }
                end = middle
            } else {
                start = middle
            }
        }

        if (end - start == 1) {
            if (isBadVersion(start) && index > start) {
                index = start
            } else if (isBadVersion(end) && index > end) {
                index = end
            }
        }

        return index
    }
}

fun main() {
    Test.assert(Solution(4).firstBadVersion(5), 4)
    Test.assert(Solution(1).firstBadVersion(1), 1)
    Test.assert(Solution(1).firstBadVersion(3), 1)
}