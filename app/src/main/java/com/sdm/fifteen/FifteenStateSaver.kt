package com.sdm.fifteen

import android.content.SharedPreferences

object FifteenStateSaver {

    fun saveState(preferences: SharedPreferences) {
        val editor = preferences.edit()
        if (FifteenStateHolder.inProgress) {
            editor.putString("items", FifteenStateHolder.items.joinToString())
            editor.putInt("moves", FifteenStateHolder.moves)
        }
        editor.putBoolean("in_progress", FifteenStateHolder.inProgress)
        editor.apply()
    }

    fun loadState(preferences: SharedPreferences) {
        val inProgress = preferences.getBoolean("in_progress", false)
        FifteenStateHolder.inProgress = inProgress
        if (inProgress) {
            val itemsString = preferences.getString("items", "")
            val items = itemsString?.split(", ")?.map { it.toInt() }
            FifteenStateHolder.items = items!!
            FifteenStateHolder.moves = preferences.getInt("moves", 0)
        }
    }

}