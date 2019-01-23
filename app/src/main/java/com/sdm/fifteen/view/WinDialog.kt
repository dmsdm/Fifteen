package com.sdm.fifteen.view

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class WinDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(context!!)
                .setMessage("You win")
                .setPositiveButton(android.R.string.ok) { _: DialogInterface, _: Int -> }
                .create()
    }
}