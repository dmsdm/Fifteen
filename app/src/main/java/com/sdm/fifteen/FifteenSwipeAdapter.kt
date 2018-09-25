package com.sdm.fifteen

import android.support.v7.widget.RecyclerView

interface FifteenSwipeAdapter {
    fun swap(source: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder)
}