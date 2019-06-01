package com.example.parkinson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.parkinson.java.Config1;

import java.util.ArrayList;
import java.util.List;

public class PersonalDetails extends AppCompatActivity {

    private EditText edit_t_id;
    //private EditText edit_tpassword;
    private EditText edit_tfullname;

    private EditText edit_tdept;
    private RadioButton male;
    private  RadioButton female;
    private Spinner edit_diag_type;
    String str_edit_diag_type;
String gender="",str_edit_tfullname="",str_edit_tdept="",str_edit_t_id="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        setTitle("Personal Details");

        Initialized_Data();
        addItemsOnSpinner2();
      //  addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }
    public void addItemsOnSpinner2() {


        List<String> list = new ArrayList<String>();
        list.add("Ayurveda");
        list.add("Homeopathy");
        list.add("Natropathy");
        list.add("Other");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        edit_diag_type.setAdapter(dataAdapter);
        //str_edit_sdept=String.valueOf(edit_sdept.getSelectedItem());
        // System.out.println("DEPARTMENT="+str_edit_sdept);



    }

    public void addListenerOnSpinnerItemSelection() {
        edit_diag_type = (Spinner) findViewById(R.id.edit_diag_type);

        //edit_sdept.setOnItemSelectedListener(new CustomOnItemSelectedListener());

    }


    public void onRadioButtonClicked(View v) {
        // Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.male:
                if (checked)
                    //Toast.makeText(PersonalDetails.this," male",Toast.LENGTH_LONG).show();
                    gender="Male";
                    female.setChecked(false);
                break;
            case R.id.female:
                if (checked)
                   //Toast.makeText(PersonalDetails.this," female",Toast.LENGTH_LONG).show();
                    gender="Female";
                    male.setChecked(false);
                break;
        }
    }


    private void Initialized_Data() {

        edit_t_id=(EditText)findViewById(R.id.edit_t_id);

        //edit_tpassword=(EditText)findViewById(R.id.edit_tpassword);

        edit_tfullname=(EditText)findViewById(R.id.edit_tfullname);
        edit_diag_type=(Spinner)findViewById(R.id.edit_diag_type);
        edit_tdept=(EditText)findViewById(R.id.edit_tdept);
        male=(RadioButton)findViewById(R.id.male);
        female=(RadioButton)findViewById(R.id.female);






    }


    public void onSave(View v )
    {
        if(validate()==0)
        {



            str_edit_t_id=edit_t_id.getText().toString();

            str_edit_tfullname=edit_tfullname.getText().toString();
            str_edit_tdept=edit_tdept.getText().toString();


          //  String str_edit_tpassword=edit_tpassword.getText().toString();
            System.out.println("password"+str_edit_tdept);


            // get the selected dropdown list value










                    str_edit_diag_type=String.valueOf(edit_diag_type.getSelectedItem());
                    System.out.println("DEPARTMENT="+str_edit_diag_type);





           // System.out.println("confirm password"+str_edit_tpassword);
            String names[]={str_edit_t_id,str_edit_tfullname,gender,str_edit_tdept,str_edit_diag_type};
            Config1.passenger.para1=str_edit_t_id;
            Config1.passenger.para2=str_edit_tfullname;
            Config1.passenger.para3=gender;
            Config1.passenger.para4=str_edit_tdept;
            Config1.passenger.para5=str_edit_diag_type;

            System.out.println("sonal="+Config1.passenger.para1);
            System.out.println("sonal="+Config1.passenger.para2);

            System.out.println("sonal="+Config1.passenger.para3);
            System.out.println("sonal="+Config1.passenger.para4);
            System.out.println("sonal="+Config1.passenger.para5);

            Intent intent=new Intent(this,DiseaseDetails.class);
            startActivity(intent);


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
        //String str_edit_tpassword=edit_tpassword.getText().toString();
        String str_edit_tfullname=edit_tfullname.getText().toString();


        String str_edit_tdept=edit_tdept.getText().toString();


        if (str_edit_t_id.trim().equals("") && validate==0 )
        {
            Tooat("Please provide Name");
            validate = 1;
        }
        if (str_edit_tfullname.trim().equals("") && validate==0 )

        {
            Tooat("Please provide Age");
            validate = 1;
        }
          if (str_edit_tdept.trim().equals("") && validate==0 )
        {
            Tooat("Please provide Phone No");
            validate = 1;
        }
        if (gender.equals("") && validate==0 )
        {
            Tooat("Please provide Gender");
            validate = 1;
        }



        return validate;
    }







    public void Tooat(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }





}
