package com.hasancsedu5gmail.jokemaker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONObject;

import stanford.androidlib.xml.XML;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String JOKE_URL = "https://api.icndb.com/jokes/random/";
    private static final String CAT_URL = "http://thecatapi.com/api/images/get?format=xml&results_per_page=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jokeClicked(View view) {

        Log.d(TAG,"joke Clicked is working");
        try{
            Ion.with(this)
                    .load(JOKE_URL)
                    .asString()
                    .setCallback(new FutureCallback<String>() {
                        @Override
                        public void onCompleted(Exception e, String result) {


                            processJokesData(result);

                        }
                    });

        }catch (Exception e){

            Log.e(TAG,e.toString());

        }

    }


//    {
//        "type": "success",
//            "value": {
//        "id": 491,
//                "joke": "Chuck Norris doesn't use reflection, reflection asks politely for his help.",
//                "categories": [
//        "nerdy"
//    ]
//    }
//    }
    private void processJokesData(String results) {

        try{


            JSONObject jsonObject = new JSONObject(results);

            JSONObject value = jsonObject.getJSONObject("value");
            String joke = value.getString("joke");

            JSONArray categories = value.getJSONArray("categories");
            String all_categories = "";
            int n = categories.length();
            for(int i=0;i<n;i++){

                if(i+1 == n){
                    all_categories+=categories.getString(i);
                }else{
                    all_categories+=categories.getString(i)+",";
                }
            }


            TextView tvJoke = (TextView)findViewById(R.id.text_jokes);
            tvJoke.setText(joke);

            TextView tvCat = (TextView) findViewById(R.id.text_category);
            tvCat.setText(all_categories);




        }catch (Exception e){

        }


        return;


    }

    public void catClick(View view) {

        Ion.with(this)
                .load(CAT_URL)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {

                        try{

                            JSONObject jsonObject = XML.toJSONObject(result);
                            processJesonCatImage(jsonObject);

                        }catch (Exception er){

                            Log.e(TAG,er.toString());
                        }
                    }
                });

    }

// <response>
//<data>
//<images>
//<image>
//<url>
//    http://25.media.tumblr.com/tumblr_m1w9pazU2g1qzex9io1_500.jpg
//</url>
//<id>5t9</id>
//<source_url>http://thecatapi.com/?id=5t9</source_url>
//</image>
//</images>
//</data>
//</response>
    private void processJesonCatImage(JSONObject jsonObject){


        try{

            Log.d(TAG,"image is being processed"+jsonObject);

            jsonObject = jsonObject.getJSONObject("response");
            jsonObject = jsonObject.getJSONObject("data");
            jsonObject = jsonObject.getJSONObject("images");
            jsonObject = jsonObject.getJSONObject("image");
            String url = jsonObject.getString("url");
            Log.d(TAG,url);

            ImageView imageView = (ImageView)findViewById(R.id.image_cat);

            Ion.with(imageView)
                    .placeholder(R.drawable.placeholder_image)
                    .error(R.drawable.error_image)
                    .load(url);


            Log.d(TAG,"End image Process");


        }catch (Exception e){


        }

    }



}
