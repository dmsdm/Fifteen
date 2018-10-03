package com.sdm.fifteen

import java.util.*

object FifteenStateHolder {
    var items = IntArray(16) { i -> if (i < 15) (i + 1) else 0 }.toMutableList()

    fun reset() {
        items = items.shuffled().toMutableList()
    }
}