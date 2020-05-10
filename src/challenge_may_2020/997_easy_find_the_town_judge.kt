package challenge_may_2020

fun findJudge(N: Int, trust: Array<IntArray>): Int {

    val citizens = mutableMapOf<Int, HashSet<Int>>()
    val judges = mutableMapOf<Int, HashSet<Int>>()

    judges[1] = hashSetOf()

    for (pair in trust) {
        val who = pair[0]
        val whom = pair[1]

        val existingCitizen = citizens[whom]
        if (existingCitizen == null) {
            if (judges.containsKey(whom)) {
                judges[whom]?.add(who)
            } else {
                judges[whom] = hashSetOf(who)
            }
        } else {
            judges.remove(whom)
        }

        if (citizens.containsKey(who)) {
            citizens[who]?.add(whom)
        } else {
            citizens[who] = hashSetOf(whom)
        }
        judges.remove(who)
    }

    val judge = judges.keys.firstOrNull()

    return if (judge == null || judges[judge]?.size ?: 0 < N - 1) -1 else judge
}

fun main() {

    Test.assert(
        findJudge(
            2, arrayOf(
                intArrayOf(1, 2)
            )
        ), 2
    )

    Test.assert(
        findJudge(
            3, arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 3)
            )
        ), 3
    )

    Test.assert(
        findJudge(
            3, arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 3),
                intArrayOf(3, 1)
            )
        ), -1
    )

    Test.assert(
        findJudge(
            3, arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3)
            )
        ), -1
    )

    Test.assert(
        findJudge(
            4, arrayOf(
                intArrayOf(1, 3),
                intArrayOf(1, 4),
                intArrayOf(2, 3),
                intArrayOf(2, 4),
                intArrayOf(4, 3)
            )
        ), 3
    )

    Test.assert(
        findJudge(
            1, arrayOf(
            )
        ), 1
    )
}