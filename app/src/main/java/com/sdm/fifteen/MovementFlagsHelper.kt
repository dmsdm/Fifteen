package com.sdm.fifteen

import android.support.v7.widget.helper.ItemTouchHelper

class MovementFlagsHelper {

    companion object {
        fun getMovementFlags(items: List<Int>, adapterPosition: Int) : Int {
            val zeroPos = items.indexOf(0)
            when (zeroPos) {
                0 -> when (adapterPosition) {
                    1 -> return ItemTouchHelper.LEFT
                    4 -> return ItemTouchHelper.UP
                }
                1, 2 -> when (adapterPosition) {
                    zeroPos - 1 -> return ItemTouchHelper.RIGHT
                    zeroPos + 1 -> return ItemTouchHelper.LEFT
                    zeroPos + 4 -> return ItemTouchHelper.UP
                }
                3 -> when (adapterPosition) {
                    2 -> return ItemTouchHelper.RIGHT
                    7 -> return ItemTouchHelper.UP
                }
                4, 8 -> when (adapterPosition) {
                    zeroPos - 4 -> return ItemTouchHelper.DOWN
                    zeroPos + 1 -> return ItemTouchHelper.LEFT
                    zeroPos + 4 -> return ItemTouchHelper.UP
                }
                5, 6, 9, 10 -> when (adapterPosition) {
                    zeroPos + 1 -> return ItemTouchHelper.LEFT
                    zeroPos - 1 -> return ItemTouchHelper.RIGHT
                    zeroPos - 4 -> return ItemTouchHelper.DOWN
                    zeroPos + 4 -> return ItemTouchHelper.UP
                }
                7, 11 -> when (adapterPosition) {
                    zeroPos - 4 -> return ItemTouchHelper.DOWN
                    zeroPos - 1 -> return ItemTouchHelper.RIGHT
                    zeroPos + 4 -> return ItemTouchHelper.UP
                }
                12 -> when (adapterPosition) {
                    13 -> return ItemTouchHelper.LEFT
                    8 -> return ItemTouchHelper.DOWN
                }
                13, 14 -> when (adapterPosition) {
                    zeroPos - 1 -> return ItemTouchHelper.RIGHT
                    zeroPos + 1 -> return ItemTouchHelper.LEFT
                    zeroPos - 4 -> return ItemTouchHelper.DOWN
                }
                15 -> when (adapterPosition) {
                    14 -> return ItemTouchHelper.RIGHT
                    11 -> return ItemTouchHelper.DOWN
                }
            }
            return 0
        }
    }
}