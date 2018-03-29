package com.example.brom.listviewjsonapp;

import android.support.v7.app.AppCompatActivity;


public class Mountain extends AppCompatActivity {

    public String name;
    public String location;
    public int height;


    public Mountain(String Name, String Location, int Height) {
        this.name = Name;
        this.location = Location;
        this.height = Height;
    }

}
