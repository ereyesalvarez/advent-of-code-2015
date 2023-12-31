package advent.fifteen

class Day11 {

    fun execute01(input: String): String {
        return solve1(input)
    }

    private fun solve1(input: String): String {
        // cant contain 'i', 'o' or  'l'
        // need to contain at least three consecutive letter
        // two pairs of pairs
        return listIntToString(solve1(stringToListInt(input)))
    }

    private fun solve1(input:List<Int>): List<Int> {
        var response : List<Int> = input
        do {
           response = increase(response, response.size - 1)
        } while (validate(response) != 0)
        return response
    }
    private fun increase(input: List<Int>, pos: Int): List<Int>{
        if (pos < 0){
            throw Exception("can't increase limit")
        }
        val x = input.toMutableList()
        return if (x[pos] == 122){
            x[pos] = 97
            increase(x, pos - 1)

        } else {
            x[pos] = x[pos] + 1
            x
        }
    }

    fun validate(input: List<Int>): Int{
        if (input.contains(105) || input.contains(108) || input.contains(111)){
            return 2
        }
        if (!validateFirst(input)){
            return 1
        }
        if (!validateThird(input)){
            return 3
        }
        return 0
    }
    private fun validateThird(input: List<Int>): Boolean{
        var pairs = 0
        var count = 1
        var last: Int = input[0]
        input.drop(1).forEach {
            if (last == it){
                count++
            } else {
                count = 1
            }
            last = it
            if (count == 2){
                count = 0
                pairs++
            }
        }
        return pairs >= 2
    }
    private fun validateFirst(input: List<Int>): Boolean{
        var count = 1
        var last: Int = input[0]
        var found = false
        input.drop(1).forEach {
            if (last + 1 == it){
                count++
            } else {
                count = 1
            }
            last = it
            if (count == 3) found = true
        }
        return found
    }

    fun stringToListInt(input: String): List<Int>{
        return input.map { it.code }
    }

    private fun listIntToString(input: List<Int>): String{
        return String(input.map { it.toChar() }.toCharArray())
    }

}