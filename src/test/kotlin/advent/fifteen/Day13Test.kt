package advent.fifteen


import kotlin.test.Test
import kotlin.test.assertEquals

class Day13Test {
    private val day = "13"
    private val example = "data/day${day}_example.txt"
    private val input = "data/day${day}_input.txt"

    private val service = Day13()

    @Test
    fun examples1() {
        val fileContent = getFileAsText(example)
        val response = service.execute01(fileContent)
        assertEquals(330, response)
    }

    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent)
        assertEquals(709, response)
    }

    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent)
        println(response)
        //assertEquals("492982", response)
    }

    @Test
    fun generateExtraEffects(){
        val combinations = service.generateExtraEffects(7)
        println(combinations)
    }
    @Test
    fun generateCombination(){
        val combinations = service.generateCombinations(7)
        assertEquals(5040, combinations.size)
    }

    @Test
    fun testDestructure(){
        val input = "Alice would gain 54 happiness units by sitting next to Bob."
        val regex = """(\w+) would (\w+) (\d+) happiness units by sitting next to (\w+)""".toRegex()
        val match = regex.find(input)!!
        val (name, change , effect: String, withName) = match.destructured
        assertEquals("Alice", name)
        assertEquals("gain", change)
        assertEquals("54", effect)
        assertEquals("Bob", withName)
    }
}