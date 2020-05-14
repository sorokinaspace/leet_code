package challenge_may_2020

class Trie() {

    data class Node(var char: Char? = null, var isWordEnd: Boolean = false) {
        private val children = mutableSetOf<Node>()

        fun add(char: Char): Node {
            return search(char) ?: Node(char).apply {
                this@Node.children.add(this)
            }
        }

        fun search(char: Char): Node? = children.find { it.char == char }
    }

    /** Initialize your data structure here. */
    private val root = Node()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var node = root
        word.forEach { node = node.add(it) }
        node.isWordEnd = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var node: Node? = root

        word.forEach {
            if (node == null) {
                return false
            }
            node = node?.search(it)
        }

        return node?.isWordEnd ?: false
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var node: Node? = root

        prefix.forEach {
            if (node == null) {
                return false
            }
            node = node?.search(it)
        }

        return node != null
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
fun main() {
    val trie = Trie()

    trie.insert("apple")
    Test.assert(trie.search("apple")) // returns true

    Test.assert(!trie.search("app")) // returns false

    Test.assert(trie.startsWith("app")) // returns true

    trie.insert("app")
    Test.assert(trie.search("app")) // returns true

}