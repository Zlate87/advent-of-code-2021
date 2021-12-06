package day1

import readInputAsInt

fun main() {
    fun part1(input: List<Int>): Int {
        return input.windowed(2).count {(x, y) -> x < y}
    }

    fun part2(input: List<Int>): Int {
        return input.windowed(4).count {(x, _, _ , y) -> x < y}
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsInt("day1/Input_Test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInputAsInt("day1/Input")
    println(part1(input))
    println(part2(input))
}
