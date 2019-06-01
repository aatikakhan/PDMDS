package com.example.parkinson;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.parkinson.java.Common;
import com.example.parkinson.java.Config1;
import com.example.parkinson.java.adapter.Display_Adapter;
import com.example.parkinson.java.webservice.WebService1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class VideoList extends AppCompatActivity {

    private Button addButton;
    private ListView listView;
    // private CustomListAdapter adapter;
    private List<Common> pendingList = new ArrayList<Common>();
    private Display_Adapter list_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        setTitle("VIDEO DETAILS");

        listView = (ListView) findViewById(R.id.list);
        // list_adapter= new Complaint_Adapter(this, pendingList);
        //listView.setAdapter(list_adapter);


        //Getting List
        fillList();
        //Event Listener
        ListView_Event();

    }

    int i=0;
    protected void onResume()
    {
        super.onResume();


        if(i>0) {
            if(!pendingList.isEmpty()) {
                pendingList.clear();
            }
            fillList();

            // listView.deferNotifyDataSetChanged();
        }
        //Tooat("Welcome");
        i++;
    }



    private void fillList() {

        AsyncTaskRunner task=new AsyncTaskRunner();
        task.execute();

    }


    //========================================
    //***** Functions related to functionality
    //========================================
    private void ListView_Event() {
        // TODO Auto-generated method stub
        //ListView Click event
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Common value=pendingList.get(position);
                Config1.passenger.para1=value.para1;//t_id
                Config1.passenger.para2=value.para2;//tfullname
               Config1.passenger.para3=value.para3;//tdept
                //Config1.passenger.para4=value.para4;//temail
                //Config1.passenger.para5=value.para5;//tmobile
                //Config1.passenger.para6=value.para6;
                //Config1.passenger.para7=value.para7;
                //Config1.passenger.para8=value.para8;
                //Config1.passenger.para9=value.para9;//tpassword

                Intent intent=new Intent(VideoList.this,VideoPlayer.class);
                startActivity(intent);
                //Tooat(selected_Values.getParkingName());



            }
        });


    }


    public void Tooat(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }



    public void selectAllDatesExists(String json)
    {

        //Tooat(json);
        try {
            Log.e("Data", json);
            JSONArray ja = new JSONArray(json);
            JSONObject jo = null;

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Calendar cal = Calendar.getInstance();

            for(int i=0; i<ja.length(); i++) {

                jo = ja.getJSONObject(i);


                String dname=jo.getString("disease_name");
                String vname=jo.getString("video_name");
               String vurl=jo.getString("video_url");
              //  String sdiv=jo.getString("sdiv");
              //  String ssem=jo.getString("ssem");
               // String sbatch=jo.getString("sbatch");

                //String semail=jo.getString("semail");
               // String smobile=jo.getString("smobile");
               // String spassword=jo.getString("spassword");


                Common common=new Common();

                common.para1=dname;//notice_title
                common.para2=vname;//created_date
                common.para3=vurl;//notice_desc
               // common.para4=ssem;
               // common.para5=sdiv;
               // common.para6=sbatch;
                //common.para7=semail;//noticeid
                //common.para8=smobile;
                //common.para9=spassword;

                pendingList.add(common);
                // Log.e("Data", jo.getString("event_id"));


            }

            list_adapter= new Display_Adapter(this, pendingList);
            listView.setAdapter(list_adapter);
        }catch (Exception e) {
            Log.e("Webservice 3", e.toString());
            //Tooat(e.toString());
        }

        //return pendingList;
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {


        private String resp;
        ProgressDialog progressDialog;
        private String result1;
        private String result2;
        private String result3;
        private String result4;
        private String result5; private String result6;


        @Override
        protected String doInBackground(String... params) {
            publishProgress("Process..."); // Calls onProgressUpdate()
            //Tooat("Welcome "+params[0]);
            try {


                result1="";
                result2="";
                result3="";
                result4="";result5="";result6="";


                WebService1 web=new WebService1();
                //	String result=web.onLogin(username, password);

                String names[]={"disease_name"};
                String values[]={Config1.die};
                resp = web.sendCompleteData(names, values, "video_retrieve");
                //


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
            //String status=resp.trim();
            //Tooat(resp);
            selectAllDatesExists(resp);

            progressDialog.dismiss();
            //finalResult.setText(result);
        }

        @Override
        protected void onPreExecute() {


            progressDialog = ProgressDialog.show(VideoList.this,
                    "Process",
                    "Please wait...");
        }
        @Override
        protected void onProgressUpdate(String... text) {
            //finalResult.setText(text[0]);

        }
    }


}
