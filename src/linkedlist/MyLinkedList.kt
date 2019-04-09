package linkedlist

internal class LinkedListNode(var value: Int, var next: LinkedListNode? = null, var prev: LinkedListNode? = null) {

    fun hasNext(): Boolean {
        return next != null
    }

    fun hasPrev(): Boolean {
        return prev != null
    }

}

class MyLinkedList() {

    /** Initialize your data structure here. */
    private var length = 0
    private var head: LinkedListNode? = null

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
        length++
    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(value: Int) {

        if (head == null) {
            addAtHead(value)
        } else {
            val tail = getNode(length - 1)
            tail?.next = LinkedListNode(value, null, tail)
            length++
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, value: Int) {

        if (index == 0) {
            addAtHead(value)
        } else if (index == length) {
            addAtTail(value)
        } else if (index < length) {

            val next = getNode(index)
            val prev = next?.prev

            val newNode = LinkedListNode(value, next, prev)
            next?.prev = newNode
            prev?.next = newNode

            length++
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {

        if (length > 0) {
            if (index == 0) {
                head = head?.next
                length--
            } else {
                val node = getNode(index)

                if (node != null) {
                    node.prev?.next = node.next
                    node.next?.prev = node.prev
                    length--
                }
            }
        }
    }

    fun getLength(): Int {
        return length
    }

    fun print() {

        print("[ ")

        if (head != null) {

            print(head?.value)

            var current = head?.next

            while (current != null) {
                print(", ${current.value}")
                current = current?.next
            }
        }

        println(" ]")
    }


    private fun getNode(index: Int): LinkedListNode? {

        var currentIndex = 0
        var currentNode = head

        while (currentIndex < index && currentNode != null) {
            currentNode = currentNode.next
            currentIndex++
        }

        return if (currentIndex == index) currentNode else null
    }
}

fun main(args : Array<String>) {

    val list = MyLinkedList()
    list.addAtHead(2)
    list.addAtHead(1)
    list.addAtTail(3)
    list.print()

    println("First: ${list.get(0)}")
    println("Second: ${list.get(1)}")
    println("Third: ${list.get(2)}")
    println("Invalid: ${list.get(-1)}")
    println("Invalid: ${list.get(3)}")

    list.addAtIndex(0, 0)
    list.addAtIndex(4, 4)
    list.addAtIndex(2, 6)
    list.print()
}