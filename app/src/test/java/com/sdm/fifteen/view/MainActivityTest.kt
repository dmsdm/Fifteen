package com.sdm.fifteen.view

import androidx.navigation.findNavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sdm.fifteen.R
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private var activity: MainActivity? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        activity = Robolectric.setupActivity(MainActivity::class.java)
    }


    @Test
    fun navigationHostFragment() {
        assertNotNull(activity?.findNavController(R.id.nav_host_fragment))
    }

}