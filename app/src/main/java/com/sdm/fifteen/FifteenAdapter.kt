package com.sdm.fifteen

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FifteenAdapter : RecyclerView.Adapter<FifteenAdapter.ViewHolder>(), FifteenSwipeAdapter {

    val items = Array(16) { i -> if (i < 15) (i + 1) else 0 }
    lateinit var itemTouchHelper: ItemTouchHelper

    override fun swap(source: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder) {
        val startPosition = source.adapterPosition
        val endPosition = target.adapterPosition
        if (items[startPosition] > 0) {
            items[endPosition] = items[startPosition]
            items[startPosition] = 0
            (source as ViewHolder).bind(startPosition)
            (target as ViewHolder).bind(endPosition)
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

    override fun getItemCount(): Int = 16

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
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