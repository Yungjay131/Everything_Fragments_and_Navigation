package com.slyworks.everything_fragments_and_navigation.book.chap_01.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.slyworks.everything_fragments_and_navigation.R;
import com.slyworks.everything_fragments_and_navigation.book.chap_01.Shakespeare;

public class Chap_01_DetailsFragment extends Fragment {
    //region Vars
    private static final String TAG = Chap_01_DetailsFragment.class.getSimpleName();

    private TextView tvText;
    private int mIndex = 0;
    //endregion

    public static Chap_01_DetailsFragment newInstance(Bundle bundle){
        int index = bundle.getInt("index", 0);
        return newInstance(index);
    }

    public Chap_01_DetailsFragment() { /* Required empty public constructor */ }

    public static Chap_01_DetailsFragment newInstance(int index) {
        Chap_01_DetailsFragment fragment = new Chap_01_DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index",index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
       //super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: in Chap_01_DetailsFragment onCreate(), savedInstanceState Bundle contains" );

        if(savedInstanceState == null)
            Log.e(TAG, "onCreate: saveInstanceState Bundle is null");
        else {
            Log.e(TAG, "onCreate: saveInstanceState Bundle exists");

            for(String key: savedInstanceState.keySet())
                Log.e(TAG, "onCreate: savedInstanceState Bundle "+ key);

        }

        super.onCreate(savedInstanceState);
        mIndex = getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_chap_01_details, container, false);
        initViews_1(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews_2(view);
    }

    private void initViews_1(View view){
        tvText = view.findViewById(R.id.tvDetails_frag_details);
    }

    private void initViews_2(View view){
        tvText.setText(Shakespeare.DIALOGUE[ mIndex ]);
    }

    public int getShownIndex(){ return mIndex; }
}