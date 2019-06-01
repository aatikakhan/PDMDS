package com.example.parkinson;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Date extends AppCompatActivity {

    TextView date;
    TextView time;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        date = (TextView) findViewById(R.id.date);
        time = (TextView) findViewById(R.id.time);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog
                        (Date.this,
                                android.R.style.Theme_DeviceDefault_Dialog,mDateSetListener, year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d("Date", "onDateSet: date" + day+"/"+month+"/"+year);
                String date1=day+"/"+month+"/"+year;
                date.setText(date1);

            }
        };


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int hour=cal.get(Calendar.HOUR_OF_DAY);
                int minute=cal.get(Calendar.MINUTE);
              //  int sec = cal.get(Calendar.MILLISECOND);

                TimePickerDialog dialog1 = new TimePickerDialog(Date.this,android.R.style.Theme_DeviceDefault_Dialog,mTimeSetListener,hour,minute, DateFormat.is24HourFormat(Date.this));

                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();

            }
        });
        mTimeSetListener = new TimePickerDialog.OnTimeSetListener(){

                            @Override
                            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                                Log.d("Time", "onTimeSet: time" + hour+"/"+minute);
                                String AM_PM="" ;
                                String hour1="";
                                if(hour < 12) {
                                    AM_PM = "AM";
                                } else {
                                    AM_PM = "PM";
                                }
                                if (hour>10)
                                {
                                    hour=hour-12;
                                }
                             /*   if (hour<10)
                                {
                                    hour1="0"+hour;
                                }
*/
                                String time1=hour+":"+minute+" "+AM_PM;
                                time.setText(time1);
                            }
                        };



    }
}
