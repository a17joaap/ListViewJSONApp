package com.example.brom.listviewjsonapp;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;


public class MountainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountain);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.mName);
        String location = intent.getStringExtra(MainActivity.mLoc);
        String height = intent.getStringExtra(MainActivity.mHeight);
        String url = intent.getStringExtra(MainActivity.mURL);
        String[] urls = {url};

        TextView nameTextView = (TextView) findViewById(R.id.card_mtnName);
        nameTextView.setText(name);

        TextView locationTextView = (TextView) findViewById(R.id.card_mtnLoc);
        String locationPrefix = locationTextView.getText().toString();
        String locationText = locationPrefix+location;
        locationTextView.setText(locationText);

        TextView heightTextView = (TextView) findViewById(R.id.card_mtnHeight);
        String heightPrefix = heightTextView.getText().toString();
        String heightText = heightPrefix+height+" Meters";
        heightTextView.setText(heightText);

        class DownloadImageTask extends AsyncTask<String,Void,Bitmap> {
            ImageView mtnImage;
            public DownloadImageTask(ImageView mtnImage) {
                this.mtnImage = mtnImage;
            }

            protected Bitmap doInBackground(String... urls) {
                String urldisplay = urls[0];
                Bitmap mtn = null;
                try {
                    InputStream in = new java.net.URL(urldisplay).openStream();
                    mtn = BitmapFactory.decodeStream(in);
                } catch (Exception e) {
                    Log.e("Error", e.getMessage());
                    e.printStackTrace();
                }
                return mtn;
            }
            protected void onPostExecute(Bitmap result) {
                mtnImage.setImageBitmap(result);
            }
        }
        new DownloadImageTask((ImageView) findViewById(R.id.card_imageView))
                .execute(url);
    }
}
