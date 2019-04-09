package array

class Solution {

    fun pivotIndex(nums: IntArray): Int {

        var leftSide = 0
        var rightSide = nums.sum()

        for (index in nums.indices) {

            if (index > 0) {
                leftSide += nums[index - 1]
            }

            rightSide -= nums[index]

            if (leftSide == rightSide) {
                return index
            }
        }

        return -1
    }

    fun dominantIndex(nums: IntArray): Int {

        var maxIndex = -1
        var maxNumber = Int.MIN_VALUE
        var prevNumber = Int.MIN_VALUE

        for (index in nums.indices) {

            if (nums[index] > maxNumber) {
                prevNumber = maxNumber
                maxNumber = nums[index]
                maxIndex = index
            } else if (nums[index] > prevNumber) {
                prevNumber = nums[index]
            }
        }

        if (maxNumber >= prevNumber * 2) {
            return maxIndex
        } else {
            return -1
        }
    }

    fun plusOne(digits: IntArray): IntArray {

        var sum: Int = 1;
        val result = mutableListOf<Int>()

        for (index in digits.indices.reversed()) {
            sum += digits[index]
            result.add(sum % 10)
            sum /= 10
        }

        if (sum > 0) {
            result.add(sum)
        }

        result.reverse()
        return result.toIntArray()
    }

    fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {

        val lineSize = matrix.size - 1
        val columnSize = if (lineSize >= 0) matrix[0].size - 1 else -1
        val result = mutableListOf<Int>()

        var line = 0
        var column = 0

        var startAtColumn = false

        var hasNext = (lineSize >= 0 && columnSize >= 0)

        while (hasNext) {

            result.add(matrix[line][column])

            if (line == lineSize && column == columnSize) {
                hasNext = false;
            } else {
                if (startAtColumn) {
                    if (line < lineSize) {
                        line++
                        if (column > 0) column-- else startAtColumn = false
                    } else {
                        column++
                        startAtColumn = false
                    }
                } else {
                    if (column < columnSize) {
                        column++
                        if (line > 0) line-- else startAtColumn = true
                    } else {
                        line++
                        startAtColumn = true
                    }
                }
            }
        }

        return result.toIntArray()
    }
}

fun main(args: Array<String>) {

    val solution = Solution()

//    val p0 = intArrayOf(1, 2, 3)
//    val p1 = intArrayOf(1, 7, 3, 6, 5, 6)
//
//    println("T0 pivot: ${solution.pivotIndex(p0)}")
//    println("T1 pivot: ${solution.pivotIndex(p1)}")
//
//    val d0 = intArrayOf(3, 6, 1, 0)
//    val d1 = intArrayOf(1, 2, 3, 4)
//
//    val d2 = intArrayOf(1)
//    val d3 = intArrayOf(0, 0, 0, 1)
//    val d4 = intArrayOf(0, 0, 3, 2)
//
//    println("D0 dominantIndex: ${solution.dominantIndex(d0)}")
//    println("D1 dominantIndex: ${solution.dominantIndex(d1)}")
//    println("D2 dominantIndex: ${solution.dominantIndex(d2)}")
//    println("D3 dominantIndex: ${solution.dominantIndex(d3)}")
//    println("D4 dominantIndex: ${solution.dominantIndex(d4)}")
//
//    val b0 = intArrayOf(1, 2, 3)
//    val b1 = intArrayOf(9, 9, 9)
//    val b2 = intArrayOf(4, 3, 2, 1)
//
//    println("B0 plus one: [${solution.plusOne(b0).joinToString()}]")
//    println("B1 plus one: [${solution.plusOne(b1).joinToString()}]")
//    println("B2 plus one: [${solution.plusOne(b2).joinToString()}]")

    val l1 = intArrayOf(1, 2, 6)
    val l2 = intArrayOf(3, 5, 7)
    val l3 = intArrayOf(4, 8, 9)
    val matrix = arrayOf(l1, l2, l3)

    println("Diagonal: [${solution.findDiagonalOrder(matrix).joinToString()}]")
}