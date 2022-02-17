package com.slyworks.everything_fragments_and_navigation.book.chap_02;

/**
 * Created by Joshua Sylvanus, 4:56 PM, 2/2/2022.
 */
class Chap_02_Explanation {
    /*Configuration Changes
    configuration changes is not just screen rotation but also things like changing
    region, language etc
    * 3 callbacks to be aware of when dealing with default configuration changes
    1:onSaveInstanceState()
    2:onCreate()
    3:onRestoreInstanceState()

    1:onSaveInstanceState()
    is called when the device detects a configuration change is happening
    the Activity in use has a chance to save state that its interested in restoring
    its called before onStop(), the bundle saved that has state is passed to both
    onCreate() and onRestoreInstanceState()
    super.onSaveInstanceState() will be default handle things like EditText text*/
    /*
    * @Override
public void onSaveInstanceState(Bundle icicle) {
super.onSaveInstanceState(icicle);
icicle.putInt("counter", 1);
}*/

    /*
    *@Override
public void onRestoreInstanceState(Bundle icicle) {
super.onRestoreInstanceState(icicle);
int someInt = icicle.getInt("counter", -1);
// Now go do something with someInt to restore the
// state of the activity. -1 is the default if no
// value was found.
} */

    /*restoring state could be done in onRestoreInstanceState()
    * allows for a BaseActivity to be used so all you have to do is override
    * onRestoreInstanceState() in the extending Activity
    *
    * NB:do not put anything with reference back to the Activity here in
    * the bundle as this could cause a MEMORY LEAK
    * Drawables
    * Adapters
    * Views and anything tied to the Activity Context(such references would prevent
    * them from being Garbage Collected)
    * instead of putting a Drawable, serialize a Bitmap and put that
    * and later use the Bitmap reference to regenerate the Drawable???*/

    /*for a Fragment
    * 6 Callbacks receive Bundle containing state info
    * 1:onInflate()
    * 2:onCreate()
    * 3:onCreateView()
    * 4:onActivityCreated()
    * 5:onViewCreated()
    * 6:onViewStateRestored()
    *
    * for Fragments its guaranteed onSaveInstanceState(), would be called
    * sometime before onDestroy() and as such the View may or may not be attached
    * so check is the View is still there before saving View-related things in the bundle*/

    /*FragmentManager has saveFragmentInstanceState() and returns Fragment.savedState
    * setInitialSavedState() gets passed this Fragment.savedState???
    *
    * setRetainState(true) makes the Fragment no to be destroyed, its retained in the aplication
    * when its Activity is being destroyed and re-created */

    /*for an Activity you can handle Configuration by yourself
    * by specifying it in the Manifest the configuration changes you would handle
    * yourself
    * android:configChanges="orientation|screenSize|keyboardHidden"
    *
    * and the process changes, here the callback called is onConfigurationChanged()
    * for the Activity and its Fragment */
}
