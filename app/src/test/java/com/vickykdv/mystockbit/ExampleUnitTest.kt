package com.vickykdv.mystockbit

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    fun rotation(A: IntArray, K: Int): IntArray {
        val rotatedA = IntArray(A.size)
        for (i in A.indices) {
            //rotated index needs to "wrap" around end of array
            val rotatedIndex = (i + K) % A.size
            rotatedA[rotatedIndex] = A[i]
        }
        return rotatedA
    }

    @Test
    fun main() {
        val arrays = intArrayOf(3, 8, 9, 7, 6)


        println(rotation(arrays,4))

    }
}