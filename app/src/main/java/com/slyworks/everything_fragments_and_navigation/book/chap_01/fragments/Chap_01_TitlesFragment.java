package com.slyworks.everything_fragments_and_navigation.book.chap_01.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.slyworks.everything_fragments_and_navigation.book.chap_01.Shakespeare;
import com.slyworks.everything_fragments_and_navigation.book.chap_01.activities.Chap_01_MainActivity;

public class Chap_01_TitlesFragment extends ListFragment {
    //region Vars
    private ListView lvTitles;
    private Chap_01_MainActivity mActivity;

    private int mCurrentCheckPosition = 0;
    //endregion
    public static Chap_01_TitlesFragment newInstance() {
        Chap_01_TitlesFragment fragment = new Chap_01_TitlesFragment();
        return fragment;
    }

    public Chap_01_TitlesFragment() { /*Required empty public constructor*/ }

    @Override
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attrs, @Nullable Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        this.mActivity = (Chap_01_MainActivity) context;
        mActivity.getLifecycle().addObserver(new LifecycleEventObserver() {
            @Override
            public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
                switch(event.getTargetState()){
                    case CREATED:{
                        initViews_3();
                    }
                }
            }
        });

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            /*restore last state for checked position???*/
            mCurrentCheckPosition = savedInstanceState.getInt("current_choice",0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        initViews_1(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews_2(view);
    }

    private void initViews_1(View view){}
    private void initViews_2(View view){}
    private void initViews_3(){
        /*populate list with static array of titles*/
        ListAdapter adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                Shakespeare.TITLES);
        setListAdapter(adapter);
        lvTitles.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lvTitles.setSelection(mCurrentCheckPosition);

        mActivity.showDetails(mCurrentCheckPosition);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        mActivity.showDetails(position);
        mCurrentCheckPosition = position;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("current_choice", mCurrentCheckPosition);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }
}