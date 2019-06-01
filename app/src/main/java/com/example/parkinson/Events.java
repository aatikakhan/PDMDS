package com.example.parkinson;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.parkinson.java.Config1;
import com.example.parkinson.java.webservice.WebService1;
import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Events extends AppCompatActivity {

    private Button edit_bookDate,customize_button;
    String select_BookDate;
    Calendar myCalendar = Calendar.getInstance();
    Date added_date;

    private CaldroidFragment caldroidFragment;
    final SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");

    String webCallDecision;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        Initialized_Date();

        calDroidInitialized(savedInstanceState);

        selectDateEvent();

        webCallDecision="Retrieve";

        AsyncTaskRunner task=new AsyncTaskRunner();
        task.execute();
        //Tooat("Welcome");
    }

    private void Initialized_Date() {

       // customize_button=(Button)findViewById(R.id.customize_button);
        select_BookDate="";
        webCallDecision="Retrieve";


    }

    public void Click_BookDate()

    {

        //Book Date

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateLabel();
            }
        };


        new DatePickerDialog(Events.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show();
    }
    private void updateLabel() {

        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        try {
            Date currentDate = sdf.parse(sdf.format(new Date() ));
            Date selectDae=sdf.parse(sdf.format(myCalendar.getTime()));
            added_date=selectDae;
            //if(selectDae.compareTo(currentDate)>=0)
            //{
            edit_bookDate.setText(sdf.format(myCalendar.getTime()));
            select_BookDate=""+sdf.format(myCalendar.getTime());
            // Tooat("Please comes!");
            // }
            //else
            //{
            //   edit_bookDate.setText("Select Date");
            //  select_BookDate="";
            // Toast.makeText(this,"Please select valid date!",Toast.LENGTH_SHORT).show();
            //}

        } catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    Dialog dialog;
/*

    public void onAddEvent(View v)
    {
        dialog = new Dialog(this);
        // Include dialog.xml file
        dialog.setTitle("Add Event");
        dialog.setContentView(R.layout.admin_calender_event_pop);
        dialog.show();

        edit_bookDate = (Button) dialog.findViewById(R.id.edit_bookDate);

        edit_bookDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Click_BookDate();
            }
        });

        Button btnSave = (Button) dialog.findViewById(R.id.save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editDescription=(EditText) dialog.findViewById(R.id.editDescript);
                EditText editName=(EditText) dialog.findViewById(R.id.editName);

                String str_name=editName.getText().toString();
                String str_desc=editDescription.getText().toString();

                if(select_BookDate.equals("") || str_name.trim().equals("") || str_desc.equals("")) {
                    Tooat("Provide complete details");
                }
                else {
                    AsyncTaskRunner task = new AsyncTaskRunner();
                    webCallDecision="Save";
                    String[] values = {select_BookDate,str_name,str_desc};
                    task.execute(values);
                }
            }
        });

    }

    */
    private void calDroidInitialized(Bundle savedInstanceState) {

        // Setup caldroid fragment
        // **** If you want normal CaldroidFragment, use below line ****
        caldroidFragment = new CaldroidFragment();


        // If Activity is created after rotation
        if (savedInstanceState != null) {
            caldroidFragment.restoreStatesFromKey(savedInstanceState,
                    "CALDROID_SAVED_STATE");
        }
        // If activity is created from fresh
        else {
            Bundle args = new Bundle();
            Calendar cal = Calendar.getInstance();
            args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
            args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
            args.putBoolean(CaldroidFragment.ENABLE_SWIPE, true);
            args.putBoolean(CaldroidFragment.SIX_WEEKS_IN_CALENDAR, true);

            // Uncomment this to customize startDayOfWeek
            // args.putInt(CaldroidFragment.START_DAY_OF_WEEK,
            // CaldroidFragment.TUESDAY); // Tuesday

            // Uncomment this line to use Caldroid in compact mode
            // args.putBoolean(CaldroidFragment.SQUARE_TEXT_VIEW_CELL, false);

            // Uncomment this line to use dark theme
//            args.putInt(CaldroidFragment.THEME_RESOURCE, com.caldroid.R.style.CaldroidDefaultDark);

            caldroidFragment.setArguments(args);
        }

        setCustomResourceForDates();

        // Attach to the activity
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.calendar1, caldroidFragment);
        t.commit();


    }


    private void setCustomResourceForDates() {
        Calendar cal = Calendar.getInstance();

        // Min date is last 7 days
        cal.add(Calendar.DATE, -7);
        Date blueDate = cal.getTime();

        // Max date is next 7 days
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        Date greenDate = cal.getTime();

        if (caldroidFragment != null) {
            //ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.blue));
            //ColorDrawable green = new ColorDrawable(Color.GREEN);
            //caldroidFragment.setBackgroundDrawableForDate(blue, blueDate);
            // caldroidFragment.setBackgroundDrawableForDate(green, greenDate);
            //caldroidFragment.setTextColorForDate(R.color.white, blueDate);
            //caldroidFragment.setTextColorForDate(R.color.white, greenDate);

        }
    }


    Date already;
    private void selectDateEvent() {

        // Setup listener
        final CaldroidListener listener = new CaldroidListener() {

            @Override
            public void onSelectDate(Date date, View view) {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
                Calendar cal = Calendar.getInstance();
                try
                {
                    String newdate=format.format(date);
                    Config1.date=newdate;
                    System.out.println("bagad="+Config1.date);
                    Intent intent=new Intent(Events.this,Event_Details.class);
                    startActivity(intent);
                }
                catch(Exception as)
                {

                }

            }

            @Override
            public void onChangeMonth(int month, int year) {

                setHolidaysWeekendDays(year,month);
                //  String text = "month: " + month + " year: " + year;
                // Toast.makeText(getApplicationContext(), text,
                //        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClickDate(Date date, View view) {
                //   Toast.makeText(getApplicationContext(),
                //          "Long click " + formatter.format(date),
                //         Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCaldroidViewCreated() {
                if (caldroidFragment.getLeftArrowButton() != null) {
                    //       Toast.makeText(getApplicationContext(),
                    //              "Caldroid view is created", Toast.LENGTH_SHORT)
                    //            .show();
                }
            }

        };

        // Setup Caldroid
        caldroidFragment.setCaldroidListener(listener);

    }

    public void setHolidaysWeekendDays(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        // Note that month is 0-based in calendar, bizarrely.
        calendar.set(year, month - 1, 1);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (int day = 1; day <= daysInMonth; day++) {
            calendar.set(year, month - 1, day);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SUNDAY ) {
                // count++;
                // Or do whatever you need to with the result.
                calendar.get(Calendar.DAY_OF_MONTH);
                Date sundayDate = calendar.getTime();

                ColorDrawable red = new ColorDrawable(getResources().getColor(R.color.coolRed));
                caldroidFragment.setBackgroundDrawableForDate(red, sundayDate);
                caldroidFragment.setTextColorForDate(R.color.white, sundayDate);


                //Toast.makeText(this,""+Calendar.SUNDAY,Toast.LENGTH_SHORT).show();
            }
        }

        caldroidFragment.refreshView();

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


                String date=jo.getString("date1");
                String place=jo.getString("place");
                String website=jo.getString("website");
                String time=jo.getString("time");
                String name=jo.getString("name");
                String weblink=jo.getString("past_weblink");
                String descrip=jo.getString("descrip");

                Date event_dates=format.parse(date);
                ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.blue));
                caldroidFragment.setBackgroundDrawableForDate(blue, event_dates);
                caldroidFragment.setTextColorForDate(R.color.white, event_dates);

                Log.e("Data", jo.getString("event_id"));


            }
            caldroidFragment.refreshView();

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
                //	String result=web.onLogin(username, password);


                    resp = web.sendCompleteData(null, null, "retrieve_events");



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
            // Tooat(resp);
            String status=resp.trim();
            if(webCallDecision.equals("Save")) {

                if(status.equals("Done"))
                {
                    dialog.hide();
                    Tooat("You have successfully saved an event");
                    ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.blue));
                    caldroidFragment.setBackgroundDrawableForDate(blue, added_date);
                    caldroidFragment.setTextColorForDate(R.color.white, added_date);
                    caldroidFragment.refreshView();

                }
            }
            else
            {
                //Tooat(resp);
                selectAllDatesExists(resp);
            }


            progressDialog.dismiss();
            //finalResult.setText(result);
        }

        @Override
        protected void onPreExecute() {


            progressDialog = ProgressDialog.show(Events.this,
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

