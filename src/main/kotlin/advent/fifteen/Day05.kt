package advent.fifteen

import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8

class Day05 {
    fun execute01(input: String): Int {
        return solveDay1(input)
    }

    fun execute02(input: String): Int {
        return solveDay2(input)
    }

    private fun solveDay1(input: String): Int {
        return input.lines().filter { isNiceFirst(it) }.size
    }


    /*
    It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
    It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
    It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.
     */
    private fun isNiceFirst(input: String): Boolean {
        if (input.contains("ab") or input.contains("cd") or input.contains("pq") or input.contains("xy")) {
            return false
        }
        val vocals = listOf('a', 'e', 'i', 'o', 'u')

        var vocalsSum = 0
        for (c in input) {
            if (vocals.contains(c)) {
                vocalsSum++
            }
        }
        if (vocalsSum < 3) {
            return false
        }
        var last: Char? = null

        for (c in input) {
            if (c == last) {
                return true
            }
            last = c
        }
        return false
    }

    private fun solveDay2(input: String): Int {
        return input.lines().filter { isNiceSecond(it) }.size
    }

    fun isNiceSecond(input: String): Boolean {
        val size = input.length
        var conditionA = false
        for (i in 0..<size - 2) {
            if (input[i] == input[i + 2] && input[i] != input[i + 1]) {
                conditionA = true
            }
        }
        if (!conditionA) {
            return false
        }

        for (i in 0..<size - 1) {
            val pair = "${input[i]}${input[i + 1]}"
            if (input.split(pair).size > 2) {
                return true
            }
        }
        return false
    }
}