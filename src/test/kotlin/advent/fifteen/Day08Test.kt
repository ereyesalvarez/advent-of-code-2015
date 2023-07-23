package advent.fifteen


import kotlin.test.Test
import kotlin.test.assertEquals

class Day08Test {
    private val day = "08"
    private val example = "data/day${day}_example.txt"
    private val input = "data/day${day}_input.txt"

    private val service = Day08()

    @Test
    fun example1() {
        val result = service.execute01(
            """
                ""
                "abc"
                "aaa\"aaa"
                "\x27"
            """.trimIndent())
        assertEquals(12, result)
    }
    @Test
    fun example2() {
        val result = service.execute02(
            """
                ""
                "abc"
                "aaa\"aaa"
                "\x27"
            """.trimIndent())
        assertEquals(19, result)
    }

    @Test
    fun solveLine() {
        var result = service.countChars(""""\""""".trimIndent())
        assertEquals(1, result)
        result = service.countChars(""""\\"""".trimIndent())
        assertEquals(1, result)
        result = service.countChars(""""aaa\"aaa"""".trimIndent())
        assertEquals(7, result)
        result = service.countChars(""""\x27"""".trimIndent())
        assertEquals(1, result)
    }
    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent)
        println(response)
        assertEquals(1371, response)
    }

    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent)
        println(response)
        assertEquals(1371, response)
    }

    @Test
    fun evaluate() {
        assertEquals("\"\\\"\\\"\"", service.encode("\"\""))
        assertEquals("\"\\\"abc\\\"\"", service.encode("\"abc\""))
        assertEquals("""
            "\"aaa\\\"aaa\""
        """.trimIndent(), service.encode("\"aaa\\\"aaa\"" ))

        val result = """
                ""
                "abc"
                "aaa\"aaa"
                "\x27"
            """.trimIndent()
        result.lines().forEach {
            val x = service.encode(it)
            println(it)
            println(x)
            println("-----")
        }
    }

}