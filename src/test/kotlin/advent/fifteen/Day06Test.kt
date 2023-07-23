package advent.fifteen


import kotlin.test.*

class Day06Test {
    private val day = "06"
    private val input = "data/day${day}_input.txt"

    private val service = Day06()

    @Test
    fun example1() {
        val response = service.execute01("turn on 0,0 through 999,999")
        assertEquals(1000000, response)
    }

    @Test
    fun example2() {
        val response = service.execute01("toggle 0,0 through 999,0")
        assertEquals(1000, response)
    }
    @Test
    fun example3() {
        val response = service.execute01("turn on 499,499 through 500,500")
        assertEquals(4, response)
    }

    @Test
    fun example4() {
        val response = service.execute01("""
            turn on 0,0 through 999,999
            toggle 0,0 through 999,0
            turn off 499,499 through 500,500
            """)
        assertEquals(998996, response)
    }

    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent)
        println(response)
        assertEquals(569999, response)
    }
    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent)
        println(response)
    }

    @Test
    fun regexGroup(){
        val regex= """(\d*,\d*)""".toRegex()
        val x = regex.findAll("turn off 499,499 through 500,500")
        val z = x.toList()
        println(z)
    }
}