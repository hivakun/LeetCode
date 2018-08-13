package linkedlist

internal class LinkedListNode {

    var value: Int = 0
    var next: LinkedListNode? = null
    var prev: LinkedListNode? = null

    constructor(value: Int, next: LinkedListNode? = null, prev: LinkedListNode? = null) {
        this.value = value
        this.next = next
        this.prev = prev
    }
}

class MyLinkedList() {

    /** Initialize your data structure here. */
    private var head: LinkedListNode? = null;

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    fun get(index: Int): Int {
        val node = getNode(index)
        return if (node != null) node.value else -1
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(value: Int) {
        val current = LinkedListNode(value, head, null)
        head?.prev = current
        head = current
    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(value: Int) {

        if (head == null) {
            addAtHead(value)
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.prev = LinkedListNode(value, null, current)
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, value: Int) {

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {

    }

    private fun getNode(index: Int): LinkedListNode? {

        val idx = 0
        var current = head

        while (idx < index && current != null) {
            current = current.next
        }

        return current
    }

}