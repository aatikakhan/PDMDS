package com.example.parkinson;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parkinson.java.webservice.WebService1;

public class Register extends AppCompatActivity {

    private EditText edit_t_id;
    private EditText edit_tpassword;
    private EditText edit_tfullname;

    private EditText edit_tdept;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setTitle("Sign Up");

        Initialized_Data();

    }


    private void Initialized_Data() {

        edit_t_id=(EditText)findViewById(R.id.edit_t_id);

        edit_tpassword=(EditText)findViewById(R.id.edit_tpassword);

        edit_tfullname=(EditText)findViewById(R.id.edit_tfullname);

        edit_tdept=(EditText)findViewById(R.id.edit_tdept);





    }


    public void onSave(View v )
    {
        if(validate()==0)
        {



            String str_edit_t_id=edit_t_id.getText().toString();

            String str_edit_tfullname=edit_tfullname.getText().toString();
            String str_edit_tdept=edit_tdept.getText().toString();


            String str_edit_tpassword=edit_tpassword.getText().toString();
            System.out.println("password"+str_edit_tdept);
            System.out.println("confirm password"+str_edit_tpassword);
            String names[]={str_edit_t_id,str_edit_tfullname,str_edit_tdept,str_edit_tpassword};

            if (str_edit_tdept.trim().contentEquals(str_edit_tpassword.trim()))
            {
                AsyncTaskRunner task = new AsyncTaskRunner();
                task.execute(names);


            }
            else {

                Tooat("Password and Confirm Password Dont Match");
            }

            }
    }


    public void onCancel(View v)
    {
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);
    }




    public int validate()
    {
        int validate = 0;
        String str_edit_t_id=edit_t_id.getText().toString();
        String str_edit_tpassword=edit_tpassword.getText().toString();
        String str_edit_tfullname=edit_tfullname.getText().toString();


        String str_edit_tdept=edit_tdept.getText().toString();


        if (str_edit_t_id.trim().equals("") && validate==0 )
        {
            Tooat("Please provide Username");
            validate = 1;
        }
        if (str_edit_tfullname.trim().equals("") && validate==0 )

        {
            Tooat("Please provide Email");
            validate = 1;
        }
        if (str_edit_tdept.trim().equals("") && validate==0 )
        {
            Tooat("Please provide Password");
            validate = 1;
        }

        if (str_edit_tpassword.trim().equals("") && validate==0 )
        {
            Tooat("Please provide Confirm Password");
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



                String names[]={"username","email","password"};
                String values[]={params[0],params[1],params[2]};
                //   resp = web.sendCompleteData(null, null, "retrieve_events");
                WebService1 web=new WebService1();
                resp = web.sendCompleteData(names, values, "users_save");
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
                Tooat("You have successfully saved data");

                Intent intent = new Intent(getApplicationContext(), PersonalDetails.class);
                startActivity(intent);
                finish();
            }
            else if(status.equals("Already"))
            {
                Tooat("User already exists");
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


            progressDialog = ProgressDialog.show(Register.this,"Process",
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
