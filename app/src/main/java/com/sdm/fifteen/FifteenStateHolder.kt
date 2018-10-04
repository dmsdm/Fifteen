package com.sdm.fifteen

import java.util.*

object FifteenStateHolder {

    var items = getSolvableList(MutableList(16) { i -> if (i < 15) (i + 1) else 0 })

    private fun getSolvableList(items: List<Int>): List<Int> {
        var newItems = items.shuffled()
        while (!SolveChecker.isSolvable(newItems)) {
            newItems = newItems.shuffled()
        }
        return newItems
    }

    fun reset() {
        items = getSolvableList(items)
    }

}