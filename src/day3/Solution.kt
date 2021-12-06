package day3

import readInput

fun main() {

    fun filterMostCommon(input: List<String>, position: Int): List<String> {
        var sum = 0;
        input.forEach {
            sum += it[position].digitToInt()
        }

        val mostCommon = if (sum >= input.size / 2.0) 1 else 0
        return input.filter { it[position].digitToInt() == mostCommon }
    }

    fun filterListCommon(input: List<String>, position: Int): List<String> {
        var sum = 0;
        input.forEach {
            sum += it[position].digitToInt()
        }

        val listCommon = if (sum >= input.size / 2.0) 0 else 1
        return input.filter { it[position].digitToInt() == listCommon }
    }

    fun part1(input: List<String>): Int {
        val numberOfLines = input.size
        val lineLength = input[0].length
        val columnSums = Array(lineLength) { 0 }

        input.forEach {
            for (i in 0 until lineLength) {
                columnSums[i] += it[i].digitToInt()
            }
        }
        val gammaCharArray = columnSums.map {
            if (it > numberOfLines / 2) 1 else 0
        }

        val gammaString = gammaCharArray.toString().removeSurrounding("[", "]").replace(", ", "")
        val epsilonString = gammaString.replace("1", "2").replace("0", "1").replace("2", "0")
        return Integer.parseInt(gammaString, 2) * Integer.parseInt(epsilonString, 2)
    }

    fun part2(input: List<String>): Int {
        var filteredForMostCommon = input
        for (i in 0 until input[0].length) {
            filteredForMostCommon = filterMostCommon(filteredForMostCommon, i)
            if (filteredForMostCommon.size == 1) {
                break;
            }
        }

        var filteredForListCommon = input
        for (i in 0 until input[0].length) {
            filteredForListCommon = filterListCommon(filteredForListCommon, i)
            if (filteredForListCommon.size == 1) {
                break;
            }
        }

        val oxygen = filteredForMostCommon[0]
        val co2 = filteredForListCommon[0]

        return Integer.parseInt(oxygen, 2) * Integer.parseInt(co2, 2)
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day3/Input_Test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("day3/Input")
    println(part1(input))
    println(part2(input))
}

