package com.sdm.fifteen.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.sdm.fifteen.R
import com.sdm.fifteen.viewmodel.StartViewModel

class StartFragment : Fragment() {

    @VisibleForTesting lateinit var viewModel: StartViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.start_fragment, container, false)

        view.findViewById<Button>(R.id.new_game).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_start))

        viewModel = ViewModelProviders.of(this).get(StartViewModel::class.java)

        subscribeUi()

        return view
    }

    private fun subscribeUi() {
        viewModel.inProgress.observe(this, Observer {
            setupContinueButton(it)
        })
    }

    private fun setupContinueButton(visible: Boolean) {
        if (visible) {
            view?.findViewById<Button>(R.id.continue_game)?.visibility = View.VISIBLE
            view?.findViewById<Button>(R.id.continue_game)?.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_continue))
        } else {
            view?.findViewById<Button>(R.id.continue_game)?.visibility = View.GONE
        }
    }

}