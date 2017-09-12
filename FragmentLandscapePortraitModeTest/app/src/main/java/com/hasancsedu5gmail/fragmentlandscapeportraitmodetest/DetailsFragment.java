package com.hasancsedu5gmail.fragmentlandscapeportraitmodetest;


import android.app.Fragment;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    private int mItemId=0;
    private String mItemName="";

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


//        DetailsFragment details= (DetailsFragment)getActivity().getFragmentManager().findFragmentById(R.id.fragment_details);

    }

    public void setData(int itemId,String itemName){

        String[] detailsList = getResources().getStringArray(R.array.item_details);

        TextView tvDetails = getActivity().findViewById(R.id.text_view_details);

        tvDetails.setText(detailsList[itemId].toString());
    }


}
