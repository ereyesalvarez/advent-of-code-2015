package advent.fifteen

class Day07 {
    fun execute01(input: String): Int {
        return solveDay1B(input, "a")
    }

    fun execute02(input: String): Int {
        return solveDay2(input)
    }

    data class Instruction(
        val operator: Operator,
        val to: String,
        val a: String,
        val b: String = ""
    )

    enum class Operator {
        Assign,
        And,
        Or,
        LShift,
        RShift,
        Not
    }

    private fun applyOperation(operator: Operator, a: Int, b: Int? = null): Int {
        return when (operator) {
            Operator.Assign -> a
            Operator.And -> a.and(b!!)
            Operator.Or -> a.or(b!!)
            Operator.LShift -> leftShift(a, b!!)
            Operator.RShift -> rightShift(a, b!!)
            Operator.Not -> a.toUShort().inv().toInt()
        }
    }

    fun rightShift(n: Int, shifts: Int): Int {
        return if (shifts == 1) {
            var string = Integer.toBinaryString(n)
            string = string.substring(0, string.length - 1)
            string = "0$string"
            Integer.parseInt(string, 2)
        } else {
            val n1 = rightShift(n, 1)
            rightShift(n1, shifts - 1)
        }
    }

    fun leftShift(n: Int, shifts: Int): Int {
        return if (shifts == 1) {
            var string = Integer.toBinaryString(n)
            if (string.length == 16) {
                string = string.substring(1, 16)
            }
            val result = "${string}0"
            Integer.parseInt(result, 2)
        } else {
            val n1 = leftShift(n, 1)
            leftShift(n1, shifts - 1)
        }
    }

    fun solveDay1B(input: String, toGet: String): Int {
        val instructions = input.lines().filter { it.isNotBlank() }
            .map { line -> mapLine(line) }
        val map: MutableMap<String, Int> = mutableMapOf()
        return resolveBackward(toGet, instructions, map)

    }

    private fun resolveBackward(
        toGet: String,
        instructions: List<Instruction>,
        map: MutableMap<String, Int>
    ): Int {
        val current = instructions.first { it.to == toGet }
        val a = if (current.a.toIntOrNull() != null) {
            current.a.toInt()
        } else {
            map.getOrPut(current.a) { resolveBackward(current.a, instructions, map) }
        }
        if (current.operator == Operator.Assign || current.operator == Operator.Not) {
            val result = applyOperation(current.operator, a)
            map[current.to] = result
            return result
        }
        val b = if (current.b.toIntOrNull() != null) {
            current.b.toInt()
        } else {
            map.getOrPut(current.b) { resolveBackward(current.b, instructions, map) }
        }
        val result = applyOperation(current.operator, a, b)
        map[current.to] = result
        return result
    }


    private fun mapLine(line: String): Instruction {
        val split = line.split(" -> ")
        val part1 = split[0].trim()
        val to = split[1].trim()
        val a: String
        val b: String
        val operator: Operator
        if (part1.contains("NOT ")) {
            a = part1.split("NOT")[1].trim()
            b = ""
            operator = Operator.Not
        } else if (part1.contains(" AND ")) {
            val values = part1.split(" AND ").map { it.trim() }
            a = values[0]
            b = values[1]
            operator = Operator.And
        } else if (part1.contains(" OR ")) {
            val values = part1.split(" OR ").map { it.trim() }
            a = values[0]
            b = values[1]
            operator = Operator.Or
        } else if (part1.contains(" RSHIFT ")) {
            val values = part1.split(" RSHIFT ").map { it.trim() }
            a = values[0]
            b = values[1]
            operator = Operator.RShift
        } else if (part1.contains(" LSHIFT ")) {
            val values = part1.split(" LSHIFT ").map { it.trim() }
            a = values[0]
            b = values[1]
            operator = Operator.LShift
        } else {
            a = part1
            b = ""
            operator = Operator.Assign
        }
        return Instruction(operator, to, a, b)
    }

    private fun solveDay2(input: String): Int {
        TODO()
    }

}