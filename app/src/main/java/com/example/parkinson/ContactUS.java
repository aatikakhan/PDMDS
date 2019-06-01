package com.example.parkinson;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class ContactUS extends AppCompatActivity {
    private ImageButton facebook,insta,yt,twitter ,web,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        facebook=(ImageButton) findViewById(R.id.fb);
        insta=(ImageButton) findViewById(R.id.insta);
        yt=(ImageButton) findViewById(R.id.yt);
        twitter=(ImageButton) findViewById(R.id.twitter);
        web=(ImageButton) findViewById(R.id.web);
        email=(ImageButton) findViewById(R.id.email);
       // facebook.setOnContextClickListener(new View.OnContextClickListener() {
        //    @Override

       // }
       // );
    }
    public void fb (View v)
    {
        Intent facebookIntent = openFacebook(ContactUS.this);
        startActivity(facebookIntent);
        // return false;
    }
    public static Intent openFacebook (Context context){

        try
        {
            context.getPackageManager().getPackageInfo("com.facebook.katana",0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/parkinsonssocietyindia/") );

        }catch( Exception e)
        {
            return  new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/parkinsonssocietyindia/"));
        }

    }

    public void insta (View v)
    {
        Intent instaIntent = openinsta(ContactUS.this);
        startActivity(instaIntent);
        // return false;
    }
    public static Intent openinsta(Context context){

        try
        {
            // context.getPackageManager().getPackageInfo("com.facebook.katana",0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/parkinsonssocietyindia/") );

        }catch( Exception e)
        {
            return  new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/parkinsonssocietyindia/"));
        }

    }


    public void yt (View v)
    {
        Intent ytIntent = openyt(ContactUS.this);
        startActivity(ytIntent);
        // return false;
    }
    public static Intent openyt(Context context){

        try
        {
            // context.getPackageManager().getPackageInfo("com.facebook.katana",0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/parkinsonsindia/") );

        }catch( Exception e)
        {
            return  new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/parkinsonsindia/"));
        }

    }


    public void twitter (View v)
    {
        Intent twitterIntent = opentwitter(ContactUS.this);
        startActivity(twitterIntent);
        // return false;
    }
    public static Intent opentwitter(Context context){


            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/parkinsonsindia/") );



    }
    public void web (View v)
    {
        Intent webIntent = openweb(ContactUS.this);
        startActivity(webIntent);
        // return false;
    }
    public static Intent openweb(Context context){


        return new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.parkinsonssocietyindia.com/") );
    }
    public void email (View v)
    {
        Intent emailIntent = openemail(ContactUS.this);
        startActivity(emailIntent);
        // return false;
    }
    public static Intent openemail(Context context){


        return new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gmail.com/") );
    }
}
