package advent.fifteen

class Day08 {
    fun execute01(input: String): Int {
        return solveDay1(input)
    }

    private fun solveDay1(input: String): Int {
        val memory = input.lines().sumOf { countMemory(it) }
        val char = input.lines().sumOf { countChars(it) }
        return memory - char
    }

    private fun countMemory(line: String): Int {
        return line.length
    }

    fun countChars(line: String): Int {
        val l = line.substring(1, line.length - 1)
        val backslash = """\\\\""".toRegex().findAll(l).count()
        val quoteRegex = """\\"""".toRegex()
        val charsRegex = """\\x(\d|[a-z])(\d|[a-z])""".toRegex()
        val l2 = l.split("\\\\")
        val quote = l2.sumOf { quoteRegex.findAll(it).count() }
        val chars = l2.sumOf { charsRegex.findAll(it).count() }
        return l.length - backslash - quote - chars * 3
    }

    fun execute02(input: String): Int {
        return solveDay2(input)
    }

    private fun solveDay2(input: String): Int {
        val memory = input.lines().sumOf { countMemory(it) }
        val encoded = input.lines().sumOf { countEncoded(it) }
        return encoded - memory
    }

    private fun countEncoded(line: String): Int {
        return encode(line).length
    }

    fun encode(line: String): String {
        val splitA = line.split("\"")
        val result = splitA.joinToString("\\\"") {
            val splitB = it.split("\\")
            splitB.joinToString("\\\\")
        }
        return "\"" + result + "\""
    }

}