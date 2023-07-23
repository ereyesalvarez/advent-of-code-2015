package advent.fifteen

class Day02 {
    fun execute01(input: String): Int {
        return solveDay1(input)
    }

    fun execute02(input: String): Int {
        return solveDay2(input)
    }

    private fun solveDay1(input: String): Int {
        // 2*l*w + 2*w*h + 2*h*l + small side
        var sum = 0
        input.lines().forEach { line ->
            val (l, w, h) = line.split("x").map { it.toInt() }
            val sides = calculateSides(l, w, h)
            val smallSide = sides.minOrNull() ?: throw Exception("Not found")
            val total = sides.sum() * 2 + smallSide
            sum += total
        }
        return sum
    }

    private fun calculateSides(l: Int, w: Int, h: Int): List<Int> {
        return listOf(l*w, w*h, h*l)
    }

    private fun solveDay2(input: String): Int {
        /*
        The ribbon required to wrap a present
        is the shortest distance around its sides,
        or the smallest perimeter of any one face.
        Each present also requires a bow made out of ribbon as well;
        the feet of ribbon required for the perfect bow is equal to the cubic feet of volume of the present.
        Don't ask how they tie the bow, though; they'll never tell.
         */
        var sum = 0
        input.lines().forEach { line ->
            val (l, w, h) = line.split("x").map { it.toInt() }
            val smallSides = listOf(l, w, h).sorted().dropLast(1)
            val shortDistance = smallSides[0] * 2 + smallSides[1] * 2

            val total = shortDistance  + l * w * h
            sum += total
        }
        return sum
    }
}