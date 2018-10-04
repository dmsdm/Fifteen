package com.sdm.fifteen

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.Menu
import android.view.MenuItem


class MainActivity : AppCompatActivity(), FifteenSwapListener {

    @VisibleForTesting
    internal lateinit var recyclerView: RecyclerView

    override fun onSwap() {
        if (SolveChecker.check(FifteenStateHolder.items)) {
            title = "solved"
        } else {
            title = "unsolved"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = FifteenAdapter(this)
        recyclerView.layoutManager = FifteenLayoutManager(this)
        val itemTouchHelper = ItemTouchHelper(FifteenItemTouchCallback(recyclerView.adapter as FifteenSwipeAdapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)
        (recyclerView.adapter as FifteenAdapter).itemTouchHelper = itemTouchHelper
        (recyclerView.adapter as FifteenAdapter).submitList(FifteenStateHolder.items)
        recyclerView.setHasFixedSize(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.reset -> {
                FifteenStateHolder.reset()
                (recyclerView.adapter as FifteenAdapter).submitList(FifteenStateHolder.items)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}