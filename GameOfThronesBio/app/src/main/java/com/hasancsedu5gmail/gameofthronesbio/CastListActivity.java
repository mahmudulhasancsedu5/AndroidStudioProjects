package com.hasancsedu5gmail.gameofthronesbio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CastListActivity extends AppCompatActivity {

    private static final String TAG = CastListActivity.class.getSimpleName();
    private static final String NAME_LIST = "name_list.txt";
    private String mPersonId="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast_list);

//        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_cast_list);
//        addItem(linearLayout);


    }



    private void addItem(LinearLayout linearLayout) {



        try{
            List<String> list = getCastList();

            int listLen = list.size();

            for(int i=0;i<listLen;i++){

                Log.v(TAG,list.get(i));

                View view = getLayoutInflater().inflate(R.layout.profile,null);


                ImageButton imageButton = view.findViewById(R.id.image_button_cast_image);
                String name = list.get(i);
                final String fName = name;
                String imageName = nameToImageName(name);
                int imageId = getResources().getIdentifier(imageName,"drawable",getPackageName());
                Log.d(TAG,imageName);
                imageButton.setImageResource(imageId);
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG,"Clicked : " +fName);

                        Intent intent = new Intent(CastListActivity.this,CastInfoActivity.class);

                        intent.putExtra("name",fName);
                        startActivity(intent);
                    }
                });


                TextView tvName = view.findViewById(R.id.text_name);
                tvName.setText(name);

                TextView tvRating = view.findViewById(R.id.text_max_rating);
                tvRating.setText("Rating : 0");

                linearLayout.addView(view);



            }





        }catch (Exception e){
            Log.e(TAG,e.toString());
        }

    }

    private String nameToImageName(String name){

        String imageName = name;
        imageName = imageName.trim();
        imageName = imageName.toLowerCase();
        imageName = imageName.replace(" ","_");
        imageName = "image_"+imageName;


        return  imageName;

    }

    private int resourceNameToId(String name){

//        int id = this.getResources().getIdentifier("xyz", "raw", this.getPackageName());
        int resourceId = getResources().getIdentifier(name,"raw",getPackageName());

        return resourceId;
    }

    private List<String> getCastList(){

        List<String> list = new ArrayList<String>();
        try{
            Scanner scanner = new Scanner(getResources().openRawResource(R.raw.name_list));

            while(scanner.hasNext()){

                String line = scanner.nextLine();
                list.add(line);
            }
            scanner.close();
        }catch (Exception e){

            Log.e(TAG,e.toString());
        }


        return list;
    }

    public void onClickViewProfile(View view) {

        TextView tvID = view.findViewById(R.id.text_view_id);
        mPersonId=(String) tvID.getText();

        Intent intent = new Intent(this,CastDetailsActivity.class);
        intent.putExtra("id",mPersonId);
        startActivity(intent);
    }
}







