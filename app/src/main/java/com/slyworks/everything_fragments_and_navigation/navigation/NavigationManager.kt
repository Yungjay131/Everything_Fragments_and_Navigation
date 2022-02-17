package com.slyworks.everything_fragments_and_navigation.navigation

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.slyworks.everything_fragments_and_navigation.App
import com.slyworks.everything_fragments_and_navigation.isLastItem

/**
 *Created by Joshua Sylvanus, 5:34 PM, 1/27/2022.
 */

object NavigationManager {
    //region Vars
    private var mNavigationItemList:MutableList<ActivityWrapper> = mutableListOf()
    //endregion

    fun onBackPressed(){
        val activity:ActivityWrapper = mNavigationItemList.last()
        val status:Boolean = isThereNextFragment(activity)

        if(status)
            inflateNextFragment(activity)
        else {
            if (mNavigationItemList.isLastItem()){
                inflateDialog(DialogWrapper.EXIT)
                return
            }

            removeFromBackStack(activity)
            inflateActivity(mNavigationItemList.last())
        }
    }

    fun display(item:ActivityWrapper, removeCurrentFromBackStack:Boolean = false){
        inflateActivity(item)

        /*for cases like Login screen*/
        if(removeCurrentFromBackStack)
            removeLastFromBackStack()

        addToBackStack(item)
    }

    private fun inflateActivity(activity: ActivityWrapper){
        val intent: Intent = Intent(App.getContext(), activity.getInstance())
        App.getContext().startActivity(intent)
    }

    private fun addToBackStack(item:ActivityWrapper){
        mNavigationItemList.filter { it != item}
        mNavigationItemList.add(item)
    }

    private fun removeLastFromBackStack(){
        mNavigationItemList.removeLast()
    }

    private fun removeFromBackStack(item:ActivityWrapper){
        if(mNavigationItemList.isLastItem()) {
            inflateDialog(DialogWrapper.EXIT)
            return
        }

        mNavigationItemList.removeLast()
    }

    private fun inflateDialog(item:DialogWrapper){
        val currentActivity:ActivityWrapper? = mNavigationItemList.lastOrNull()
        require(currentActivity != null){"current activity cannot be null, required for inflating Exit Dialog"}

        item.getInstance()
            .show(currentActivity.getFragmentManager(), "EXIT_DIALOG")
    }

   fun displayFragment(item:FragmentWrapper){
        mNavigationItemList.last().addFragment(item)
        inflateNextFragment(mNavigationItemList.last())
    }

    private fun inflateNextFragment(activity: ActivityWrapper){
        val f:Fragment = activity.getNextFragment()?.getInstance()!!

        val transaction:FragmentTransaction = activity.getFragmentManager().beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)

        if(f.isAdded) transaction.show(f)
        else transaction.replace(activity.getFragmentContainerID(), f)

        transaction.commit()
    }

    private fun isThereNextFragment(activity:ActivityWrapper):Boolean{
        return activity.isThereNextItem()
    }
}