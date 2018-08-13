package problems.`1`

import java.util.*

// 1 - Two Sum
class Solution {

    data class Element(val value: Int, val index: Int)

    // Brute Force Approach
    fun twoSum1(nums: IntArray, target: Int): IntArray {

        var value: Int
        val elements = mutableListOf<Element>()

        for (i in nums.indices) {

            value = nums[i]

            elements.forEach { e ->
                if (e.value + value == target) {
                    return intArrayOf(e.index, i)
                }
            }

            elements.add(Element(value, i))
        }

        return intArrayOf()
    }

    // Hash Table Approach
    fun twoSum2(nums: IntArray, target: Int): IntArray {

        val hashTable = mutableMapOf<Int, Int>()

        var diff: Int
        var currentValue: Int

        for (i in nums.indices) {

            currentValue = nums[i]
            diff = target - currentValue

            if (hashTable.containsKey(diff)) {
                return intArrayOf(hashTable[diff]!!, i)
            } else {
                hashTable.put(nums[i], i)
            }
        }

        return intArrayOf()
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        return twoSum2(nums, target)
    }
}

fun main(args: Array<String>) {
    val solution = Solution();
    println("Solucao: ${Arrays.toString(solution.twoSum(intArrayOf(2, 7, 11, 15), 9))}")
}