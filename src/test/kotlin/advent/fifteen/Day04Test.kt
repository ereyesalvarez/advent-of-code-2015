package advent.fifteen


import kotlin.test.Test
import kotlin.test.assertEquals

class Day04Test {
    private val day = "04"
    private val example = "data/day${day}_example.txt"
    private val input = "data/day${day}_input.txt"

    private val service = Day04()

    @Test
    fun example1A() {
        val fileContent = getFileAsText(example)
        val response = service.execute01(fileContent.lines()[0])
        assertEquals(609043, response)
    }
    @Test
    fun example1B() {
        val fileContent = getFileAsText(example)
        val response = service.execute01(fileContent.lines()[1])
        assertEquals(1048970, response)
    }

    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent)
        println(response)
        assertEquals(346386, response)
    }

    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent)
        println(response)
        assertEquals(9958218, response)
    }
}