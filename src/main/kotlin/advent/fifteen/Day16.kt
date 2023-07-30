package advent.fifteen

class Day16 {

    private fun compare(it: Aunt, tar: Aunt): Boolean {
        return equalOrNull(it.children, tar.children)
                && equalOrNull(it.cats, tar.cats)
                && equalOrNull(it.samoyeds, tar.samoyeds)
                && equalOrNull(it.pomeranians, tar.pomeranians)
                && equalOrNull(it.akitas, tar.akitas)
                && equalOrNull(it.vizslas, tar.vizslas)
                && equalOrNull(it.goldfish, tar.goldfish)
                && equalOrNull(it.trees, tar.trees)
                && equalOrNull(it.cars, tar.cars)
                && equalOrNull(it.perfumes, tar.perfumes)
    }

    private fun compare2(it: Aunt, tar: Aunt): Boolean {
        return equalOrNull(it.children, tar.children)
                && greatOrNull(it.cats, tar.cats)
                && equalOrNull(it.samoyeds, tar.samoyeds)
                && fewOrNull(it.pomeranians, tar.pomeranians)
                && equalOrNull(it.akitas, tar.akitas)
                && equalOrNull(it.vizslas, tar.vizslas)
                && fewOrNull(it.goldfish, tar.goldfish)
                && greatOrNull(it.trees, tar.trees)
                && equalOrNull(it.cars, tar.cars)
                && equalOrNull(it.perfumes, tar.perfumes)
    }

    private fun greatOrNull(input: Int?, expected: Int?): Boolean {
        return input == null || input > expected!!
    }


    private fun fewOrNull(input: Int?, expected: Int?): Boolean {
        return input == null || input < expected!!
    }

    fun execute02(input: String): Int {
        val tar = Aunt(0, 3, 7, 2, 3, 0, 0, 5, 3, 2, 1)
        val aunts = input.lines().map { mapAunts(it) }
        val find = aunts.filter { compare2(it, tar) }
        return find.first().id
    }

    fun execute01(input: String): Int {
        val tar = Aunt(0, 3, 7, 2, 3, 0, 0, 5, 3, 2, 1)
        val aunts = input.lines().map { mapAunts(it) }
        val find = aunts.filter { compare(it, tar) }
        return find.first().id
    }

    private fun equalOrNull(input: Int?, expected: Int?): Boolean {
        return input == null || input == expected!!
    }


    fun mapAunts(line: String): Aunt {
        val id: Int = """Sue (\d+):""".toRegex().find(line)!!.destructured.component1().toInt()
        val children =
            """children: (\d+)""".toRegex().find(line)?.destructured?.component1()?.toInt()
        val cats = """cats: (\d+)""".toRegex().find(line)?.destructured?.component1()?.toInt()
        val samoyeds =
            """samoyeds: (\d+)""".toRegex().find(line)?.destructured?.component1()?.toInt()
        val pomeranians =
            """pomeranians: (\d+)""".toRegex().find(line)?.destructured?.component1()?.toInt()
        val akitas = """akitas: (\d+)""".toRegex().find(line)?.destructured?.component1()?.toInt()
        val vizslas = """vizslas: (\d+)""".toRegex().find(line)?.destructured?.component1()?.toInt()
        val goldfish =
            """goldfish: (\d+)""".toRegex().find(line)?.destructured?.component1()?.toInt()
        val trees = """trees: (\d+)""".toRegex().find(line)?.destructured?.component1()?.toInt()
        val cars = """cars: (\d+)""".toRegex().find(line)?.destructured?.component1()?.toInt()
        val perfumes =
            """perfumes: (\d+)""".toRegex().find(line)?.destructured?.component1()?.toInt()
        return Aunt(
            id,
            children,
            cats,
            samoyeds,
            pomeranians,
            akitas,
            vizslas,
            goldfish,
            trees,
            cars,
            perfumes
        )
    }

    data class Aunt(
        val id: Int,
        val children: Int?,
        val cats: Int?,
        val samoyeds: Int?,
        val pomeranians: Int?,
        val akitas: Int?,
        val vizslas: Int?,
        val goldfish: Int?,
        val trees: Int?,
        val cars: Int?,
        val perfumes: Int?
    )
    // children: 3
    //cats: 7
    //samoyeds: 2
    //pomeranians: 3
    //akitas: 0
    //vizslas: 0
    //goldfish: 5
    //trees: 3
    //cars: 2
    //perfumes: 1

}