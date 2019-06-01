package com.example.parkinson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.parkinson.java.Config1;



public class Setting extends AppCompatActivity {

    private EditText edit_ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setTitle("Settings");

        edit_ip= (EditText) findViewById(R.id.edit_ip);
        edit_ip.setText(Config1.IP);
    }

    public void set_ip(View v)
    {
        String Ip=edit_ip.getText().toString();
        Config1.IP=Ip;
        finish();
    }
}
