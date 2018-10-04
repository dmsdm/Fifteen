package com.sdm.fifteen

import android.graphics.Color
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FifteenAdapter(val swapListener: FifteenSwapListener) : ListAdapter<Int, FifteenAdapter.ViewHolder>(DIFF_CALLBACK), FifteenSwipeAdapter {

    object DIFF_CALLBACK : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int?, newItem: Int?): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int?, newItem: Int?): Boolean {
            return true
        }
    }

    var items: MutableList<Int> = FifteenStateHolder.items as MutableList<Int>
    lateinit var itemTouchHelper: ItemTouchHelper

    override fun submitList(list: List<Int>) {
        items = list as MutableList<Int>
        super.submitList(list)
    }

    override fun swap(source: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder) {
        val startPosition = source.adapterPosition
        val endPosition = target.adapterPosition
        if (items[startPosition] > 0) {
            items[endPosition] = items[startPosition]
            items[startPosition] = 0
            (source as ViewHolder).bind(startPosition)
            (target as ViewHolder).bind(endPosition)
            swapListener.onSwap()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =  LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.isHapticFeedbackEnabled = false
        }
        private val text: TextView = view.findViewById(R.id.text)
        fun bind(position: Int) {
            if (items[position] == 0) {
                text.text = ""
                text.setBackgroundColor(Color.TRANSPARENT)
                itemView.setOnTouchListener { _, _ -> return@setOnTouchListener false }
            } else {
                text.text = (items[position]).toString()
                text.setBackgroundColor(0xFFFFBB33.toInt())
                itemView.setOnTouchListener { _, _ ->
                    itemTouchHelper.startDrag(this)
                    return@setOnTouchListener false
                }
            }
        }
    }
}