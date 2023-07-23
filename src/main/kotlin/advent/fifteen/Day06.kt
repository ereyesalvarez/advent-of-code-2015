package advent.fifteen

class Day06 {
    fun execute01(input: String): Int {
        return solveDay1(input)
    }

    fun execute02(input: String): Int {
        return solveDay2(input)
    }

    private fun solveDay1(input: String): Int {
        val array = MutableList(1000) { MutableList(1000) { false } }
        input.lines().filter { it.isNotBlank() }.map { getAction(it) }
            .forEach { applyChange(array, it) }
        return countOn(array)
    }

    private fun countOn(array: List<List<Boolean>>): Int {
        return array.fold(0) { acc, n -> n.count { it } + acc }
    }

    private fun applyChange(array: MutableList<MutableList<Boolean>>, lineAction: LineAction) {
        for (x in lineAction.from.x..lineAction.to.x) {
            for (y in lineAction.from.y..lineAction.to.y) {
                when (lineAction.action) {
                    Action.TurnOn -> array[y][x] = true
                    Action.TurnOff -> array[y][x] = false
                    Action.Toggle -> array[y][x] = !array[y][x]
                }
            }
        }
    }

    private fun applyChange2(array: MutableList<MutableList<Int>>, lineAction: LineAction) {
        for (x in lineAction.from.x..lineAction.to.x) {
            for (y in lineAction.from.y..lineAction.to.y) {
                when (lineAction.action) {
                    Action.TurnOn -> array[y][x] = array[y][x] + 1
                    Action.TurnOff -> {
                        if (array[y][x] != 0) {
                            array[y][x] = array[y][x] - 1
                        }
                    }

                    Action.Toggle -> array[y][x] = array[y][x] + 2
                }
            }
        }
    }


    private fun solveDay2(input: String): Int {
        val array = MutableList(1000) { MutableList(1000) { 0 } }
        input.lines().filter { it.isNotBlank() }.map { getAction(it) }
            .forEach { applyChange2(array, it) }
        return countBright(array)
    }


    private fun countBright(array: List<List<Int>>): Int {
        return array.fold(0) { acc, n -> n.sum() + acc }
    }

    private fun getAction(line: String): LineAction {
        val action = if (line.contains("turn on")) {
            Action.TurnOn
        } else if (line.contains("turn off")) {
            Action.TurnOff
        } else if (line.contains("toggle")) {
            Action.Toggle
        } else {
            throw IllegalArgumentException("Not valid action on $line")
        }
        val regex = """(\d+)""".toRegex()
        val x = regex.findAll(line)
        val z = x.toList()
        val fromX = z[0].value.toInt()
        val fromY = z[1].value.toInt()
        val toX = z[2].value.toInt()
        val toY = z[3].value.toInt()
        return LineAction(action, Point(fromX, fromY), Point(toX, toY))
    }


    data class LineAction(val action: Action, val from: Point, val to: Point)

    enum class Action {
        TurnOn,
        TurnOff,
        Toggle
    }
}