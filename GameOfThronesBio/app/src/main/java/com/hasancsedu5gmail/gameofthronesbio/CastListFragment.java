package com.hasancsedu5gmail.gameofthronesbio;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class CastListFragment extends Fragment {


    private static final int MAX_PAGE_NUM = 10;
    private static String URL_PEOPLE =
            "https://api.themoviedb.org/3/person/popular?api_key=4bc1427186392792f2410dcb78226e1f&language=en-US";
    private static final String API_KEY = "api_key=4bc1427186392792f2410dcb78226e1f";
//    private static String mImageURL = "https://image.tmdb.org/t/p/w300/";

    private static final String TAG =CastListFragment.class.getSimpleName();

    Fragment fragmentCastList;
    LinearLayout linearLayoutFragmentCastList;



    public CastListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflateFragment = inflater.inflate(R.layout.fragment_cast_list, container, false);
        linearLayoutFragmentCastList = inflateFragment.findViewById(R.id.layout_fragment_cast_list);
        doFragmentWork();


        // Inflate the layout for this fragment
        return inflateFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }


    private void doFragmentWork(){

//        fragmentCastList = getActivity().getFragmentManager().findFragmentById(R.id.fragment_cast_list_id);
//        linearLayoutFragmentCastList = getActivity().findViewById(R.id.layout_fragment_cast_list);

        if(linearLayoutFragmentCastList == null){

            Log.v(TAG,"Fragment layout is not created yet.");
        }else{

            Log.v(TAG,"Fragment layout created.");
        }

//        String peopleData = getDataFromWeb();

        for(int i=1;i<MAX_PAGE_NUM;i++){

            getDataFromWeb(i);
        }


    }


    private String getDataFromWeb(int page_no){

        String res = "";



        try {
            Ion.with(this)
                    .load(URL_PEOPLE+"&page="+page_no)
                    .asString()
                    .setCallback(new FutureCallback<String>() {
                        @Override
                        public void onCompleted(Exception e, String result) {

                                processJSONData(result);

                        }
                    });

        }catch (Exception ee){

            Log.e(TAG,ee.toString());

        }




        return res;
    }

    private void processJSONData(String result){

        try{
            JSONObject castListJSONObject = new JSONObject(result);

            int total_results = castListJSONObject.getInt("total_results");

            Log.v(TAG,"Total Results People Profile is : "+total_results);

            JSONArray castJSONArray = castListJSONObject.getJSONArray("results");

            int len = castJSONArray.length();
            for(int i=0;i<len;i++){

                JSONObject jsonObject = castJSONArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String profilePicName = jsonObject.getString("profile_path");
                int person_id = jsonObject.getInt("id");
                Log.v(TAG,name);
                addCastProfile(person_id,name,profilePicName);




            }


        } catch (Exception e) {

            Log.e(TAG,e.toString());
        }



    }

    public void addCastProfile(int person_id,String name,String profilePicName){

        try {

            //View view = getLayoutInflater().inflate(R.layout.profile,null);
            View castProfileView = getActivity().getLayoutInflater().inflate(R.layout.profile,null);


            TextView tvCastName = castProfileView.findViewById(R.id.text_name);
            tvCastName.setText(name);

            TextView tvPersonID = castProfileView.findViewById(R.id.text_view_id);
            tvPersonID.setText(""+person_id);

            String image_url = "https://image.tmdb.org/t/p/w500/" + profilePicName;
            Log.v(TAG,image_url);

            //---------image button---------
//            ImageButton castImageButton = castProfileView.findViewById(R.id.image_button_cast_image);
//            loadAddImage(image_url,castImageButton);


            //-----------image view

            ImageView castImageView = castProfileView.findViewById(R.id.image_view_cast_image_pro);
            loadAddImageView(image_url,castImageView);



            linearLayoutFragmentCastList.addView(castProfileView);


        }catch (Exception e)
        {
            Log.e(TAG,e.toString());
        }

    }

    private void loadAddImage(String imageUrl,ImageButton imageButton){

//        Ion.with(context)
//                .load("http://example.com/image.png")
//                .withBitmap()
//                .placeholder(R.drawable.placeholder_image)
//                .error(R.drawable.error_image)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)
//                .intoImageView(imageView);


        Ion.with(getActivity())
                .load(imageUrl)
                .withBitmap()
                .resize(300,400)
                .intoImageView(imageButton);


    }

    private void loadAddImageView(String imageUrl,ImageView imageView){

//        Ion.with(context)
//                .load("http://example.com/image.png")
//                .withBitmap()
//                .placeholder(R.drawable.placeholder_image)
//                .error(R.drawable.error_image)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)
//                .intoImageView(imageView);


        Ion.with(getActivity())
                .load(imageUrl)
                .withBitmap()
                .resize(300,400)
                .intoImageView(imageView);


    }


}
