package com.example.parkinson;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parkinson.java.Config1;
import com.example.parkinson.java.webservice.WebService1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Event_Details extends AppCompatActivity {

    TextView event_date,event_name,event_desc,place,time,website,weblink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event__details);

        event_date=(TextView)findViewById(R.id.edit_bookDate);

        event_name=(TextView)findViewById(R.id.editName);

        event_desc=(TextView)findViewById(R.id.editDescript);
        place=(TextView)findViewById(R.id.place);

        time=(TextView)findViewById(R.id.time);

        website=(TextView)findViewById(R.id.website);
        weblink=(TextView)findViewById(R.id.weblink);
        AsyncTaskRunner task=new AsyncTaskRunner();
        task.execute();
    }





    public void selectAllDatesExists(String json)
    {

        //Tooat(json);
        try {
            Log.e("Data", json);
            JSONArray ja = new JSONArray(json);
            JSONObject jo = null;

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
            Calendar cal = Calendar.getInstance();

            for(int i=0; i<ja.length(); i++) {

                jo = ja.getJSONObject(i);


                String date1=jo.getString("date1");
                String place1=jo.getString("place");
                String website1=jo.getString("website");
                String time1=jo.getString("time");
                String name1=jo.getString("name");
                String weblink1=jo.getString("past_weblink");
                String descrip1=jo.getString("descrip");



                event_date.setText(date1);
                event_name.setText(name1);
                event_desc.setText(descrip1);
                place.setText(place1);
                time.setText(time1);
                website.setText(website1);
                weblink.setText(weblink1);

                Log.e("Data", jo.getString("event_id"));


            }

        }catch (Exception e) {
            Log.e("Webservice 3", e.toString());
            Tooat(e.toString());
        }

        //return pendingList;
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {


        private String resp;
        ProgressDialog progressDialog;
        private String result1;
        private String result2;
        @Override
        protected String doInBackground(String... params) {
            publishProgress("Process..."); // Calls onProgressUpdate()
            //Tooat("Welcome "+params[0]);
            try {


                result1="";
                result2="";
                WebService1 web=new WebService1();
                System.out.println("bagad="+Config1.date);
                //	String result=web.onLogin(username, password);
                String names[]={"date1"};
                String values[]={Config1.date};

                resp = web.sendCompleteData(names, values, "retrieve_events_bydate");



                Log.d("Values",resp);


            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return result1;
        }

        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            //  list_adapter= new ListAdapter_UserPanel(User_SelectPark.this, pendingList);
            // listView.setAdapter(list_adapter);
            //Tooat(decision);
            String status=resp.trim();
            //Tooat(resp);
            selectAllDatesExists(resp);


            progressDialog.dismiss();
            //finalResult.setText(result);
        }

        @Override
        protected void onPreExecute() {


            progressDialog = ProgressDialog.show(Event_Details.this,
                    "Process",
                    "Please wait...");
        }
        @Override
        protected void onProgressUpdate(String... text) {
            //finalResult.setText(text[0]);

        }
    }



    public void Tooat(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


}
