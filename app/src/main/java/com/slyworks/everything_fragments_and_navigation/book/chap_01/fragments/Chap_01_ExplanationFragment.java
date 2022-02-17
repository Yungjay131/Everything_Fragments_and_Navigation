package com.slyworks.everything_fragments_and_navigation.book.chap_01.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slyworks.everything_fragments_and_navigation.R;

public class Chap_01_ExplanationFragment extends Fragment {
    //region Vars
    //endregion
    public static Chap_01_ExplanationFragment newInstance(int index) {
        Chap_01_ExplanationFragment fragment = new Chap_01_ExplanationFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        fragment.setArguments(args);
        return fragment;
    }
    public Chap_01_ExplanationFragment() {/*required empty constructor*/ }

    /*there is also a saveFragmentState() of FragmentManager
     * returns an object with Fragment state
     * and can be used for a kind of re-initialisation in
     * setInitialSavedState() of Fragment*/

    /*communication between Fragments attached to an Activity*/
   /* OtherFragment fragment = (OtherFragment) getParentFragmentManager().findFragmentById("other");
    fragment.callCustomMethod(arg1,arg2);*/

    /*a Fragment can launch another Fragment and kind-of set itself as
    * the parent Fragment???
    * with the returned Fragment reference you could even call View components directly
    * and the called Fragment can also call getTargetFragment() and can even access its parent
    * fragment(this) View components directly
    * kind of a 2-way binding*/
    /*CalledFragment fragment = new CalledFragment();
    fragment.setTargetFragment(this, 0*//*O*//*)
    getFragmentManager.beginTransaction()
        .add(fragment, "work")
        .commit();*/

    /*child Fragment accessing creator fragment Views directly*/
    /*TextView tv = getTargetFragment().getView().findViewById(R.id.tvDetails_frag_details);
    tv.setText();*/

    /*1-onInflate()*/

    /*2-onAttach()*/
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
         /*remember there is a getActivity()*/
        /*replacement code for onActivityCreated() Fragment callback*/
        AppCompatActivity a = (AppCompatActivity) context;
        a.getLifecycle().addObserver(new LifecycleEventObserver() {
            @Override
            public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
                switch(event){
                    case  ON_CREATE:{}
                }
                switch (event.getTargetState()){
                    case CREATED:{}
                }

            }
        });

    }

    /*3-onCreate()*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*4-onCreateView()*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View view =  inflater.inflate(R.layout.fragment_chap_01_explanation, container, false);
        View view = super.onCreateView(inflater,container, savedInstanceState);
        initViews_1(view);
        return view;
    }

    private void initViews_1(View view){ }
    /*5-onViewCreated()*/
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    /*6-onActivityCreated()*/
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*view replacement code in onAttach()*/
    }

    /*7-onStart()*/
    @Override
    public void onStart() {
        super.onStart();
    }

    /*8-onResume()*/
    @Override
    public void onResume() {
        super.onResume();
        /*remember this is tied to the Activity's onResume()*/
    }

    /*9-onPause()*/
    @Override
    public void onPause() {
        super.onPause();
    }

    /*9a-onSaveInstanceState()*/
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        /*allows you to save certain details for Fragment reconstruction at a later time
        * the bundle saved here is used in onCreate()
        * save only what you need, dont go saving references to other Fragments
        * but you could save such Fragment's ID or Tag */
    }

    /*10-onStop()*/
    @Override
    public void onStop() {
        super.onStop();
    }

    /*11-onDestroyView()*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /*12-onDestroy()*/
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /*13-onDetach()*/
    @Override
    public void onDetach() {
        super.onDetach();
    }

}