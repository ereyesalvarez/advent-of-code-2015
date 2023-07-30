package advent.fifteen


import org.junit.jupiter.api.Assertions.assertNotEquals
import kotlin.test.Test
import kotlin.test.assertEquals

class Day07Test {
    private val day = "07"
    private val example = "data/day${day}_example.txt"
    private val input = "data/day${day}_input.txt"
    private val input2 = "data/day${day}_input2.txt"

    private val service = Day07()

    @Test
    fun example1() {
        val fileContent = getFileAsText(example)
        var response = service.solveDay1B(fileContent, "i")
        assertEquals(65079, response)
        response = service.solveDay1B(fileContent, "h")
        assertEquals(65412, response)
    }

    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent)
        println(response)
        assertEquals(16076, response)
    }

    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input2)
        val response = service.execute01(fileContent)
        println(response)
        assertNotEquals(1377, response)
    }

    @Test
    fun checkBinaryOps() {
        val x = 123
        val y = 456
        val z = x + y
        println(z)
    }

    @Test
    fun checkLShift() {
        val x = "123"
        val expected = 492u
        val result = x.toUShort().toUInt() shl 2
        assertEquals(expected, result)
    }

    @Test
    fun checkShiftZero() {
        println(Integer.toBinaryString(456))
        println(Integer.toBinaryString(114))
        println(Integer.parseInt("11100100000", 2))
        println(Integer.parseInt("1110010000000", 2))
        var result = service.leftShift(2, 1)
        assertEquals(4, result)
        result = service.leftShift(2, 2)
        assertEquals(8, result)
        result = service.leftShift(123, 2)
        assertEquals(492, result)
        result = service.rightShift(456, 2)
        assertEquals(114, result)
        result = service.rightShift(1, 1)
        assertEquals(0, result)
    }

}