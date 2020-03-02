package com.example.converter_app;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashscreenactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreenactivity);


        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(splashscreenactivity.this,activity3.class);
                startActivity(intent);
                finish();
            }
        },1500);
    }
}
