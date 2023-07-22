package advent.fifteen

class Day03 {
    fun execute01(input: String): Int {
        return solveDay1(input)
    }

    fun execute02(input: String): Int {
        return solveDay2(input)
    }

    private fun solveDay1(input: String): Int {
        val set = mutableSetOf<Point>()
        var current = Point(0, 0)
        set.add(current)
        input.forEach {
            current = nextPoint(current, it)
            set.add(current)
        }
        return set.size

    }


    private fun solveDay2(input: String): Int {
        val setSanta = mutableSetOf<Point>()
        var currentSanta = Point(0, 0)
        var currentRobot = Point(0, 0)
        setSanta.add(currentSanta)
        setSanta.add(currentRobot)
        input.forEachIndexed { index, it ->
            if (index % 2 == 0) {
                currentSanta = nextPoint(currentSanta, it)
                setSanta.add(currentSanta)
            } else {
                currentRobot = nextPoint(currentRobot, it)
                setSanta.add(currentRobot)
            }
        }
        return setSanta.size
    }

    private fun nextPoint(point: Point, char: Char): Point {
        return when (char) {
            '>' -> Point(point.x + 1, point.y)

            '<' -> Point(point.x - 1, point.y)

            'v' -> Point(point.x, point.y - 1)

            '^' -> Point(point.x, point.y + 1)

            else -> throw IllegalStateException("Not valid char")
        }
    }
}