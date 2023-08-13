package advent.fifteen


import kotlin.test.Test
import kotlin.test.assertEquals

class Day18Test {
    private val day = "18"
    private val example = "data/day${day}_example.txt"
    private val step1 = "data/day${day}_example_step1.txt"
    private val step2 = "data/day${day}_example_step2.txt"
    private val step3 = "data/day${day}_example_step3.txt"
    private val step4 = "data/day${day}_example_step4.txt"
    private val input = "data/day${day}_input.txt"

    private val service = Day18()

    @Test
    fun example1() {
        val fileContent = getFileAsText(example)
        val response = service.execute01(fileContent, 4)
        assertEquals(4, response)
    }
    @Test
    fun example2() {
        val fileContent = getFileAsText(example)
        val response = service.execute02(fileContent, 5)
        assertEquals(17, response)
    }

    @Test
    fun exercise1() {
        val fileContent = getFileAsText(input)
        val response = service.execute01(fileContent, 100)
        assertEquals(814, response)
    }

    @Test
    fun exercise2() {
        val fileContent = getFileAsText(input)
        val response = service.execute02(fileContent, 100)
        assertEquals(924, response)
    }

    @Test
    fun testSteps1(){
        val fileContent = getFileAsText(example)
        val board = service.mapString(fileContent)
        val expectedStep1 = service.mapString(getFileAsText(step1))
        val expectedStep2 = service.mapString(getFileAsText(step2))
        val expectedStep3 = service.mapString(getFileAsText(step3))
        val expectedStep4 = service.mapString(getFileAsText(step4))
        val step1 = service.calculateNext(board)
        assertEquals(expectedStep1, step1)
        val step2 = service.calculateNext(step1)
        assertEquals(expectedStep2, step2)
        val step3 = service.calculateNext(step2)
        assertEquals(expectedStep3, step3)
        val step4 = service.calculateNext(step3)
        assertEquals(expectedStep4, step4)
    }
    @Test
    fun testSteps2(){
        val fileContent = getFileAsText(example)
        val board = service.mapString(fileContent)
        val expectedStep1 = service.mapString(getFileAsText(step1))
        val expectedStep2 = service.mapString(getFileAsText(step2))
        val expectedStep3 = service.mapString(getFileAsText(step3))
        val expectedStep4 = service.mapString(getFileAsText(step4))
        val step1 = service.calculateNext(board)
        assertEquals(expectedStep1, step1)
        val step2 = service.calculateNext(step1)
        assertEquals(expectedStep2, step2)
        val step3 = service.calculateNext(step2)
        assertEquals(expectedStep3, step3)
        val step4 = service.calculateNext(step3)
        assertEquals(expectedStep4, step4)
    }

}