package com.sdm.fifteen.view

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class WinDialog : DialogFragment() {

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(context!!)
                .setMessage("You win")
                .setPositiveButton(android.R.string.ok) { _: DialogInterface, _: Int -> }
                .create()
    }

    override fun onDismiss(dialog: DialogInterface) {
        listener?.onDismissWinDialog()
        super.onDismiss(dialog)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onDismissWinDialog()
    }
}