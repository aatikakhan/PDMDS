package com.example.parkinson;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parkinson.java.Config1;
import com.example.parkinson.java.webservice.WebService1;

public class Profile extends AppCompatActivity {
private TextView name,age,gender,phone,emergency,address,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);








        name= (TextView) findViewById(R.id.edit_t_id);
        age= (TextView) findViewById(R.id.edit_tfullname);
        gender= (TextView) findViewById(R.id.edit_gender);
        phone= (TextView) findViewById(R.id.edit_tdept);
        email= (TextView) findViewById(R.id.edit_email);
        emergency= (TextView) findViewById(R.id.edit_emerg);
        address= (TextView) findViewById(R.id.edit_address);
        password= (TextView) findViewById(R.id.edit_password);

        name.setText(Config1.name);
        age.setText(Config1.age);
        gender.setText(Config1.gender);
        email.setText(Config1.email);
        phone.setText(Config1.phone);
        emergency.setText(Config1.emergency_contact);
        address.setText(Config1.address);
        password.setText(Config1.password);





    }


    public void onSave(View v)
    {
        if(validate()==0)
        {



            String str_edit_phone=phone.getText().toString();

            String str_edit_email=email.getText().toString();
                String str_edit_emergency=emergency.getText().toString();

            String str_edit_address=address.getText().toString();

            String str_edit_password=password.getText().toString();
            //System.out.println("password"+str_edit_tdept);
            //System.out.println("confirm password"+str_edit_tpassword);
            String names[]={str_edit_phone,str_edit_email,str_edit_emergency,str_edit_address,str_edit_password};

            AsyncTaskRunner task = new AsyncTaskRunner();
            task.execute(names);



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
        String str_edit_phone=phone.getText().toString();

        String str_edit_email=email.getText().toString();
        String str_edit_emergency=emergency.getText().toString();

        String str_edit_address=address.getText().toString();

        String str_edit_password=password.getText().toString();

        if (str_edit_phone.trim().equals("") && validate==0 )
        {
            Tooat("Please provide Phone No");
            validate = 1;
        }
        if (str_edit_email.trim().equals("") && validate==0 )

        {
            Tooat("Please provide Email");
            validate = 1;
        }
        if (str_edit_emergency.trim().equals("") && validate==0 )
        {
            Tooat("Please provide Emerency Contact");
            validate = 1;
        }

        if (str_edit_address.trim().equals("") && validate==0 )
        {
            Tooat("Please provide Address");
            validate = 1;
        }
        if (str_edit_password.trim().equals("") && validate==0 )
        {
            Tooat("Please provide Password");
            validate = 1;
        }


        return validate;
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



                String names[]={"phone","email","emergency_contact","address","password","username"};
                String values[]={params[0],params[1],params[2],params[3],params[4],Config1.username};
                //   resp = web.sendCompleteData(null, null, "retrieve_events");
                WebService1 web=new WebService1();
                resp = web.sendCompleteData(names, values, "users_update");
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
                Tooat("You have successfully updated user");
                String str_edit_phone=phone.getText().toString();

                String str_edit_email=email.getText().toString();
                String str_edit_emergency=emergency.getText().toString();

                String str_edit_address=address.getText().toString();

                String str_edit_password=password.getText().toString();


                // String user_type=jo.getString("user_type");

                Config1.phone=str_edit_phone;
                Config1.email=str_edit_email;
                Config1.emergency_contact=str_edit_emergency;

                Config1.password=str_edit_password;

                Config1.address=str_edit_address;
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


            progressDialog = ProgressDialog.show(Profile.this,"Process",
                    "Please wait...");
        }
        @Override
        protected void onProgressUpdate(String... text) {

        }
    }




    public void Tooat(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }




}
