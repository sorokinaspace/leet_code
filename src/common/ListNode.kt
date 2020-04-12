package common

class ListNode(val `val`: Int) {

    var next: ListNode? = null

    fun hasNext() = next != null

    override fun toString(): String {
        return "$`val` ${if (hasNext()) " -> $next" else ""}"
    }

    companion object {

        fun fromList(list: Collection<Int>): ListNode? {
            if (list.isNullOrEmpty()) {
                return null
            }
            val first = ListNode(list.first())
            var last = first

            list.forEachIndexed { index, item ->
                if (index > 0) {
                    val newNode = ListNode(item)
                    last.next = newNode
                    last = newNode
                }
            }

            return first
        }
    }
}
