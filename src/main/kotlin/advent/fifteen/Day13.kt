package advent.fifteen


class Day13 {
    fun execute01(input: String): Int {
        val (map, effects) = mapEffects(input)
        return calculateBruteForce(effects, map.size).maxOf { it.second }
    }

    fun execute02(input: String): Int {
        var (map, effects) = mapEffects(input)
        map = map + "me"
        effects = effects + generateExtraEffects(map.size)
        return calculateBruteForce(effects, map.size).maxOf { it.second }
    }

    fun generateExtraEffects(size: Int): Map<Pair<Int, Int>, Int> {
        val newPos = size - 1
        val range = (0..<newPos)
        return range.flatMap { i ->
            val x = Pair(Pair(newPos, i), 0)
            val y = Pair(Pair(i, newPos), 0)
            listOf(x, y)
        }.toMap()
    }

    private fun calculateBruteForce(effects: Map<Pair<Int, Int>, Int>, size: Int): List<Pair<List<Int>, Int>> {
        val combinations = generateCombinations(size - 1)
        return combinations.map { Pair(it, calculateHappiness(it, effects)) }
    }

    private fun calculateHappiness(list: List<Int>, effects: Map<Pair<Int, Int>, Int>): Int {
        return list.indices.sumOf { i ->
            val prevIndex = if (i == 0) list.size - 1 else i - 1
            val nextIndex = if (i == list.size - 1) 0 else i + 1
            val it = list[i]
            val prev = list[prevIndex]
            val next = list[nextIndex]
            val prevHappiness =
                effects[Pair(it, prev)] ?: throw Exception("Not found $it $prev in map")
            val nexHappiness =
                effects[Pair(it, next)] ?: throw Exception("Not found $it $next in map")
            prevHappiness + nexHappiness
        }
    }

    fun generateCombinations(size: Int): List<List<Int>> {
        var combinations: List<List<Int>> = listOf(listOf(0))
        for (i in 0..<size) {
            val iLists: MutableList<List<Int>> = mutableListOf()
            for (it in combinations) {
                val partials: MutableList<List<Int>> = mutableListOf()
                for (j in 1..size) {
                    if (!it.contains(j)) {
                        partials.add(it + j)
                    }
                }
                iLists.addAll(partials)
            }
            combinations = iLists
        }
        return combinations
    }

    private fun mapEffects(input: String): HappinessInput {
        val nameMap: MutableList<String> = mutableListOf()
        val effects = input.lines().associate {
            val regex =
                """(\w+) would (\w+) (\d+) happiness units by sitting next to (\w+)""".toRegex()
            val match = regex.find(it)!!
            val (name, change, effect: String, withName) = match.destructured
            if (!nameMap.contains(name)) {
                nameMap.add(name)
            }
            if (!nameMap.contains(withName)) {
                nameMap.add(withName)
            }
            val idA = nameMap.indexOf(name)
            val idB = nameMap.indexOf(withName)
            val effectAsInt = if (change == "gain") effect.toInt() else effect.toInt() * -1
            Pair(Pair(idA, idB), effectAsInt)
        }
        return HappinessInput(nameMap, effects)
    }

    data class HappinessInput(val nameList: List<String>, val effects: Map<Pair<Int, Int>, Int>)

}