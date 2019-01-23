package com.sdm.fifteen.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
import com.sdm.fifteen.FifteenStateHolder
import com.sdm.fifteen.FifteenStateSaver
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class StartViewModel(application: Application, test: Any? = null) : AndroidViewModel(application) {

    val inProgress: MediatorLiveData<Boolean> = MediatorLiveData()

    constructor(application: Application) : this(application, null) {
        GlobalScope.launch {
            val preferences = application.getSharedPreferences("state", Context.MODE_PRIVATE)
            FifteenStateSaver.loadState(preferences)
            inProgress.postValue(FifteenStateHolder.inProgress)
        }
    }

}