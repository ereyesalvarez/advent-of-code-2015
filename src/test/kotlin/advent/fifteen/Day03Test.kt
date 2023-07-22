package advent.fifteen


import kotlin.test.Test
import kotlin.test.Ignore
import kotlin.test.assertEquals

class Day03Test {
    private val day = "03"
    private val example = "data/day${day}_example.txt"
    private val input = "data/day${day}_input.txt"

    private val service = Day03()

    @Test
    fun example1A() {
        val fileContent = getFileAsText(example)
        val response = service.execute01(fileContent.lines().first())
        assertEquals(2, response)
    }
    @Test
    fun example1B() {
        val fileContent = getFileAsText(example)
        val response = service.execute01(fileContent.lines()[1])
        assertEquals(4, response)
    }
    @Test
    fun example1C() {
        val fileContent = getFileAsText(example)
        val response = service.execute01(fileContent.lines()[2])
        assertEquals(2, response)
    }

    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent)
        println(response)
        assertEquals(2592, response)
    }
    @Test
    fun example2A() {
        val fileContent = getFileAsText(example)
        val response = service.execute02(fileContent.lines()[3])
        assertEquals(3, response)
    }
    @Test
    fun example2B() {
        val fileContent = getFileAsText(example)
        val response = service.execute02(fileContent.lines()[4])
        assertEquals(3, response)
    }
    @Test
    fun example2C() {
        val fileContent = getFileAsText(example)
        val response = service.execute02(fileContent.lines()[2])
        assertEquals(11, response)
    }

    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent)
        println(response)
        assertEquals(2360, response)
    }
}