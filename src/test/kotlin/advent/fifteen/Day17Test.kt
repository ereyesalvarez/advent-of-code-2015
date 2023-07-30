package advent.fifteen


import kotlin.test.Test
import kotlin.test.assertEquals

class Day17Test {
    private val day = "17"
    private val example = "data/day${day}_example.txt"
    private val input = "data/day${day}_input.txt"

    private val service = Day17()

    @Test
    fun example1() {
        val fileContent = getFileAsText(example)
        val response = service.execute01(fileContent, 25)
        assertEquals(4, response)
    }
    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent, 150)
        assertEquals(1304, response)
    }
    @Test
    fun example2() {
        val fileContent = getFileAsText(example)
        val response = service.execute02(fileContent, 25)
        assertEquals(3, response)
    }
    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent, 150)
        assertEquals(18, response)
    }
}