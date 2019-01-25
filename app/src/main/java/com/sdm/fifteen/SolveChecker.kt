package com.sdm.fifteen

object SolveChecker {

    fun check(items: List<Int>): Boolean {
        val itemsWithoutZero = items.minus(0)
        return itemsWithoutZero == itemsWithoutZero.sorted()
    }

    fun isSolvable(items: List<Int>): Boolean {
        val itemsWithoutZero = items.minus(0)
        var nextItems = items.minus(0)
        var sum = items.indexOf(0) / 4 + 1
        itemsWithoutZero.forEach {
            nextItems = nextItems.minus(it)
            nextItems.forEach { it2 ->
                if (it2 < it) {
                    sum++
                }
            }
        }
        return sum%2 == 0
    }

}