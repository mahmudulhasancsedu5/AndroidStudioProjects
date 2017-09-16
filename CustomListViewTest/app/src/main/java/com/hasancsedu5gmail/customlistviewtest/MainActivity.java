package com.hasancsedu5gmail.customlistviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private String mName[]= {
                    "Emilia Clark",
                    "Kit Harington",
                    "Peter Dinklage"
            };

    private int[] mImageId = {
            R.drawable.image_emilia_clarke,
            R.drawable.image_kit_harington,
            R.drawable.image_peter_dinklage
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addList();
    }



    private void addList(){

        ListView listView = (ListView) findViewById(R.id.list_items);

//        CustomList adapter = new CustomList(this,mName,mImageId);

        MyAdapter adapter = new MyAdapter(getApplicationContext(),mName,mImageId);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                TextView textView = view.findViewById(R.id.text_item_name);
                String name = textView.getText().toString();

                Toast.makeText(MainActivity.this,"Clicked : "+name,Toast.LENGTH_SHORT).show();

            }
        });


    }
}
