package com.slyworks.everything_fragments_and_navigation.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.slyworks.everything_fragments_and_navigation.R
class Nav_HomeFragment : Fragment() {
    //region Vars
    //endregion

    companion object {
        @JvmStatic
        fun newInstance():Nav_HomeFragment{
            return Nav_HomeFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_nav_home, container, false)
    }


}