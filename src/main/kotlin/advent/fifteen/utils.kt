package advent.fifteen

import java.io.File
fun getFileAsText(path: String): String = File(path).readText()
