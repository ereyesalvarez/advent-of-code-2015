package advent.fifteen


import kotlin.test.Test
import kotlin.test.assertEquals

class Day11Test {
    private val service = Day11()

    @Test
    fun example1() {
        var response = service.execute01("abcdefgh")
        assertEquals("abcdffaa", response)
        response = service.execute01("ghijklmn")
        assertEquals("ghjaabcc", response)
    }
    @Test
    fun validateExamples(){
        var r = service.validate(service.stringToListInt("hijklmmn"))
        if (r != 2) throw Exception("error 2: $r")
        r = service.validate(service.stringToListInt("abbceffg"))
        if (r != 1) throw Exception("error 1: $r")
        r = service.validate(service.stringToListInt("abbcegjkxyz"))
        if (r != 3) throw Exception("error 3: $r")
        r = service.validate(service.stringToListInt("abbcegjkxxyz"))
        if (r != 0) throw Exception("error 0: $r")
        r = service.validate(service.stringToListInt("abbbcegjkxyz"))
        if (r != 3) throw Exception("error 3: $r")
    }


    @Test
    fun exercise1() {
        val response = service.execute01("vzbxkghb")
        println(response)
        assertEquals("vzbxxyzz", response)
    }
    @Test
    fun exercise2() {
        var response = service.execute01("vzbxkghb")
        assertEquals("vzbxxyzz", response)
        response = service.execute01(response)
        println(response)
        assertEquals("vzcaabcc", response)
    }
}