package com.slyworks.everything_fragments_and_navigation.navigation

import androidx.fragment.app.Fragment
import com.slyworks.everything_fragments_and_navigation.navigation.fragments.Nav_ChatHostFragment
import com.slyworks.everything_fragments_and_navigation.navigation.fragments.Nav_FindDoctorsFragment
import com.slyworks.everything_fragments_and_navigation.navigation.fragments.Nav_HomeFragment

/**
 *Created by Joshua Sylvanus, 5:34 PM, 1/27/2022.
 */
enum class FragmentWrapper{
    HOME{
        override fun getInstance(): Fragment {
            return Nav_HomeFragment.newInstance()
        }
    },
    FIND_DOCTORS{
        override fun getInstance(): Fragment {
            return Nav_FindDoctorsFragment.newInstance()
        }
    },
    CHAT_HOST{
        override fun getInstance(): Fragment {
            return Nav_ChatHostFragment.newInstance()
        }
    };

    abstract fun getInstance(): Fragment
}