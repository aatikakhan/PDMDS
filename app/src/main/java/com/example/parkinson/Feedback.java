package com.example.parkinson;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.parkinson.java.Config1;
import com.example.parkinson.java.webservice.WebService1;

public class Feedback extends AppCompatActivity {
    private RadioButton a1,a2,a3,a4,a5,b1,b2,b3,b4,b5,c1,c2,c3,c4,c5;
  //  String a11="",a12="",a13="",a14="",a15="",b11="",b12="",b13="",b14="",b15="",c11="",c12="",c13="",c14="",c15="";
    String walking="",arising="",speech="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        a1=(RadioButton)findViewById(R.id.a1);
        a2=(RadioButton)findViewById(R.id.a2);
        a3=(RadioButton)findViewById(R.id.a3);
        a4=(RadioButton)findViewById(R.id.a4);
        a5=(RadioButton)findViewById(R.id.a5);


        b1=(RadioButton)findViewById(R.id.b1);
        b2=(RadioButton)findViewById(R.id.b2);
        b3=(RadioButton)findViewById(R.id.b3);
        b4=(RadioButton)findViewById(R.id.b4);
        b5=(RadioButton)findViewById(R.id.b5);


        c1=(RadioButton)findViewById(R.id.c1);
        c2=(RadioButton)findViewById(R.id.c2);
        c3=(RadioButton)findViewById(R.id.c3);
        c4=(RadioButton)findViewById(R.id.c4);
        c5=(RadioButton)findViewById(R.id.c5);








    }


    public void onRadioButtonClicked(View v) {
        // Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.a1:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    arising="0";
                a2.setChecked(false);
                a3.setChecked(false);
                a4.setChecked(false);
                a5.setChecked(false);

                break;
            case R.id.a2:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    arising="1";
                a1.setChecked(false);
                a3.setChecked(false);
                a4.setChecked(false);
                a5.setChecked(false);

                break;

            case R.id.a3:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    arising="2";
                a1.setChecked(false);
                a2.setChecked(false);
                a4.setChecked(false);
                a5.setChecked(false);

                break;

            case R.id.a4:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    arising="3";
                a1.setChecked(false);
                a2.setChecked(false);
                a3.setChecked(false);
                a5.setChecked(false);

                break;

            case R.id.a5:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    arising="4";
                a1.setChecked(false);
                a2.setChecked(false);
                a4.setChecked(false);
                a3.setChecked(false);

                break;
        }
    }

    public void onRadioButtonClicked1(View v) {
        // Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.b1:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    speech="0";
                b2.setChecked(false);
                b3.setChecked(false);
                b4.setChecked(false);
                b5.setChecked(false);

                break;
            case R.id.b2:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    speech="1";
                b1.setChecked(false);
                b3.setChecked(false);
                b4.setChecked(false);
                b5.setChecked(false);

                break;

            case R.id.b3:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    speech="2";
                b1.setChecked(false);
                b2.setChecked(false);
                b4.setChecked(false);
                b5.setChecked(false);

                break;

            case R.id.b4:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    speech="3";
                b1.setChecked(false);
                b2.setChecked(false);
                b3.setChecked(false);
                b5.setChecked(false);

                break;

            case R.id.b5:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    speech="4";
                b1.setChecked(false);
                b2.setChecked(false);
                b4.setChecked(false);
                b3.setChecked(false);

                break;
        }
    }


    public void onRadioButtonClicked2(View v) {
        // Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.c1:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    walking="0";
                c2.setChecked(false);
                c3.setChecked(false);
                c4.setChecked(false);
                c5.setChecked(false);

                break;
            case R.id.c2:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    walking="1";
                c1.setChecked(false);
                c3.setChecked(false);
                c4.setChecked(false);
                c5.setChecked(false);

                break;

            case R.id.c3:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    walking="2";
                c1.setChecked(false);
                c2.setChecked(false);
                c4.setChecked(false);
                c5.setChecked(false);

                break;

            case R.id.c4:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    walking="3";
                c1.setChecked(false);
                c2.setChecked(false);
                c3.setChecked(false);
                c5.setChecked(false);

                break;

            case R.id.c5:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    walking="4";
                c1.setChecked(false);
                c2.setChecked(false);
                c4.setChecked(false);
                c3.setChecked(false);

                break;
        }
    }



    public void onSave(View v )
    {
        if(validate()==0)
        {

            String names[]={arising,speech,walking};


                AsyncTaskRunner task = new AsyncTaskRunner();
                task.execute(names);





        }
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



                String names[]={"username","arising","speech","walking"};
                String values[]={Config1.username,params[0],params[1],params[2]};
                //   resp = web.sendCompleteData(null, null, "retrieve_events");
                WebService1 web=new WebService1();
                resp = web.sendCompleteData(names, values, "feedback_save");
                //result1=resp;
                Log.d("Values",resp);


            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return result1;
        }

        @Override
        protected void onPostExecute(String result) {

            String status=resp.trim();


            if(status.equals("Done")) {
                Tooat("Feedback successfully Given");

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }

            else
            {
                Tooat("Something went wrong! : "+status);
            }
            progressDialog.dismiss();
            //finalResult.setText(result);
        }

        @Override
        protected void onPreExecute() {


            progressDialog = ProgressDialog.show(Feedback.this,"Process",
                    "Please wait...");
        }
        @Override
        protected void onProgressUpdate(String... text) {

        }
    }





    public void onCancel(View v)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }




    public int validate()
    {
        int validate = 0;


        if (arising.trim().equals("") && validate==0 )
        {
            Tooat("Please provide Feedback for Arising from Chair");
            validate = 1;
        }
        if (speech.trim().equals("") && validate==0 )

        {
            Tooat("Please provide Feedback for Speech");
            validate = 1;
        }
        if (walking.trim().equals("") && validate==0 )
        {
            Tooat("Please provide Feedback for Walking");
            validate = 1;
        }




        return validate;
    }







    public void Tooat(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }




}
