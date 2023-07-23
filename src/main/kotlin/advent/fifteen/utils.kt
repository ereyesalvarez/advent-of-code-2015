package advent.fifteen

import java.io.File
fun getFileAsText(path: String): String =
    File(path).readText()

fun getAsListOfInt(input: String): List<Int?> {
    return input.lines().map {
        if (it.isBlank()) {
            null
        } else {
            it.toInt()
        }
    }
}