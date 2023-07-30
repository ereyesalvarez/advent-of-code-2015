package advent.fifteen

class Day17 {



    data class Container(val id: Int, val value: Int)
    fun execute01(input: String, expected: Int): Int {
        val containers = input.lines().withIndex().map { Container(it.index, it.value.toInt()) }.toSet()
        val result = resolve(containers, expected)
        return result.size
    }
    fun execute02(input: String, expected: Int): Int {
        val containers = input.lines().withIndex().map { Container(it.index, it.value.toInt()) }.toSet()
        val result = resolve(containers, expected)
        val min = result.minOf { it.size }
        return result.filter { it.size == min }.size
    }
    private fun resolve(containers: Set<Container>, expected: Int): List<Set<Container>> {
        var combs = containers.map { setOf(it) }.toSet()
        var keep: Boolean
        var i = 0
        do {
            i++
            keep = false
            val newCombs = mutableSetOf<Set<Container>>()
            combs.forEach {
                if (it.sum() == expected) {
                    newCombs.add(it)
                } else {
                    val pendingContainers = containers.minus(it)
                    val l = pendingContainers.mapNotNull { c ->
                        val temp = it + c
                        if (temp.sum() <= expected) {
                            keep = true
                            temp
                        } else {
                            null
                        }
                    }
                    newCombs.addAll(l)
                }
            }
            combs = newCombs
        } while (keep)
        return combs.filter { it.sum() == expected }
    }
}

private fun Collection<Day17.Container>.sum(): Int {
    return this.sumOf { it.value }
}
