package advent.fifteen


import kotlin.test.Test
import kotlin.test.assertEquals

class Day14Test {
    private val day = "14"
    private val example = "data/day${day}_example.txt"
    private val input = "data/day${day}_input.txt"

    private val service = Day14()

    @Test
    fun examples1() {
        val fileContent = getFileAsText(example)
        val response = service.execute01(fileContent, 1000)
        assertEquals(1120, response)
    }

    @Test
    fun examples2() {
        val fileContent = getFileAsText(example)
        val response = service.execute02(fileContent, 1000)
        assertEquals(689, response)
    }

    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent, 2503)
        println(response)
        assertEquals(2660, response)
    }
    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent, 2503)
        println(response)
        assertEquals(1256, response)
    }


    @Test
    fun calculateDistance(){
        val speed = Day14.ReindeerSpeed("Commet", 14, 10, 127)
        val response = service.calculateDistance(speed, 1000)
        assertEquals(1120, response)
    }

    @Test
    fun parseLine(){
        val input = "Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds."
        val regex = """(\w+) can .* (\d+) km/s .* (\d+) seconds, .* (\d+)""".toRegex()
        val (name, speed, seconds, restSeconds) = regex.find(input)!!.destructured
        assertEquals("Comet", name)
        assertEquals("14", speed)
        assertEquals("10", seconds)
        assertEquals("127", restSeconds)
    }
}