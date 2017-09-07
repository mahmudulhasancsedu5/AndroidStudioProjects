package com.hasancsedu5gmail.fragmenttestwithmultipleactivity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mahmud on 9/1/2017.
 */

public class DetailsFragment extends Fragment {

    private static final String TAG = DetailsFragment.class.getSimpleName();
    private TextView mTVword;
    private TextView mTVdetails;
    private String mWord;
    private String mDetails;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(savedInstanceState != null){

            mWord = savedInstanceState.getString("word");
            mDetails = savedInstanceState.getString("details");

            mTVword.setText(mWord);
            mTVdetails.setText(mDetails);

        }

        mTVword = getActivity().findViewById(R.id.text_word);
        mTVdetails = getActivity().findViewById(R.id.text_details);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("word",mWord);
        outState.putString("details",mDetails);
    }

    public void setDetails(int index){
        try{

            String[] words = getResources().getStringArray(R.array.list_items);
            String[] details = getResources().getStringArray(R.array.details);

            mWord = words[index];
            mDetails = details[index];

            mTVword.setText(mWord);
            mTVdetails.setText(mDetails);


        }catch (Exception e){

            Log.e(TAG,e.toString());

        }


    }
}
