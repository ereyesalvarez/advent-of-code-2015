package advent.fifteen


import kotlin.test.Test
import kotlin.test.Ignore
import kotlin.test.assertEquals

class Day02Test {
    private val day = "02"
    private val example = "data/day${day}_example.txt"
    private val input = "data/day${day}_input.txt"

    private val service = Day02()

    @Test
    fun example1() {
        val fileContent = getFileAsText(example)
        val response = service.execute01(fileContent.lines().first())
        assertEquals(58, response)
    }

    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent)
        println(response)
        assertEquals(1588178, response)
    }

    @Test
    fun example2() {
        val fileContent = getFileAsText(example)
        val response = service.execute02(fileContent)
        assertEquals(48, response)
    }
    @Test
    fun example2A() {
        val fileContent = getFileAsText(example)
        val response = service.execute02(fileContent.lines().first())
        assertEquals(34, response)
    }
    @Test
    fun example2B() {
        val fileContent = getFileAsText(example)
        val response = service.execute02(fileContent.lines()[1])
        assertEquals(14, response)
    }


    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent)
        assertEquals(3783758, response)
    }


}