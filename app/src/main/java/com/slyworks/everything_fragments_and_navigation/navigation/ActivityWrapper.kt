package com.slyworks.everything_fragments_and_navigation.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.slyworks.everything_fragments_and_navigation.R
import com.slyworks.everything_fragments_and_navigation.isLastItem
import com.slyworks.everything_fragments_and_navigation.navigation.activities.*


/**
 *Created by Joshua Sylvanus, 5:14 AM, 2/6/2022.
 */
const val NOT_SET = 0
enum class ActivityWrapper{
    NAV_WELCOME{
      //region Vars
        private var mFragmentManager:FragmentManager? = null
        private var mFragmentList:MutableList<FragmentWrapper> = mutableListOf()
      //endregion

        override fun getInstance(): Class<*> {
            return Nav_WelcomeActivity::class.java
        }

        override fun setFragmentManager(fragmentManager: FragmentManager?) {
            mFragmentManager = fragmentManager
        }

        override fun getFragmentManager(): FragmentManager {
            return mFragmentManager!!
        }

        override fun getFragmentContainerID(): Int {
            return NOT_SET
        }

        override fun addFragment(fragment: FragmentWrapper) {
            mFragmentList.filter { it != fragment }
            mFragmentList.add(fragment)
        }

        override fun getNextFragment(): FragmentWrapper? {
            val f:FragmentWrapper? = mFragmentList.lastOrNull()
            if(f != null)
                mFragmentList.removeLast()

            return f
        }

        override fun isThereNextItem(): Boolean{
            return mFragmentList.isLastItem()
        }
    },
    NAV_LOGIN{
        //region Vars
        private var mFragmentManager:FragmentManager? = null
        private val mFragmentList:MutableList<FragmentWrapper> = mutableListOf()
        //endregion

        override fun getInstance(): Class<*> {
            return Nav_LoginActivity::class.java
        }

        override fun setFragmentManager(fragmentManager: FragmentManager?) {
            mFragmentManager = fragmentManager
        }

        override fun getFragmentManager(): FragmentManager {
            return mFragmentManager!!
        }

        override fun getFragmentContainerID(): Int {
            return NOT_SET
        }

        override fun addFragment(fragment: FragmentWrapper) {
            mFragmentList.filter { it != fragment }
            mFragmentList.add(fragment)
        }

        override fun getNextFragment(): FragmentWrapper? {
            val f:FragmentWrapper? = mFragmentList.lastOrNull()
            if(f != null)
                mFragmentList.removeLast()

            return f
        }

        override fun isThereNextItem(): Boolean {
            return mFragmentList.isLastItem()
        }
    },
    NAV_MAIN{
        //region Vars
        private var mFragmentManager: FragmentManager? = null
        private val mFragmentsList:MutableList<FragmentWrapper> = mutableListOf()
        //endregion

        override fun getInstance(): Class<out AppCompatActivity> {
            return Nav_MainActivity::class.java
        }

        override fun setFragmentManager(fragmentManager: FragmentManager?) {
            mFragmentManager = fragmentManager
        }

        override fun getFragmentManager(): FragmentManager {
            return mFragmentManager!!
        }

        override fun getFragmentContainerID(): Int {
            return R.id.fragment_container_main
        }

        override fun addFragment(fragment: FragmentWrapper) {
            mFragmentsList.filter { it != fragment }
            mFragmentsList.add(fragment)
        }

        override fun getNextFragment(): FragmentWrapper? {
            val f:FragmentWrapper? = mFragmentsList.lastOrNull();
            if(f != null)
                mFragmentsList.removeLast()

            return f
        }

        override fun isThereNextItem(): Boolean {
            return mFragmentsList.isLastItem()
        }
    },
    NAV_MESSAGE{
        //region Vars
        private var mFragmentManager:FragmentManager? = null
        private val mFragmentList:MutableList<FragmentWrapper> = mutableListOf()
        //endregion

        override fun getInstance(): Class<out AppCompatActivity> {
            return Nav_MessageActivity::class.java
        }

        override fun setFragmentManager(fragmentManager: FragmentManager?) {
            mFragmentManager = fragmentManager
        }

        override fun getFragmentManager(): FragmentManager {
            return mFragmentManager!!
        }

        override fun getFragmentContainerID(): Int {
            return NOT_SET
        }

        override fun addFragment(fragment: FragmentWrapper) {
            mFragmentList.filter{ it != fragment }
            mFragmentList.add(fragment)
        }

        override fun getNextFragment(): FragmentWrapper? {
            val f:FragmentWrapper? = mFragmentList.lastOrNull()
            if(f != null)
                mFragmentList.removeLast()

            return f
        }

        override fun isThereNextItem(): Boolean {
            return mFragmentList.isLastItem()
        }
    },
    NAV_VIDEO_CALL{
        //region Vars
        private var mFragmentManager:FragmentManager? = null
        private var mFragmentList:MutableList<FragmentWrapper> = mutableListOf()
        //endregion

        override fun getInstance(): Class<*> {
            return Nav_VideoCallActivity::class.java
        }

        override fun setFragmentManager(fragmentManager: FragmentManager?) {
            mFragmentManager = fragmentManager
        }

        override fun getFragmentManager(): FragmentManager {
           return mFragmentManager!!
        }

        override fun getFragmentContainerID(): Int {
            return NOT_SET
        }

        override fun addFragment(fragment: FragmentWrapper) {
            mFragmentList.filter { it != fragment }
            mFragmentList.add(fragment)
        }

        override fun getNextFragment(): FragmentWrapper? {
            val f:FragmentWrapper? = mFragmentList.lastOrNull()
            if(f != null)
                mFragmentList.removeLast()

            return f
        }

        override fun isThereNextItem(): Boolean {
            return mFragmentList.isLastItem()
        }
    };

    abstract fun getInstance(): Class<*>
    abstract fun setFragmentManager(fragmentManager: FragmentManager?)
    abstract fun getFragmentManager(): FragmentManager
    abstract fun getFragmentContainerID():Int
    abstract fun addFragment(fragment:FragmentWrapper)
    abstract fun getNextFragment():FragmentWrapper?
    abstract fun isThereNextItem():Boolean
}