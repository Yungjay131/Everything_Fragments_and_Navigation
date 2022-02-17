package com.slyworks.everything_fragments_and_navigation.book.chap_04;

/**
 * Created by Joshua Sylvanus, 8:26 PM, 2/3/2022.
 */
class Chap_04_Explanation {
    /*default preference file path is
    * /data/data/[PACKAGE_NAME]/shared_prefs/[PACKAGE_NAME]_preferences.xml*/

    /*setting default values (in onCreate())
    * PreferenceManager.setDefaultValues(this, R.xml.main, false
    *
    * using
    * String option = prefs.getString(
    *       resources.getString(R.string.flight_sort_option),
    *       null )*/

    /*note upgrading app DOES NOT clear SharedPreferences
    *
    * entries for ListPreference could be saved in /res/values/prefvaluearrays.xml
    * e.g
    * <!-- This file is /res/values/prefvaluearrays.xml -->
<resources>
*
<string-array name="flight_sort_options_values">
<item>0</item>
<item>1</item>
<item>2</item>
</string-array>
*
<string-array name="pizza_toppings_values">
<item>cheese</item>
<item>pepperoni</item>
<item>onion</item>
<item>mushroom</item>
<item>olive</item>
<item>ham</item>
<item>pineapple</item>
</string-array>
* ...
* </resources>*/

    /*ListPreference has findIndexOfValue()*/

    /*EditTextPreference*/

    /*MultiSelectListPreference with getStringSet()*/

    /*creating Child Preference with Dependency*/

    /*preference with HEADERs for larger screens???
    * public void onBuildHeaders(List<Header> target){
    *   loadHeadersFromResource(R.xml.preferences, target);
    * }
    *
    * <preference-headers
xmlns:android="http://schemas.android.com/apk/res/android">
<header android:fragment="com.example.PrefActivity$Prefs1Fragment"
android:icon="@drawable/ic_settings_sound"
android:title="Sound"
android:summary="Your sound preferences" />*/

    /*Each header tag points to a class that extends PreferenceFragment. In
the example just given, the XML specifies an icon, the title, and summary
text (which acts like a subtitle). Prefs1Fragment is an inner class of
PreferenceActivity that could look something like this:
public static class Prefs1Fragment extends PreferenceFragment {
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
addPreferencesFromResource(R.xml.sound_preferences);
}
}*/

    /*there is also onPreferenceChangeListener()
    * public boolean onPreferenceChange(Preference preference,
Object newValue) {
final String key = preference.getKey();
if ("package_name_preference".equals(key)) {
pkgPref.setSummary(newValue.toString());
}
...
return true;
}
*
* returning true indicates that the change can then be saved*/

    /*for other custo preference use DialogPreference*/
}
