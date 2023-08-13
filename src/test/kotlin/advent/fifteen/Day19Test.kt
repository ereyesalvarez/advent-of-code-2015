package advent.fifteen


import kotlin.test.Test
import kotlin.test.assertEquals

class Day19Test {
    private val day = "19"
    private val example = "data/day${day}_example.txt"
    private val input = "data/day${day}_input.txt"

    private val service = Day19()

    @Test
    fun example1() {
        val fileContent = getFileAsText(example)
        val response = service.execute01(fileContent)
        assertEquals(4, response)
    }
    @Test
    fun example2() {
        val fileContent = getFileAsText(example)
        val response = service.execute02(fileContent)
        assertEquals(3, response)
    }

    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent)
        assertEquals(518, response)
    }
    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent)
        assertEquals(200, response)
    }
    @Test
    fun split(){
        val x = "CamelValue".split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])".toRegex())
            .dropLastWhile { it.isEmpty() }
        println(x)
    }
}