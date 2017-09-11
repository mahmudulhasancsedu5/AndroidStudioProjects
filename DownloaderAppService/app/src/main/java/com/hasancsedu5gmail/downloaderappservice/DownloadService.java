package com.hasancsedu5gmail.downloaderappservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class DownloadService extends Service {

    private static int mNotificationId = 1234;
    public DownloadService() {
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {

        if(intent.getAction() == "download"){

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    String url = intent.getStringExtra("url");
                    Log.d("Downloade Service : "," Srart Thread service of dowmload  URL : "+url);

                    String contents = "Boom Boom Boom downloaded"; //Downloader.downloadFake(url);


                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //Notification
                    Notification.Builder builder = new Notification.Builder(DownloadService.this)
                            .setContentTitle("DownloadCompleted")
                            .setContentText("I receive the file")
                            .setSmallIcon(R.drawable.icon);

                    // tab notification open the app

                    Intent launch = new Intent(DownloadService.this,DownloaderActivity.class);

                    PendingIntent pendingIntent = PendingIntent.getActivity(
                            DownloadService.this,
                            0,
                            launch,
                            0
                    );
                    builder.setContentIntent(pendingIntent);

                    //----------------------------


                    Notification notification = builder.build();
                    NotificationManager notificationManager =
                            (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.notify(mNotificationId++,notification);


                    // after finishing finish downloading---/

                    Intent downloadDone = new Intent();
                    downloadDone.setAction("DownloadComplete");
                    downloadDone.putExtra("url",url);
                    downloadDone.putExtra("Data",contents);
                    sendBroadcast(downloadDone);

                }
            });
            thread.start();



        }
        else{

        }


        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
