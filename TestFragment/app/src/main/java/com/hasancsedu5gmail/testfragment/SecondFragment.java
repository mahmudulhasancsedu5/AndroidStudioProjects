package com.hasancsedu5gmail.testfragment;


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
public class SecondFragment extends Fragment {

    private String mText ="";

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();
        if(bundle != null) mText = bundle.getString("text");

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView tvDoc = getActivity().findViewById(R.id.text_view_2nd_frag_doc);
        tvDoc.setText(mText);


    }


    public void setMethod(String message){

        mText = message;
        TextView tvDoc = getActivity().findViewById(R.id.text_view_2nd_frag_doc);
        tvDoc.setText(mText);

    }
}
