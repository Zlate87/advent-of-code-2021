package day2

import readInput

fun main() {

    fun getInstructions(input: List<String>): List<Instruction> {
        return input.map {
            it.split(" ")
        }.map {
            Instruction(it[0], it[1].toInt())
        }
    }

    fun part1(input: List<String>): Int {
        var horisontal = 0
        var depth = 0

        val instructions = getInstructions(input)

        for (instruction in instructions) {
            when (instruction.direction) {
                "forward" -> horisontal += instruction.amount
                "down" -> depth += instruction.amount
                "up" -> depth -= instruction.amount
            }
        }

        return horisontal * depth
    }

    fun part2(input: List<String>): Int {
        var aim = 0
        var horisontal = 0
        var depth = 0

        val instructions = getInstructions(input)

        for (instruction in instructions) {
            when (instruction.direction) {
                "down" -> aim += instruction.amount
                "up" -> aim -= instruction.amount
                "forward" -> {
                    horisontal += instruction.amount
                    depth += instruction.amount * aim
                }
            }
        }

        return horisontal * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day2/Input_Test")
//    println(part1(testInput))
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("day2/Input")
    println(part1(input))
    println(part2(input))
}

data class Instruction(val direction: String, val amount: Int)
