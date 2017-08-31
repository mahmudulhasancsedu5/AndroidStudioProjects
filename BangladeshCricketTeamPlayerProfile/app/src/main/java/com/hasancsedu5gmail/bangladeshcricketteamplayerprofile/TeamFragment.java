package com.hasancsedu5gmail.bangladeshcricketteamplayerprofile;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;


public class TeamFragment extends Fragment {

    private GridLayout mGridLayout;


    public TeamFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


//        View view = inflater.inflate(R.layout.fragment_team,container,false);
//        Button btnTest = (Button)view.findViewById(R.id.button_test);
//        btnTest.setText("From TeamFragment");


        View view = inflater.inflate(R.layout.fragment_team,container,false);


        mGridLayout = (GridLayout)view.findViewById(R.id.layout_fragment_grid_team);






        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //set up the event listner




    }
}
