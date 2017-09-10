package com.hasancsedu5gmail.gameofthronesbio;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CastDetailsFragment extends Fragment{

    private static final String TAG = CastDetailsFragment.class.getSimpleName();

    private String mURL_first = "https://api.themoviedb.org/3/person/";
    private String mURL_last = "?api_key=4bc1427186392792f2410dcb78226e1f&language=en-US";
    private String mPersoneId;

    LinearLayout linearLayoutFragmentDetails;


    public CastDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cast_details, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mPersoneId  = CastDetailsActivity.getId();
//        TextView textView = getActivity().findViewById(R.id.text_view_cast_name);
//        textView.setText("id : "+mPersoneId);
        downloadPersonDetails(mPersoneId);



    }

    private void downloadPersonDetails(String personeId){

        final String personURL = mURL_first+personeId+mURL_last;
        Log.v(TAG,personURL);

        Ion.with(this)
                .load(personURL)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {

                        Log.v(TAG,result);
                        processData(result);



                    }
                });

    }

//    {
//        "birthday": "1978-06-19",
//            "deathday": null,
//            "id": 8691,
//            "name": "Zoe Saldana",
//            "also_known_as": [
//                "Zoë Saldana",
//                "Zoe Saldaña",
//                "Zoë Saldaña"
//                  ],
//        "gender": 1,
//            "biography": "Zoë Yadira Saldana was born June 19, 1978 in Passaic NJ
//                          to a Puerto Rican mother and Dominican father. Her family relocated to
//                          the Dominican Republic when she was ten years old. There she practiced ballet
//                          at one of the most prestigious dance schools in the country. Saldana returned to
//                          New York at age 17, where she began involving herself in theatre groups such as
//                          Faces and the New York Youth Theatre. Her ballet training helped land her first on
//                          screen part as Eva in the dance film, Center Stage (2000). The actress’ career
//                          continued to flourish with roles in Pirates of The Caribbean: The Curse of the
//                          Black Pearl (2003) with Johnny Depp, The Terminal (2004) starring Tom Hanks, and
//                          Guess Who (2005) opposite Ashton Kutcher. Saldana continues to act and model with
//                          editorial features in Elle, Vanity Fair, V, GQ Italia, and Nylon.",
//            "popularity": 10.456217,
//            "place_of_birth": "Passaic, New Jersey, USA",
//            "profile_path": "/ofNrWiA2KDdqiNxFTLp51HcXUlp.jpg",
//            "adult": false,
//            "imdb_id": "nm0757855",
//            "homepage": "http://www.zoesaldana.com/"
//    }

    private void processData(String jsonStr){



        try {
            JSONObject castDetailsJSONObject = new JSONObject(jsonStr);
            String name = castDetailsJSONObject.getString("name");
            String biography = castDetailsJSONObject.getString("biography");
            String imagePath = castDetailsJSONObject.getString("profile_path");

            addImageToView(imagePath);

            TextView tvName = getActivity().findViewById(R.id.text_view_cast_name);
            tvName.setText(name);

            TextView tvBio = getActivity().findViewById(R.id.text_view_cast_bio);
            tvBio.setText(biography);

            List<String> listCastInfo = new ArrayList<>();

            String birthDay = castDetailsJSONObject.getString("birthday");
            listCastInfo.add("Birth Day : "+birthDay+"\n");


            String popularity = ""+castDetailsJSONObject.getDouble("popularity");
            listCastInfo.add("Popularity : "+popularity+"\n");
            Log.d(TAG,"Popularity : "+popularity);

            String placeOfBirth = castDetailsJSONObject.getString("place_of_birth");
            listCastInfo.add("Place Of Birth : "+placeOfBirth+"\n");

            String homePage = castDetailsJSONObject.getString("homepage");
            listCastInfo.add("Home Page : "+homePage+"\n");


            Log.d(TAG,"List size : " +listCastInfo.size());



            ListView listView = getActivity().findViewById(R.id.list_cast_info);


            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    getActivity(),
                    android.R.layout.simple_list_item_1,
                    listCastInfo
            );
            listView.setAdapter(adapter);

           
            //------------make list view full size
            ViewGroup.LayoutParams params = listView.getLayoutParams();
//            params.height = listView.getHeight() + (listView.getDividerHeight() * (adapter.getCount() - 1));
            params.height = 350;
            listView.setLayoutParams(params);
            listView.requestLayout();

//            View header = getActivity().getLayoutInflater().inflate(R.layout.header, null);
//            View footer = getActivity().getLayoutInflater().inflate(R.layout.footer, null);
//            listView.addHeaderView(header);
//            listView.addFooterView(footer);







        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void addName(){


    }
    private void addImageToView(String imagePath) {
        ImageView ivCast = getActivity().findViewById(R.id.image_view_cast_image);
        String imageURL = "https://image.tmdb.org/t/p/w500/" + imagePath;
        loadAddImageView(imageURL, ivCast);
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
