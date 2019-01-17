package com.sdm.fifteen

import androidx.recyclerview.widget.RecyclerView


interface FifteenSwapHandler {
    fun swap(source: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder)
}