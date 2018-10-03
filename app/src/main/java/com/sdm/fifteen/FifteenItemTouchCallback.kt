package com.sdm.fifteen

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

class FifteenItemTouchCallback(private val adapter: FifteenSwipeAdapter) : ItemTouchHelper.Callback() {

    override fun getMovementFlags(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?): Int {
        val dragFlags = MovementFlagsHelper.getMovementFlags(FifteenStateHolder.items, viewHolder?.adapterPosition!!)
        val swipeFlags = 0
        return ItemTouchHelper.Callback.makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun canDropOver(recyclerView: RecyclerView?, current: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
        return true
    }

    override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
        adapter.swap(viewHolder!!, target!!)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
    }

    override fun isLongPressDragEnabled(): Boolean {
        return false
    }

    override fun isItemViewSwipeEnabled(): Boolean {
        return false
    }
}