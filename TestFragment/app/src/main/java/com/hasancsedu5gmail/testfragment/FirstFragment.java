package com.hasancsedu5gmail.testfragment;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FirstFragment extends Fragment {

    CommunicatorFirstFragment communicatorInterface;
    private int mCount = 1;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            this.communicatorInterface = (CommunicatorFirstFragment) activity;
        }catch (ClassCastException e){

            throw new ClassCastException(activity.toString()+" need to implement CommunicatorFirstFragmen Interface");
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button btnChangeDocument  = getActivity().findViewById(R.id.button_on_click_change_doc);
        btnChangeDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = mCount+" = Fragment First is changing Fragment Main Document.";
                mCount++;
                communicatorInterface.respondFragmentFirst(1,text);

            }
        });

        Button btnChangeFragment2 = getActivity().findViewById(R.id.button_on_click_change_frag_2_doc);
        btnChangeFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = mCount+" Fragment First is changing Fragment 2nd's Document.";
                mCount++;
                communicatorInterface.respondFragmentFirst(2,text);
            }
        });

    }

    public interface CommunicatorFirstFragment{

        void respondFragmentFirst(int i,String passData);


    }

}
