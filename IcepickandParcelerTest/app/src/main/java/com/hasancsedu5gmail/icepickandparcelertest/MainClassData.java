package com.hasancsedu5gmail.icepickandparcelertest;

import org.parceler.Parcel;

/**
 * Created by mahmud on 9/15/2017.
 */

@Parcel
public class MainClassData {
    String text;

    public MainClassData() {

    }
    public MainClassData(String text) {
        this.text = text;
    }
}
