package com.sdm.fifteen

import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class MainActivityTest {

    private var activity: MainActivity? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        activity = Robolectric.setupActivity(MainActivity::class.java)
    }

    @Test
    fun recyclerViewWithAdapter() {
        assertNotNull(activity?.recyclerView?.adapter)
    }

    @Test
    fun layoutManager() {
        assertNotNull(activity?.recyclerView?.layoutManager)
    }

}