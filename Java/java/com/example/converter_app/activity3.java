package com.example.converter_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class activity3 extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);

        button1=(Button)findViewById(R.id.btn1);
        button2=(Button)findViewById(R.id.btn2);
        button3=(Button)findViewById(R.id.btn3);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(activity3.this,MainActivity.class);
                startActivity(intent);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(activity3.this,activity4.class);
                startActivity(intent);

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(activity3.this,activity7.class);
                startActivity(intent);

            }
        });

    }
}
