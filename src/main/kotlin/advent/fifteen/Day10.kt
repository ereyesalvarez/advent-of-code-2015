package advent.fifteen

class Day10 {
    fun execute01(input: String): Int {
        return execute01(input, 40)
    }

    fun execute01(input: String, n: Int): Int {
        var x = input
        for (i in 0..<n) {
            x = solve1(x)
        }
        return x.length
    }

    fun solve1(input: String): String {
        var buffer = ""
        var count = 0
        var lastC: Char? = null
        for (c in input) {
            if (lastC == c) {
                count++
            } else {
                if (lastC != null) {
                    buffer += "$count$lastC"
                }
                lastC = c
                count = 1
            }
        }
        buffer += "$count$lastC"
        return buffer
    }

    fun execute02(input: String, n: Int): Int {
        var x = input.map { it -> it.digitToInt() }
        for (i in 0..<n) {
            val z = solve2(x)
            x = z
        }
        return x.size
    }


    private fun solve2(input: List<Int>): List<Int> {
        var buffer = mutableListOf<Int>()
        var count = 0
        var lastC: Int? = null
        for (c in input) {
            if (lastC == c) {
                count++
            } else {
                if (lastC != null) {
                    buffer.add(count)
                    buffer.add(lastC)
                }
                lastC = c
                count = 1
            }
        }
        buffer.add(count)
        buffer.add(lastC!!)
        return buffer
    }
}