package advent.fifteen

import java.util.*

class Day19 {
    private val regexToSplit = "(?=\\p{Upper})".toRegex()
    fun execute01(input: String): Int {
        val (input1, input2) = input.split("\n\n")
        val (map, conversions) = mapLines(input1)
        val start = mapStartLine(input2, map)
        val per = generatePermutations(start, conversions)
        return per.size
    }

    fun execute02(input: String): Int {
        val (input1, input2) = input.split("\n\n")
        val (map, conversions) = mapLines(input1)
        val target = mapStartLine(input2, map)
        return exploreInvert(target, listOf(map["e"]!!), conversions.map { Pair(it.second, it.first) }.sortedByDescending { it.first.size })
    }

    private fun exploreSecuencial(start: List<Int>, target: List<Int>, conversions: List<Pair<Int, List<Int>>>): Int{
        var permutations = setOf(start)
        var steps = 0
        do {
            permutations = permutations.flatMap { generatePermutations(it, conversions) }.toSet()
            println("size: ${permutations.size} $steps ${permutations.first().size}")
            steps++
        } while (!permutations.contains(target)  )
        return steps
    }

    private fun exploreInvert(start: List<Int>, target: List<Int>, conversions: List<Pair<List<Int>, Int>>): Int{
        if (start.size <= target.size){
            throw Exception("Target is bigger")
        }
        var permutation =start
        var step = 0
        do {
            for (convert in conversions) {
                val index = Collections.indexOfSubList(permutation, convert.first)
                if (index>= 0) {
                    step++
                    permutation = replaceIntList(permutation, convert.first.size, convert.second, index)
                    break
                }
            }
        } while (permutation != target)
        return step
    }

    private fun replaceIntList(input: List<Int>, sizeToReplace: Int, replacement: Int,index: Int ): List<Int>{
        val a = input.subList(0, index)
        val b = input.subList(index + sizeToReplace, input.size)
        return a + replacement + b
    }

    private fun generatePermutations(startLine: List<Int>, conversions: List<Pair<Int, List<Int>>>): MutableSet<List<Int>> {
        val permutations = mutableSetOf<List<Int>>()
        for (index in startLine.indices) {
            val candidate = startLine[index]
            val target = conversions.filter { it.first == candidate }
            target.forEach {
                val end = startLine.subList(0, index) + it.second + startLine.subList(
                    index + 1, startLine.size
                )
                permutations.add(end)
            }
        }
        return permutations
    }

    private fun mapStartLine(input: String, map: Map<String, Int>): List<Int> {
        return input.split(regexToSplit).filter { it.isNotBlank() }.mapNotNull { map[it] }
    }

    private fun mapLines(input: String): Pair<Map<String, Int>, List<Pair<Int, List<Int>>>> {
        var count = 0
        val map = mutableMapOf<String, Int>()
        val x = input.lines().filter { it.isNotBlank() }.map { line ->
            val (a, b) = line.split(" => ")
            val idA = map.getOrPut(a) { count++ }
            val n = b.split(regexToSplit).filter { it.isNotBlank() }.map { map.getOrPut(it) { count++ } }
            Pair(idA, n)
        }
        return Pair(map, x)
    }}