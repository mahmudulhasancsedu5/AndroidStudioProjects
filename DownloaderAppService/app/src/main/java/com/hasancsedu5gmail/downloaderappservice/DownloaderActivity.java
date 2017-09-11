package com.hasancsedu5gmail.downloaderappservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class DownloaderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloader);


        // do register receiver
        IntentFilter filter = new IntentFilter();
        filter.addAction("DownloadComplete");
        registerReceiver(new MyReceiver(),filter);
    }

    public void onGetClick(View view) {

        EditText etURL = (EditText) findViewById(R.id.text_url);
        String webPageURL = etURL.getText().toString();


        EditText etDelay  = (EditText) findViewById(R.id.text_delay);
        int delayMS  = Integer.valueOf(etDelay.getText().toString());

        CheckBox cbFake = (CheckBox) findViewById(R.id.check_box_fake);
        boolean isFake = cbFake.isChecked();




        //download this file useing a service
        //start service activity
        Intent intent = new Intent(this,DownloadService.class);
        intent.setAction("download");
        intent.putExtra("url",webPageURL);
        startService(intent);


        //--------------------------------
        Toast.makeText(this,"Start Downloading...",Toast.LENGTH_LONG).show();
    }

    private class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("MyReceiver : ","Got this data from : "+intent.getStringExtra("url")
                    +"\n Data :"+intent.getStringExtra("Data"));
        }
    }
}
