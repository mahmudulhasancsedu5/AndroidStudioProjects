package com.hasancsedu5gmail.fragmentlandscapeportraitmodetest;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;


public class ListFragment extends Fragment {


    private static final String TAG = ListFragment.class.getSimpleName();

    private CommunicatorFragmentList communicator;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] itemString = getResources().getStringArray(R.array.item_name);
        List<String> itemList = Arrays.asList(itemString);

        ArrayAdapter<String> adapter = new ArrayAdapter(
                getActivity(),
                android.R.layout.simple_list_item_1,
                itemList
        );

        ListView lvItem = getActivity().findViewById(R.id.list_view_item);
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String name = adapterView.getItemAtPosition(i).toString();
                onItemSelection(name,i);
            }
        });
        lvItem.setAdapter(adapter);


    }

    private void onItemSelection(String itemName,int itemId){


        this.communicator.respond(itemId,itemName);

    }

    public void setCommunicatorFragmentList(CommunicatorFragmentList communicatorFragmentList){

        this.communicator = communicatorFragmentList;

    }

    public interface CommunicatorFragmentList{

        void respond(int i,String name);


    }
}
