package advent.fifteen


import kotlin.test.Test
import kotlin.test.assertEquals

class Day01Test {
    private val day = "01"
    private val input = "data/day${day}_input.txt"

    private val service = Day01()

    @Test
    fun example1() {
        var response = service.execute01("""(())""")
        assertEquals(0, response)
        response = service.execute01("""()()""")
        assertEquals(0, response)
        response = service.execute01("""(((""")
        assertEquals(3, response)
        response = service.execute01("""(()(()(""")
        assertEquals(3, response)
    }

    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent)
        println(response)
        assertEquals(138, response)
    }

    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent)
        assertEquals(1771, response)
    }


}