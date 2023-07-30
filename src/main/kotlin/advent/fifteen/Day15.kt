package advent.fifteen

class Day15 {
    private val maxCapacity = 100
    val regex =
        """(\w+): capacity (-?\d+), durability (-?\d+), flavor (-?\d+), texture (-?\d+), calories (-?\d+)""".toRegex()

    fun execute01(input: String): Int {
        val ingredients = input.lines().map { mapIngredients(it) }
        val possibilities = calculatePossibilities(ingredients.size)
        val result = possibilities.maxOf {
            calculateValue(it, ingredients)
        }
        return result
    }

    private fun calculateCalories(values: List<Int>, ingredients: List<Ingredient>): Int {
        return maxOf(values.indices.sumOf { values[it] * ingredients[it].calories }, 0)
    }
    private fun calculateValue(values: List<Int>, ingredients: List<Ingredient>): Int {
        val capacity = maxOf(values.indices.sumOf { values[it] * ingredients[it].capacity }, 0)
        val durability = maxOf(values.indices.sumOf { values[it] * ingredients[it].durability }, 0)
        val flavor = maxOf(values.indices.sumOf { values[it] * ingredients[it].flavor }, 0)
        val texture = maxOf(values.indices.sumOf { values[it] * ingredients[it].texture }, 0)
        return capacity * durability * flavor * texture
    }

    private fun increasePos(input: List<Int>, pos: Int): List<Int>? {
        if (pos >= input.size) {
            return null
        }
        val x = input.toMutableList()
        return if (input[pos] == maxCapacity) {
            x[pos] = 0
            increasePos(x, pos + 1)
        } else {
            x[pos] = x[pos] + 1
            x
        }
    }

    private fun calculatePossibilities(size: Int): List<List<Int>> {
        var keepCalculating = true
        var current = List(size) { 0 }
        val possibilities = mutableListOf<List<Int>>()
        do {
            val x = increasePos(current, 0)
            if (x == null) {
                keepCalculating = false
            } else {
                if (x.sum() == 100) {
                    possibilities.add(x)
                }
                current = x
            }
        } while (keepCalculating)
        return possibilities
    }


    private fun mapIngredients(input: String): Ingredient {
        val (name, capacity, durability, flavor, texture, calories) = regex.find(input)!!.destructured
        return Ingredient(
            name,
            capacity.toInt(),
            durability.toInt(),
            flavor.toInt(),
            texture.toInt(),
            calories.toInt()
        )
    }

    data class Ingredient(
        val name: String,
        val capacity: Int,
        val durability: Int,
        val flavor: Int,
        val texture: Int,
        val calories: Int
    )


    fun execute02(input: String): Int {
        val ingredients = input.lines().map { mapIngredients(it) }
        val possibilities = calculatePossibilities(ingredients.size)
        val result = possibilities.mapNotNull {
            if (calculateCalories(it, ingredients) == 500) {
                calculateValue(it, ingredients)
            } else {
                null
            }
        }.max()
        return result
    }
}