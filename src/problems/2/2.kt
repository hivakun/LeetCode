package problems.`2`

//2. Add Two Numbers

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        var result = sumValues(0, l1?.`val` ?: 0, l2?.`val` ?: 0)
        var resultHead = ListNode(result.second)

        var currentList1 = l1?.next;
        var currentList2 = l2?.next;
        var currentResult = resultHead;

        while (currentList1 != null || currentList2 != null) {
            result = sumValues(result.first, currentList1?.`val` ?: 0, currentList2?.`val` ?: 0)
            currentResult.next = ListNode(result.second)
            currentResult = currentResult.next!!
            currentList1 = currentList1?.next
            currentList2 = currentList2?.next
        }

        if (result.first > 0) {
            currentResult.next = ListNode(result.first)
        }

        return resultHead
    }

    private fun sumValues(currentValue: Int, value1: Int, value2: Int): Pair<Int, Int> {

        val sum = currentValue + value1 + value2;

        if (sum >= 10) {
            return Pair<Int, Int>(sum / 10, sum % 10)
        } else {
            return Pair(0, sum);
        }
    }

    fun createList(head: Int, vararg values: Int): ListNode {

        val headNode = ListNode(head);
        var current = headNode

        values.forEach { value ->
            current.next = ListNode(value)
            current = current.next!!
        }

        return headNode
    }

    fun printList(list: ListNode) {

        val values = mutableListOf<Int>()
        var current: ListNode? = list

        while (current != null) {
            values.add(current.`val`)
            current = current.next
        }

        print("( ${values.joinToString(" -> ")} )")
    }
}

fun main(args: Array<String>) {

    val solution = Solution()
    val l1 = solution.createList(5)
    val l2 = solution.createList(5)

    print("Input: ")
    solution.printList(l1)
    print(" + ")
    solution.printList(l2)

    val result = solution.addTwoNumbers(l1, l2)

    print("\nOutput: ")
    solution.printList(result!!)
}