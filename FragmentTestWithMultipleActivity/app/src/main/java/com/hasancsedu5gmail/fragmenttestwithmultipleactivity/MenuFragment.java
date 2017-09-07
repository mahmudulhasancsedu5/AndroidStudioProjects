package com.hasancsedu5gmail.fragmenttestwithmultipleactivity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by mahmud on 9/1/2017.
 */

public class MenuFragment extends Fragment implements AdapterView.OnItemClickListener{

    private static final String TAG = MenuFragment.class.getSimpleName();
    private ConnectorMenu connectorMenu;
    private ListView lv_menu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_menu,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        try{

            ArrayAdapter adapterMenu = ArrayAdapter.createFromResource(
                    getActivity(),
                    R.array.list_items,
                    android.R.layout.simple_list_item_1
            );

            lv_menu = (ListView) getActivity().findViewById(R.id.list_menu);
            lv_menu.setAdapter(adapterMenu);
            lv_menu.setOnItemClickListener(this);

        }catch (Exception e){

            Log.e(TAG,e.toString());

        }




    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    try {
        connectorMenu.getMenuData(i);

    }catch (NullPointerException e){

        Log.e(TAG,"Connector is null\n");

    }


    }

    public void setConnectorMenu(ConnectorMenu cc){

        connectorMenu = cc;

    }

    public interface ConnectorMenu{

        void getMenuData(int index);

    }
}


