package com.sdm.fifteen.view

import android.view.View
import android.widget.Button
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sdm.fifteen.R
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StartFragmentTest {
    private var scenario: FragmentScenario<StartFragment>? = null

    @Before
    fun setUp() {
        setupFragment()
    }

    private fun setupFragment() {
        scenario = launchFragmentInContainer<StartFragment>()
    }

    @Test
    fun newGameButton() {
        scenario?.onFragment {
            assertNotNull(it.view?.findViewById<Button>(R.id.new_game))
        }
    }

    @Test
    fun continueButtonVisible_whenGameInProgress() {
        scenario?.onFragment {
            it.viewModel.inProgress.postValue(true)

            val continueButton = it.view?.findViewById<Button>(R.id.continue_game)
            assertThat(continueButton?.visibility, `is`(equalTo(View.VISIBLE)))
        }
    }

    @Test
    fun continueButtonGone_whenGameNotInProgress() {
        scenario?.onFragment {
            it.viewModel.inProgress.postValue(false)

            val continueButton = it.view?.findViewById<Button>(R.id.continue_game)
            assertThat(continueButton?.visibility, `is`(equalTo(View.GONE)))
        }
    }
}