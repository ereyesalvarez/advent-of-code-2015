package advent.fifteen

class Day18 {
    fun execute01(input: String, steps: Int): Int {
        var x = mapString(input)
        for (s in 0..<steps) {
            x = calculateNext(x)
        }
        return count(x)
    }

    fun execute02(input: String, steps: Int): Int {
        var x = mapString(input)
        x = lightOnCorners(x)
        for (s in 0..<steps) {
            x = calculateNext(x)
            x = lightOnCorners(x)
        }
        return count(x)
    }

    private fun mapToInt(b: Boolean): Int = if (b) 1 else 0

    private fun count(board: List<List<Boolean>>): Int {
        return board.sumOf {
            it.sumOf { b -> mapToInt(b) }
        }
    }

    fun mapString(input: String): List<List<Boolean>> {
        return input.lines().map {
            it.map { c -> c == '#' }.toMutableList()
        }.toMutableList()
    }

    fun calculateNext(board: List<List<Boolean>>): MutableList<MutableList<Boolean>> {
        val next = board.map { it.toMutableList() }.toMutableList()
        val with = board[0].size
        for (y in board.indices) {
            for (x in 0..<with) {
                next[y][x] = calculateNext(board, Point(x, y))
            }
        }
        return next
    }

    private fun calculateNext(board: List<List<Boolean>>, point: Point): Boolean {
        // A light which is on stays on when 2 or 3 neighbors are on, and turns off otherwise.
        // A light which is off turns on if exactly 3 neighbors are on, and stays off otherwise.
        val neighborsOn = calculateNeighborsOn(board, point)
        val current = board[point.y][point.x]
        return if (current) {
            neighborsOn == 2 || neighborsOn == 3
        } else {
            neighborsOn == 3
        }
    }

    private fun calculateNeighborsOn(board: List<List<Boolean>>, point: Point): Int {
        var count = 0
        val topSide = point.y <= 0
        val bottomSide = point.y >= board.size - 1
        val leftSide = point.x <= 0
        val rightSide = point.x >= board[0].size - 1
        // Top
        if (!topSide) {
            // Top
            if (board[point.y - 1][point.x]) count++
            // Top Left
            if (!leftSide) {
                if (board[point.y - 1][point.x - 1]) count++
            }
            if (!rightSide) {
                if (board[point.y - 1][point.x + 1]) count++
            }
        }
        // Bot
        if (!bottomSide) {
            // Bot
            if (board[point.y + 1][point.x]) count++
            // Bot Left
            if (!leftSide) {
                if (board[point.y + 1][point.x - 1]) count++
            }
            if (!rightSide) {
                if (board[point.y + 1][point.x + 1]) count++
            }
        }
        if (!leftSide) {
            if (board[point.y][point.x - 1]) count++
        }
        if (!rightSide) {
            if (board[point.y][point.x + 1]) count++
        }
        return count
    }

    private fun lightOnCorners(board: List<List<Boolean>>): List<List<Boolean>>{
        val next = board.map { it.toMutableList() }.toMutableList()
        next[0][0] = true
        next[0][next.size - 1] =  true
        next[next.size -1][0] =  true
        next[next.size -1][next.size - 1] =  true
        return next
    }
}
