package com.example.parkinson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.parkinson.java.Config1;

public class VideoDisease extends AppCompatActivity {
Button d1,d2,d3,d4,d5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_disease);
        d1=(Button) findViewById(R.id.d1);
        d2=(Button) findViewById(R.id.d2);
        d3=(Button) findViewById(R.id.d3);
        d4=(Button) findViewById(R.id.d4);
        d5=(Button) findViewById(R.id.d5);

    }
    public void d1(View v)
    {
        Config1.die="Parkinson";
        Intent intent = new Intent(getApplicationContext(), VideoList.class);
        startActivity(intent);
    }
    public void d2(View v)
    {
        Config1.die="PSP";
        Intent intent = new Intent(getApplicationContext(), VideoList.class);
        startActivity(intent);
    }
    public void d3(View v)
    {
        Config1.die="MSA";
        Intent intent = new Intent(getApplicationContext(), VideoList.class);
        startActivity(intent);
    }
    public void d4(View v)
    {
        Config1.die="Essential Tremorous";
        Intent intent = new Intent(getApplicationContext(), VideoList.class);
        startActivity(intent);
    }
    public void d5(View v)
    {
        Config1.die="Other";
        Intent intent = new Intent(getApplicationContext(), VideoList.class);
        startActivity(intent);
    }

}
