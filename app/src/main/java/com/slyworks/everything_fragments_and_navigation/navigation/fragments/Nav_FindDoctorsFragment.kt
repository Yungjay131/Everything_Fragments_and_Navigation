package com.slyworks.everything_fragments_and_navigation.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slyworks.everything_fragments_and_navigation.R

class Nav_FindDoctorsFragment : Fragment() {
    //region Vars
    //endregion

    companion object {
        @JvmStatic
        fun newInstance():Nav_FindDoctorsFragment{
            return Nav_FindDoctorsFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_nav_find_doctors, container, false)
        return view
    }


}