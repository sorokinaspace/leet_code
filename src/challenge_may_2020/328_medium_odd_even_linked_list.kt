package challenge_may_2020

import common.ListNode

fun oddEvenList(head: ListNode?): ListNode? {
    if (head == null) return null

    var odd: ListNode = head
    var even = head.next
    val evenHead = even

    while (even?.next != null) {
        odd.next = even.next
        odd = odd.next!!
        even.next = odd.next
        even = even.next
    }

    odd.next = evenHead

    return head
}