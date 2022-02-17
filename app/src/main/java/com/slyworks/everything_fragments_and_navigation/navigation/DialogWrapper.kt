package com.slyworks.everything_fragments_and_navigation.navigation

import androidx.fragment.app.DialogFragment
import com.slyworks.everything_fragments_and_navigation.navigation.dialogs.ExitDialog

/**
 *Created by Joshua Sylvanus, 5:34 PM, 1/27/2022.
 */

enum class DialogWrapper{
    EXIT{
        override fun getInstance(): DialogFragment {
            return ExitDialog()
        }
    };
    abstract fun getInstance(): DialogFragment
}