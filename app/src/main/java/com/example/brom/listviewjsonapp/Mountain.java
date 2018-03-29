package com.example.brom.listviewjsonapp;

import android.support.v7.app.AppCompatActivity;


public class Mountain extends AppCompatActivity {

    public String name;
    public String location;
    public String height;
    public String pictureURL;


    public Mountain(String Name, String Location, String Height, String URL) {
        this.name = Name;
        this.location = Location;
        this.height = Height;
        this.pictureURL = URL;
    }

}
