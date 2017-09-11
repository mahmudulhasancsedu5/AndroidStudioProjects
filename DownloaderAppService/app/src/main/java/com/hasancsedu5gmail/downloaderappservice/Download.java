package com.hasancsedu5gmail.downloaderappservice;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mahmud on 9/11/2017.
 */

public class Download {


    public Download(){

    }

    public String download(String fileURLString){

        // open a Directory to save downloaded file

        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);


        if(folder.exists() == false){

            folder.mkdirs();
        }

        byte[] bytes =  downloadAsByteArray(fileURLString);
        //-->


        return "";
    }

    private static byte[] downloadAsByteArray(String fileURLString) {

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();

        try{
            URL url = new URL(fileURLString);
            InputStream inputStream = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int ch;
            while((ch = bufferedReader.read()) != -1){
                bytes.write(ch);
            }

            inputStream.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes.toByteArray();
    }


}
