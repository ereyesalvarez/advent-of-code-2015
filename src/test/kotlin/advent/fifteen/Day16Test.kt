package advent.fifteen


import kotlin.test.Test
import kotlin.test.assertEquals

class Day16Test {
    private val day = "16"
    private val input = "data/day${day}_input.txt"

    private val service = Day16()

    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent)
        println(response)
        assertEquals(213, response)
    }


    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent)
        println(response)
        assertEquals(323, response)
    }

    @Test
    fun mapAunts(){
        val line = "Sue 1: children: 1, cars: 8, vizslas: 7"
        val result = service.mapAunts(line)
        assertEquals(1, result.id)
        assertEquals(1, result.children)
        assertEquals(8, result.cars)
        assertEquals(7, result.vizslas)
    }
}