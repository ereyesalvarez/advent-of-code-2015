package advent.fifteen


import kotlin.test.Test
import kotlin.test.assertEquals

class Day10Test {
    private val service = Day10()

    @Test
    fun example1() {
        var response = service.solve1("1")
        assertEquals("11", response)
        response = service.solve1("11")
        assertEquals("21", response)
        response = service.solve1("21")
        assertEquals("1211", response)
        response = service.solve1("1211")
        assertEquals("111221", response)
    }

    @Test
    fun exercise1() {
        val response = service.execute01("1321131112", 40)
        println(response)
        assertEquals(492982, response)
    }

    @Test
    fun exercise2() {
        val response = service.execute02("1321131112", 50)
        println(response)
        assertEquals(6989950, response)
    }
}