package com.hasancsedu5gmail.fragmentcommunicationinterface;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by mahmud on 9/1/2017.
 */

public class ButtonFragment extends Fragment {

    private ConnectorInterface mConn;
    public static int sCountClick = 0;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null){

            sCountClick = 0;
        }else{

            sCountClick = savedInstanceState.getInt("sCountClick",0);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mConn = (ConnectorInterface)activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_button,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button btn = getActivity().findViewById(R.id.button_fragment_button);

        btn.setOnClickListener(new MyButtonListener(mConn));

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("sCountClick",sCountClick);
    }




}


class MyButtonListener implements View.OnClickListener{

    private ConnectorInterface connectorInterface;
    public MyButtonListener(ConnectorInterface conn){

        this.connectorInterface = conn;
    }

    @Override
    public void onClick(View view) {

        connectorInterface.clickProcessing("Button clicked "+ButtonFragment.sCountClick+" times.");

        ButtonFragment.sCountClick++;

    }
}