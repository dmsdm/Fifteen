package com.sdm.fifteen

import android.view.View
import android.widget.Button
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
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
        FifteenStateHolder.inProgress = true

        setupFragment()

        scenario?.onFragment {
            val continueButton = it.view?.findViewById<Button>(R.id.continue_game)
            assertThat(continueButton?.visibility, `is`(equalTo(View.VISIBLE)))
        }
    }

    @Test
    fun continueButtonVisible_whenGameNotInProgress() {
        FifteenStateHolder.inProgress = false

        setupFragment()

        scenario?.onFragment {
            val continueButton = it.view?.findViewById<Button>(R.id.continue_game)
            assertThat(continueButton?.visibility, `is`(equalTo(View.GONE)))
        }
    }
}