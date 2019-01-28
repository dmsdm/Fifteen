package com.sdm.fifteen.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sdm.fifteen.R


class MainActivity : AppCompatActivity(), WinDialog.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDismissWinDialog() {
        onBackPressed()
    }

}