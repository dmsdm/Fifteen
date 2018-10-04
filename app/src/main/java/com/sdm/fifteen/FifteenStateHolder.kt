package com.sdm.fifteen

import java.util.*

object FifteenStateHolder {
    var items = MutableList(16) { i -> if (i < 15) (i + 1) else 0 }.shuffled()

    fun reset() {
        items = items.shuffled().toMutableList()
    }
}