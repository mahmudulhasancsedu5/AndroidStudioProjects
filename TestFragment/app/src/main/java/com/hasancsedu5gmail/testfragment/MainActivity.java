package com.hasancsedu5gmail.testfragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FirstFragment.CommunicatorFirstFragment{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respondFragmentFirst(int i,String passData) {

        if(i == 1){
            doChangeMainActivityDoc(passData);
        }else{
//            Log.d("Frag 2 called with ",passData);
            doChangeSecondFragmentDoc(passData);
        }

    }

    private void doChangeMainActivityDoc(String passData){
        TextView tvMainDoc = (TextView) findViewById(R.id.text_view_main_activity_doc);
        tvMainDoc.setText(passData);

    }

    private void doChangeSecondFragmentDoc(String passData){

//        TextView tvMainDoc = (TextView) findViewById(R.id.text_view_2nd_frag_doc);
//        tvMainDoc.setText(passData);

        SecondFragment second = (SecondFragment) getFragmentManager().findFragmentById(R.id.fragment_second_id);

        if(second != null ){

            second.setMethod(passData);

        }else{

            SecondFragment secondFragment = new SecondFragment();
            Bundle bundle = new Bundle();
            bundle.putString("text",passData);
            secondFragment.setArguments(bundle);

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_second_id,secondFragment);
//            transaction.addToBackStack(null);
            transaction.commit();

        }




    }
}
