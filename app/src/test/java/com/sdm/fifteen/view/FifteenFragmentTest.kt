package com.sdm.fifteen.view

import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FifteenFragmentTest {

    private var scenario: FragmentScenario<FifteenFragment>? = null

    @Before
    fun setUp() {
        val fragmentArgs = Bundle().apply {
            putBoolean("newGame", true)
        }
        scenario = launchFragmentInContainer<FifteenFragment>(fragmentArgs)
    }

    @Test
    fun recyclerViewWithAdapter() {
        scenario?.onFragment {
            assertNotNull(it.recyclerView.adapter)
        }
    }

    @Test
    fun layoutManager() {
        scenario?.onFragment {
            assertNotNull(it.recyclerView.layoutManager)
        }
    }

    @Test
    fun movesView() {
        scenario?.onFragment {
            assertNotNull(it.movesView)
        }
    }
}