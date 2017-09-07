package com.hasancsedu5gmail.translationapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TranslationActivity extends AppCompatActivity {

    private static final String TAG = TranslationActivity.class.getSimpleName();
    private static final String API_URL = "http://newjustin.com/translateit.php?action=translations&english_words=";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation);
    }

    public void onClickTranslateText(View view) {

        doTranslation();
    }


    private void doTranslation(){

        String translate_text = getText();
        translate_text = textCleaning(translate_text);

        Log.d(TAG,translate_text);

        Ion.with(this)
                .load(API_URL+translate_text)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {

                        Log.d(TAG,result);
                        String res = processData(result);
                        addToScreen(res);


                    }
                });



    }

    private String getText(){

        EditText editText = (EditText)findViewById(R.id.text_input);
        return editText.getText().toString();
    }

    private String textCleaning(String res){

        String cleanedText= "";
        res = res.trim();
        int len = res.length();
        for(int i=0;i<len;i++){

            char ch = res.charAt(i);
            if((ch>='A' && ch<='Z')||(ch>='a' && ch<='z')){

                cleanedText+=ch;

            }else{
                cleanedText+="+";
            }

        }

        return cleanedText;
    }

    private String processData(String result){

        String trans_res="";
        try{

            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("translations");
            int len = jsonArray.length();


            for(int i=0;i<len;i++){

                jsonObject = jsonArray.getJSONObject(i);
                String key = jsonObject.keys().next().toString();
                String value = jsonObject.getString(key);
                trans_res+=key+" : "+value+"\n";
            }

        }catch (JSONException err){

            Log.e(TAG,err.toString());

        }

        return trans_res;

    }

    private void addToScreen(String result){

        TextView textView = (TextView)findViewById(R.id.text_result);
        textView.setText(result);
    }
}
