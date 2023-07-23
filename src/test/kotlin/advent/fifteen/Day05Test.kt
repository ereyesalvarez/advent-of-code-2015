package advent.fifteen


import kotlin.test.*

class Day05Test {
    private val day = "05"
    private val example = "data/day${day}_example.txt"
    private val input = "data/day${day}_input.txt"

    private val service = Day05()

    @Test
    fun example1() {
        val fileContent = getFileAsText(example)
        val response = service.execute01(fileContent)
        assertEquals(2, response)
    }

    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent)
        println(response)
        assertEquals(236, response)
    }
    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent)
        println(response)
        //assertEquals(9958218, response)
    }

    @Test
    fun example2() {
        assertTrue { service.isNiceSecond("qjhvhtzxzqqjkmpb") }
        assertTrue { service.isNiceSecond("xxyxx") }
        assertFalse { service.isNiceSecond("uurcxstgmygtbstg") }
        assertFalse { service.isNiceSecond("ieodomkazucvgmuy") }
    }
}