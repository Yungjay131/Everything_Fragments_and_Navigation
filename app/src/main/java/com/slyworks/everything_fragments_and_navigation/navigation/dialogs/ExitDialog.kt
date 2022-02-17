package com.slyworks.everything_fragments_and_navigation.navigation.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.slyworks.everything_fragments_and_navigation.R
import kotlin.system.exitProcess


/**
 *Created by Joshua Sylvanus, 9:11 PM, 2/7/2022.
 */
class ExitDialog : DialogFragment() {
    //region Vars
    private lateinit var btnCancel:Button
    private lateinit var btnExit:Button
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_exit, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view:View){
        btnCancel = view.findViewById(R.id.btnCancel_dialog_exit)
        btnExit = view.findViewById(R.id.btnExit_dialog_exit)

        btnCancel.setOnClickListener { dismiss() }
        btnExit.setOnClickListener { exitProcess(0) }
    }
}