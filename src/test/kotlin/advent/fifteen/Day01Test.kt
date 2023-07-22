package advent.fifteen


import kotlin.test.Test
import kotlin.test.Ignore
import kotlin.test.assertEquals

class Day01Test {
    private val day = "01"
    private val example = "data/day${day}_example.txt"
    private val input = "data/day${day}_input.txt"

    private val service = Day01()

    @Test
    fun example1() {
        val fileContent = getFileAsText(example)
        val response = service.execute01(fileContent)
        assertEquals(-3, response)
    }

    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent)
        println(response)
        assertEquals(138, response)
    }

    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent)
        assertEquals(208180, response)
    }


}