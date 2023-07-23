package advent.fifteen

class Day09 {
    fun execute01(input: String): Int {
        val sections = input.lines().filter { it.isNotBlank() }.associate { mapLine(it) }
        val cities = sections.keys.flatten().distinct()
        return calculatePath(sections, cities, true)
    }

    fun execute02(input: String): Int {
        val sections = input.lines().filter { it.isNotBlank() }.associate { mapLine(it) }
        val cities = sections.keys.flatten().distinct()
        return calculatePath(sections, cities, false)
    }


    private fun mapLine(line: String): Pair<Set<String>, Int> {
        val x = line.split(" to ")
        val x2 = x[1].split(" = ")
        return Pair(setOf(x[0], x2[0]), x2[1].toInt())
    }

    private fun calculatePath(sections: Map<Set<String>, Int>, cities: List<String>, minDistance: Boolean): Int {
        var travels = cities.associate { Pair(Travel(it), 0) }
        for (i in 1..<cities.size) {
            val newTravels: MutableMap<Travel, Int> = mutableMapOf()
            travels.forEach { travel ->
                val tempTravels = calculateNextTravel(travel.toPair(), sections, cities)
                tempTravels.forEach {
                    val exitingDistance = newTravels[it.key]
                    if (exitingDistance != null) {
                        if ((minDistance && exitingDistance > it.value) || (!minDistance && exitingDistance < it.value)){
                            newTravels[it.key] = it.value
                        }
                    } else {
                        newTravels[it.key] = it.value
                    }
                }
            }
            travels = newTravels
        }
        return if (minDistance){
            travels.minOf { it.value }
        } else {
            travels.maxOf { it.value }
        }
    }

    private fun calculateNextTravel(
        current: Pair<Travel, Int>,
        sections: Map<Set<String>, Int>,
        cities: List<String>
    ): Map<Travel, Int> {
        val currentCity = current.first.currentCity
        val visitedCities = current.first.visitedCities
        val currentDistance = current.second
        val n = cities.mapNotNull {
            if (!visitedCities.contains(it)) {
                val distance = sections[setOf(currentCity, it)]
                if (distance == null) {
                    null
                } else {
                    Pair(Travel(it, visitedCities + it), currentDistance + distance)
                }
            } else {
                null
            }
        }.toMap()
        return n
    }

    data class Travel(var currentCity: String, var visitedCities: Set<String> = setOf(currentCity))
}