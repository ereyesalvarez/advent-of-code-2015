package advent.fifteen
import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8

class Day04 {
    fun execute01(input: String): Int {
        return solveDay1(input)
    }

    fun execute02(input: String): Int {
        return solveDay2(input)
    }

    private fun solveDay1(input: String): Int {
        var result = 0
        do {
            val hash = generateString(input, result)
            if (hash.startsWith("00000")) return result
            result++
        } while (true)
    }
    private fun solveDay2(input: String): Int {
        var result = 0
        do {
            val hash = generateString(input, result)
            if (hash.startsWith("000000")) return result
            result++
        } while (true)
    }

    private fun generateString(key: String, suffix: Int): String{
        val value = key + suffix
        return md5AsString(value)
    }

    private fun md5(str: String): ByteArray = MessageDigest.getInstance("MD5").digest(str.toByteArray(UTF_8))
    @OptIn(ExperimentalStdlibApi::class)
    fun md5AsString(str: String): String = md5(str).toHexString()


}