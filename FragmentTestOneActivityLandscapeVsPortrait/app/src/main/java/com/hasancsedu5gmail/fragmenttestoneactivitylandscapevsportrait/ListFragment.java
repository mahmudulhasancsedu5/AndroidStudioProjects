package com.hasancsedu5gmail.fragmenttestoneactivitylandscapevsportrait;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by mahmud on 9/1/2017.
 */

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener{

    private static String TAG = "ListFragment";
    Communicator conn;
    private ListView mList;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_list,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        conn = (Communicator) getActivity();
        if(conn == null){

            Log.d(TAG,"onActivityCreated conn is null");
        }else{

            Log.d(TAG,"onActivityCreated conn is not null");
        }

        mList = getActivity().findViewById(R.id.list_items);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                getActivity(),
                R.array.namelist,
                android.R.layout.simple_list_item_1);

        mList.setAdapter(adapter);

        mList.setOnItemClickListener(this);


    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


        try {
            conn.passMessage(i);

        }catch (Exception e){

            Log.e(TAG,e.toString());
        }


    }
}
