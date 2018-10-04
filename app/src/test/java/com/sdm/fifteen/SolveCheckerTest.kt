package com.sdm.fifteen

import org.junit.Assert.*
import org.junit.Test

class SolveCheckerTest {

    @Test
    fun solved() {
        val items = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 13, 14, 15)
        assertTrue(SolveChecker.check(items))
    }

    @Test
    fun unsolved() {
        val items = arrayListOf(1, 2, 4, 3, 5, 6, 7, 8, 9, 10, 11, 12, 0, 13, 14, 15)
        assertFalse(SolveChecker.check(items))
    }

    @Test
    fun solvable() {
        val items = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0)
        assertTrue(SolveChecker.isSolvable(items))
    }

    @Test
    fun unsolvable() {
        val items = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 14, 0)
        assertFalse(SolveChecker.isSolvable(items))
    }

}