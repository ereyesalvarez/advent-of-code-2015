package advent.fifteen

class Day14 {
    fun execute01(input: String, duration: Int): Int{
        val speeds = input.lines().map { parseSpeed(it) }
        return speeds.maxOf { calculateDistance(it, duration) }
    }
    fun execute02(input: String, duration: Int): Int{
        val speeds = input.lines().map { parseSpeed(it) }
        return calculatePoints(speeds, duration)
    }

    private fun calculatePoints(speeds: List<ReindeerSpeed>, duration: Int): Int {
        val points: MutableMap<String, Int> = mutableMapOf()
        for (i in 1..duration) {
            val pos = speeds.map { Pair(it.name, calculateDistance(it, i)) }
            val max = pos.maxOf { it.second }
            pos.filter { it.second == max }.forEach {
                val current  = points.getOrDefault(it.first, 0)
                points[it.first] = current + 1
            }
        }
        val x = points.maxBy { it.value }
        println(x)
        return x.value
    }

    fun calculateDistance(speed: ReindeerSpeed, duration: Int): Int{
        if (duration == 0) return 0
        var pendingS = duration
        var rested = true
        var distance = 0
        do {
            if (rested){
                if (speed.seconds > pendingS){
                    distance += speed.speed * pendingS
                    pendingS = 0
                } else {
                    distance += speed.speed * speed.seconds
                    pendingS -= speed.seconds
                }
                rested = false
            } else {
                if (speed.restSeconds > pendingS){
                    pendingS = 0
                } else {
                    pendingS -= speed.restSeconds
                }
                rested = true
            }
        } while (pendingS > 0)
        return distance
    }
    private fun parseSpeed(line: String): ReindeerSpeed{
        val regex = """(\w+) can .* (\d+) km/s .* (\d+) seconds, .* (\d+)""".toRegex()
        val (name, speed, seconds, restSeconds) = regex.find(line)!!.destructured
        return ReindeerSpeed(name, speed.toInt(), seconds.toInt(), restSeconds.toInt())
    }
    data class ReindeerSpeed(val name: String, val speed: Int, val seconds: Int, val restSeconds: Int)
}