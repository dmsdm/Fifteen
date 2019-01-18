package com.sdm.fifteen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class StartFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.start_fragment, container, false)
        view.findViewById<Button>(R.id.new_game).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_start))
        if (FifteenStateHolder.inProgress) {
            view.findViewById<Button>(R.id.continue_game).visibility = View.VISIBLE
            view.findViewById<Button>(R.id.continue_game).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_continue))
        } else {
            view.findViewById<Button>(R.id.continue_game).visibility = View.GONE
        }
        return view
    }

}