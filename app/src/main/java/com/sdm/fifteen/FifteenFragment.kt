package com.sdm.fifteen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class FifteenFragment : Fragment(), FifteenSwapListener {

    internal lateinit var recyclerView: RecyclerView
    internal lateinit var movesView: TextView

    override fun onSwap() {
        FifteenStateHolder.incrementMoves()
        movesView.text = FifteenStateHolder.moves.toString()

        if (SolveChecker.check(FifteenStateHolder.items)) {
            showWin()
        }
    }

    private fun showWin() {
        WinDialog().show(fragmentManager!!, "win")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val safeArgs = FifteenFragmentArgs.fromBundle(arguments!!)
        if (safeArgs.newGame) {
            FifteenStateHolder.reset()
        }
        FifteenStateHolder.inProgress = true

        val view = inflater.inflate(R.layout.fifteen_fragment, container, false)

        movesView = view.findViewById(R.id.moves_count)
        movesView.text = FifteenStateHolder.moves.toString()

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.adapter = FifteenAdapter(this)
        recyclerView.layoutManager = FifteenLayoutManager(context!!)
        val itemTouchCallback = FifteenItemTouchCallback(recyclerView.adapter as FifteenSwapHandler)
        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
        (recyclerView.adapter as FifteenAdapter).itemTouchHelper = itemTouchHelper
        (recyclerView.adapter as FifteenAdapter).submitList(FifteenStateHolder.items)
        recyclerView.setHasFixedSize(true)

        return view
    }
}