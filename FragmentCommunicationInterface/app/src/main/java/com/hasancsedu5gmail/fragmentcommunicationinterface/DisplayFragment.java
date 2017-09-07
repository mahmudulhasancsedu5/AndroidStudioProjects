package com.hasancsedu5gmail.fragmentcommunicationinterface;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DisplayFragment extends Fragment{

    String mData;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_display,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(savedInstanceState == null){

            this.mData = "DisplayFragment";
        }else{

            this.mData = savedInstanceState.getString("data");
            TextView tvDisplay = getActivity().findViewById(R.id.text_view_display);
            tvDisplay.setText(this.mData);


        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("data",mData);
    }

    public void changeDisplayText(String data){

        this.mData = data;
        TextView tvDisplay = getActivity().findViewById(R.id.text_view_display);
        tvDisplay.setText(this.mData);
    }
}
