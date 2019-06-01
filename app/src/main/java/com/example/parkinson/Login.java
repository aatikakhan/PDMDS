package com.example.parkinson;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parkinson.java.Config1;
import com.example.parkinson.java.webservice.WebService1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Login extends AppCompatActivity {

    private EditText edit_username;
    private EditText edit_password;

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }


        edit_username=(EditText)findViewById(R.id.edit_username);
        edit_password=(EditText)findViewById(R.id.edit_password);
    }

    public void onLogin(View v)
    {

        Log.d("Come","1");
        String username=edit_username.getText().toString();
        String password=edit_password.getText().toString();
        Log.d("Come","2");
        int furthur=0;
        if(username.trim().equals(""))
        {
            Tooat("Please enter username");
            furthur=1;
        }
        if(password.trim().equals("") && furthur==0)
        {
            Tooat("Please enter password");
            furthur=1;
        }

        if(furthur==0) {

            String[] values={username,password};
            AsyncTaskRunner runner = new AsyncTaskRunner();
            runner.execute(values);
        }
    }


    public void onSetting(View v)
    {
        Intent intent=new Intent(this,Setting.class);
        startActivity(intent);
    }

    public void onRegister(View v)
    {
        Intent intent=new Intent(this,Register.class);
        startActivity(intent);
    }
    public void selectAllDatesExists(String json)
    {
        int o=1;
        //Tooat(json);

        try {
            Log.e("Data", json);
            JSONArray ja = new JSONArray(json);
            JSONObject jo = null;

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
            Calendar cal = Calendar.getInstance();

            for(int i=0; i<ja.length(); i++) {

                jo = ja.getJSONObject(i);


                String t_id=jo.getString("username");
                // String flatno=jo.getString("flatno");
                String tpassword=jo.getString("password");
                String sign_up=jo.getString("sign_up");
                String name=jo.getString("name");
                String age=jo.getString("age");
                String gender=jo.getString("gender");
                String phone=jo.getString("phone");
                String email=jo.getString("email");
                String emergency_contact=jo.getString("emergency_contact");
                String address=jo.getString("address");
                String medicine=jo.getString("medicine");
                String yr_of_diag=jo.getString("yr_of_diag");
                String diagnosis_type=jo.getString("diagnosis_type");
                String disease=jo.getString("disease");
                String doc_name=jo.getString("doc_name");



                // String user_type=jo.getString("user_type");
                Config1.username=t_id;
                Config1.name=name;
                Config1.age=age;
                Config1.gender=gender;
                Config1.phone=phone;
                Config1.email=email;
                Config1.emergency_contact=emergency_contact;
                Config1.diagnosis_type=diagnosis_type;
                Config1.password=tpassword;
                Config1.disease=disease;
                Config1.doc_name=doc_name;
                Config1.yr_of_diag=yr_of_diag;
                Config1.medicine=medicine;
                Config1.address=address;

                Tooat("You have successfully Logged In!");
                o=0;
                if (sign_up.contentEquals("0"))
                {
                    Intent intent = new Intent(getApplicationContext(), PersonalDetails.class);
                    startActivity(intent);
                }

                else
                {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }



            }

        }catch (Exception e) {
            Tooat("Either Username or Passowrd is not incorrect");
            Log.e("Webservice 3", e.toString());
            Tooat(e.toString());
        }
        if(o==1)
        {
            Tooat("Either Username or Passowrd is not incorrect");
        }
        //return pendingList;
    }
    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Process..."); // Calls onProgressUpdate()
            try {

                // String username=edit_username.getText().toString();
                // String password=edit_password.getText().toString();

                String[] values={params[0],params[1]};
                String[] names={"username","password"};
                //Log.d("Come","1");
                WebService1 web=new WebService1();
                resp=web.sendCompleteData(names,values,"validate_user");
                //resp=web.onLogin(username, password);
                //Log.d("Come","2"+result);




            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }


        @Override
        protected void onPostExecute(String result) {


            // execution of result of Long time consuming operation
            progressDialog.dismiss();

            String status=resp.trim();
            //Tooat(resp);
            selectAllDatesExists(resp);
            //finalResult.setText(result);
        }


        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(Login.this,
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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
