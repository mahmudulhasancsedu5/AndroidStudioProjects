package com.hasancsedu5gmail.fragmenttestoneactivitylandscapevsportrait;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mahmud on 9/1/2017.
 */

public class DetailsFragment extends Fragment{

    private TextView mTVDetails;
    private TextView mTVWord;
    private String mItemName;
    private String mItemDetails;
    private int mIndex;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTVDetails = (TextView)getActivity().findViewById(R.id.text_view_details);
        mTVWord = (TextView)getActivity().findViewById(R.id.text_word);
    }

    public void setName(int index){

        Resources res = getResources();

        String[] names = res.getStringArray(R.array.namelist);
        String[] details = res.getStringArray(R.array.details);

        this.mItemName = names[index];
        this.mItemDetails = details[index];

        mTVWord.setText(this.mItemName);
        mTVDetails.setText(this.mItemDetails);



    }
}
