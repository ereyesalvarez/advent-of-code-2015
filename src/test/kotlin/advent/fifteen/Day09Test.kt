package advent.fifteen


import kotlin.test.Test
import kotlin.test.assertEquals

class Day09Test {
    private val day = "09"
    private val example = "data/day${day}_example.txt"
    private val input = "data/day${day}_input.txt"

    private val service = Day09()

    @Test
    fun example1() {
        val fileContent = getFileAsText(example)
        val response = service.execute01(fileContent)
        assertEquals(605, response)
    }
    @Test
    fun example2() {
        val fileContent = getFileAsText(example)
        val response = service.execute02(fileContent)
        assertEquals(982, response)
    }

    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent)
        println(response)
        assertEquals(251, response)
    }

    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent)
        println(response)
        assertEquals(898, response)
    }
}