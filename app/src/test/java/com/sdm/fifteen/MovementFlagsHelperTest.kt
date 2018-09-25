package com.sdm.fifteen

import android.support.v7.widget.helper.ItemTouchHelper
import org.junit.Assert.*
import org.junit.Test

class MovementFlagsHelperTest {

    @Test
    fun upperLeft() {
        val items = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        assertEquals(ItemTouchHelper.LEFT, MovementFlagsHelper.getMovementFlags(items, 1))
        assertEquals(ItemTouchHelper.UP, MovementFlagsHelper.getMovementFlags(items, 4))
        assertEquals(0, MovementFlagsHelper.getMovementFlags(items, 15))
    }

    @Test
    fun upperCenter() {
        val items = arrayOf(1, 0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        assertEquals(ItemTouchHelper.RIGHT, MovementFlagsHelper.getMovementFlags(items, 0))
        assertEquals(ItemTouchHelper.LEFT, MovementFlagsHelper.getMovementFlags(items, 2))
        assertEquals(ItemTouchHelper.UP, MovementFlagsHelper.getMovementFlags(items, 5))
        assertEquals(0, MovementFlagsHelper.getMovementFlags(items, 15))
    }

    @Test
    fun upperRight() {
        val items = arrayOf(1, 2, 3, 0, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        assertEquals(ItemTouchHelper.RIGHT, MovementFlagsHelper.getMovementFlags(items, 2))
        assertEquals(ItemTouchHelper.UP, MovementFlagsHelper.getMovementFlags(items, 7))
        assertEquals(0, MovementFlagsHelper.getMovementFlags(items, 15))
    }

    @Test
    fun leftCenter() {
        val items = arrayOf(1, 2, 3, 4, 0, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        assertEquals(ItemTouchHelper.DOWN, MovementFlagsHelper.getMovementFlags(items, 0))
        assertEquals(ItemTouchHelper.LEFT, MovementFlagsHelper.getMovementFlags(items, 5))
        assertEquals(ItemTouchHelper.UP, MovementFlagsHelper.getMovementFlags(items, 8))
        assertEquals(0, MovementFlagsHelper.getMovementFlags(items, 15))
    }

    @Test
    fun centerSquare() {
        val items = arrayOf(1, 2, 3, 4, 5, 0, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
        assertEquals(ItemTouchHelper.RIGHT, MovementFlagsHelper.getMovementFlags(items, 4))
        assertEquals(ItemTouchHelper.LEFT, MovementFlagsHelper.getMovementFlags(items, 6))
        assertEquals(ItemTouchHelper.DOWN, MovementFlagsHelper.getMovementFlags(items, 1))
        assertEquals(ItemTouchHelper.UP, MovementFlagsHelper.getMovementFlags(items, 9))
        assertEquals(0, MovementFlagsHelper.getMovementFlags(items, 0))

    }

    @Test
    fun rightCenter() {
        val items = arrayOf(1, 2, 3, 4, 5, 6, 7, 0, 8, 9, 10, 11, 12, 13, 14, 15)
        assertEquals(ItemTouchHelper.DOWN, MovementFlagsHelper.getMovementFlags(items, 3))
        assertEquals(ItemTouchHelper.RIGHT, MovementFlagsHelper.getMovementFlags(items, 6))
        assertEquals(ItemTouchHelper.UP, MovementFlagsHelper.getMovementFlags(items, 11))
    }

    @Test
    fun lowerLeft() {
        val items = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0, 13, 14, 15)
        assertEquals(ItemTouchHelper.LEFT, MovementFlagsHelper.getMovementFlags(items, 13))
        assertEquals(ItemTouchHelper.DOWN, MovementFlagsHelper.getMovementFlags(items, 8))
        assertEquals(0, MovementFlagsHelper.getMovementFlags(items, 1))
    }

    @Test
    fun lowerCenter() {
        val items = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 0, 14, 15)
        assertEquals(ItemTouchHelper.RIGHT, MovementFlagsHelper.getMovementFlags(items, 12))
        assertEquals(ItemTouchHelper.LEFT, MovementFlagsHelper.getMovementFlags(items, 14))
        assertEquals(ItemTouchHelper.DOWN, MovementFlagsHelper.getMovementFlags(items, 9))
        assertEquals(0, MovementFlagsHelper.getMovementFlags(items, 15))
    }

    @Test
    fun lowerRight() {
        val items = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0)
        assertEquals(ItemTouchHelper.RIGHT, MovementFlagsHelper.getMovementFlags(items, 14))
        assertEquals(ItemTouchHelper.DOWN, MovementFlagsHelper.getMovementFlags(items, 11))
        assertEquals(0, MovementFlagsHelper.getMovementFlags(items, 1))
    }

}