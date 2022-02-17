package com.slyworks.everything_fragments_and_navigation

import android.app.Application
import android.content.Context


/**
 *Created by Joshua Sylvanus, 9:01 PM, 2/4/2022.
 */
class App:Application() {
    companion object{
        //region Vars
        private lateinit var mContext:Context
        //endregion
        fun getContext(): Context {
            return mContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
    }
}