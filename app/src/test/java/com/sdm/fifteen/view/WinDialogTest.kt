package com.sdm.fifteen.view

import android.content.Context
import android.content.DialogInterface
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class WinDialogTest {

    private var scenario: FragmentScenario<WinDialog>? = null
    private var listener: Context? = null

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer<WinDialog>()

        listener = Mockito.mock(Context::class.java, Mockito.withSettings().extraInterfaces(WinDialog.OnFragmentInteractionListener::class.java))
    }

    @Test
    fun onFragmentInteraction_whenDismissed() {
        scenario?.onFragment {
            it.onAttach(listener!!)
            it.onDismiss(Mockito.mock(DialogInterface::class.java))

            Mockito.verify(listener as WinDialog.OnFragmentInteractionListener).onDismissWinDialog()
        }
    }
}