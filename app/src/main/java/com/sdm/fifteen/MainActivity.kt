package com.sdm.fifteen

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

class MainActivity : AppCompatActivity() {

    @VisibleForTesting
    internal lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = FifteenAdapter()
        recyclerView.layoutManager = FifteenLayoutManager(this)
        val itemTouchHelper = ItemTouchHelper(FifteenItemTouchCallback(recyclerView.adapter as FifteenSwipeAdapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)
        (recyclerView.adapter as FifteenAdapter).itemTouchHelper = itemTouchHelper
        recyclerView.setHasFixedSize(true)
    }
}