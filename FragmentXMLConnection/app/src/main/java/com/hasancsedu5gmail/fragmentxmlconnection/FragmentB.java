package com.hasancsedu5gmail.fragmentxmlconnection;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mahmud on 8/31/2017.
 */

public class FragmentB extends Fragment {


    

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_b_fragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button button =(Button)getActivity().findViewById(R.id.button_fragment_b_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = (TextView) getActivity().findViewById(R.id.text_fragment_a);
                tv.setText("Text Changed by Fragment B");
            }
        });
    }




}

class MyOnClick implements View.OnClickListener{


    public MyOnClick(String data){


    }
    @Override
    public void onClick(View view) {



    }
}

