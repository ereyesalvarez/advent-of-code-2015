package advent.fifteen

class Day01 {
    fun execute01(input: String): Int {
        return solve01(input)
    }

    private fun solve01(input: String): Int {
        var count = 0
        val line  = input.lines().first()
        for (c in line) {
            if (c == '(') {
                count++
            } else {
                count--
            }
        }
        return count
    }

    fun execute02(input: String): Int {
        return solve02(input)
    }

    private fun solve02(input: String): Int {
        var count = 0
        var step = 0
        val line  = input.lines().first()
        for (c in line) {
            step++
            if (c == '(') {
                count++
            } else {
                count--
            }
            if (count == -1) {
                return step
            }
        }
        throw Exception("Not found")
    }
}