package advent.fifteen


import kotlin.test.Test
import kotlin.test.assertEquals

class Day15Test {
    private val day = "15"
    private val example = "data/day${day}_example.txt"
    private val input = "data/day${day}_input.txt"

    private val service = Day15()

    @Test
    fun examples1() {
        val fileContent = getFileAsText(example)
        val response = service.execute01(fileContent)
        assertEquals(62842880, response)
    }

    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent)
        println(response)
        assertEquals(222870, response)
    }

    @Test
    fun examples2() {
        val fileContent = getFileAsText(example)
        val response = service.execute02(fileContent)
        assertEquals(57600000, response)
    }

    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent)
        println(response)
        assertEquals(117936, response)
    }


    @Test
    fun regexTest(){
        val input = "Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8"
        val regex = service.regex
        val (name, capacity, durability, flavor, texture, calories) = regex.find(input)!!.destructured
        assertEquals("Butterscotch", name)
        assertEquals(-1, capacity.toInt())
        assertEquals(-2, durability.toInt())
        assertEquals(6, flavor.toInt())
        assertEquals(3, texture.toInt())
        assertEquals(8, calories.toInt())

    }
}