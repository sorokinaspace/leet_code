package challenge

fun groupAnagrams(strs: Array<String>): List<List<String>> {

    val map = hashMapOf<List<Char>, MutableCollection<String>>()
    strs.forEach {
        map.getOrPut(it.toList().sorted(), { mutableListOf() }).run {
            add(it)
        }
    }

    return map.values.map { it.toList() }
}

fun main() {

    val result = hashMapOf(
        "eat".toList().sorted() to listOf("eat", "tea", "ate"),
        "tan".toList().sorted() to listOf("nat", "tan"),
        "bat".toList().sorted() to listOf("bat")
    )

    println(result)
    Test.assert(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")).none {
        val value = result[it.first().toList().sorted()]
        value == null || !value.containsAll(it)
    })
}