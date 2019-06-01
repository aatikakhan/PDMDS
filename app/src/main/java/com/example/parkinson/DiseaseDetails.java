package com.example.parkinson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.parkinson.java.Config1;

import java.util.ArrayList;
import java.util.List;

public class DiseaseDetails extends AppCompatActivity {

  //  private EditText edit_t_id;
    //private EditText edit_tpassword;
    private EditText edit_tfullname;

   // private EditText edit_tdept;

    private Spinner edit_disease;
    private Spinner edit_medicine;
    String str_edit_disease,str_edit_medicine;
    String str_edit_tfullname="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_details);

        setTitle("Disease Details");

        Initialized_Data();
        addItemsOnSpinner2();
        //  addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }
    public void addItemsOnSpinner2() {


        List<String> list = new ArrayList<String>();
        list.add("Parkinson");
        list.add("PSP");
        list.add("MSA");
        list.add("Essential Tremorous");
        list.add("Other");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        edit_disease.setAdapter(dataAdapter);


        List<String> list1 = new ArrayList<String>();
        list1.add("Syndopa");
        list1.add("Pramipax");
        list1.add("Ropark");
        list1.add("Amantral");
        list1.add("Parkintidin");
        list1.add("Rosalect");
        list1.add("Others");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        edit_medicine.setAdapter(dataAdapter1);
        //str_edit_sdept=String.valueOf(edit_sdept.getSelectedItem());
        // System.out.println("DEPARTMENT="+str_edit_sdept);



    }

    public void addListenerOnSpinnerItemSelection() {
        edit_disease = (Spinner) findViewById(R.id.edit_disease);
        edit_medicine = (Spinner) findViewById(R.id.edit_medicine);
        //edit_sdept.setOnItemSelectedListener(new CustomOnItemSelectedListener());

    }





    private void Initialized_Data() {

        //edit_t_id=(EditText)findViewById(R.id.edit_t_id);

        //edit_tpassword=(EditText)findViewById(R.id.edit_tpassword);
        edit_disease = (Spinner) findViewById(R.id.edit_disease);
        edit_medicine = (Spinner) findViewById(R.id.edit_medicine);
        edit_tfullname=(EditText)findViewById(R.id.edit_tfullname);
        //edit_diag_type=(Spinner)findViewById(R.id.edit_diag_type);
        //edit_tdept=(EditText)findViewById(R.id.edit_tdept);
        //male=(RadioButton)findViewById(R.id.male);
        //female=(RadioButton)findViewById(R.id.female);






    }


    public void onSave(View v )
    {
        if(validate()==0)
        {



          //  str_edit_t_id=edit_t_id.getText().toString();

            str_edit_tfullname=edit_tfullname.getText().toString();
           // str_edit_tdept=edit_tdept.getText().toString();


            //  String str_edit_tpassword=edit_tpassword.getText().toString();
            //System.out.println("password"+str_edit_tdept);


            // get the selected dropdown list value










            str_edit_disease=String.valueOf(edit_disease.getSelectedItem());
            System.out.println("DEPARTMENT="+str_edit_disease);

            str_edit_medicine=String.valueOf(edit_medicine.getSelectedItem());
            System.out.println("DEPARTMENT="+str_edit_medicine);



            // System.out.println("confirm password"+str_edit_tpassword);
            String names[]={str_edit_disease,str_edit_tfullname,str_edit_medicine};
            Config1.passenger.para6=str_edit_disease;
            Config1.passenger.para7=str_edit_tfullname;
            Config1.passenger.para8=str_edit_medicine;
         //   Config1.passenger.para4=str_edit_tdept;
         //   Config1.passenger.para5=str_edit_diag_type;

            System.out.println("sonal="+Config1.passenger.para6);
            System.out.println("sonal="+Config1.passenger.para7);

            System.out.println("sonal="+Config1.passenger.para8);
           // System.out.println("sonal="+Config1.passenger.para4);
          //  System.out.println("sonal="+Config1.passenger.para5);

            Intent intent=new Intent(this,DoctorDetails.class);
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
     //   String str_edit_t_id=edit_t_id.getText().toString();
        //String str_edit_tpassword=edit_tpassword.getText().toString();
        String str_edit_tfullname=edit_tfullname.getText().toString();


        //String str_edit_tdept=edit_tdept.getText().toString();


        if (str_edit_tfullname.trim().equals("") && validate==0 )
        {
            Tooat("Please provide Year of Diagnosis");
            validate = 1;
        }




        return validate;
    }







    public void Tooat(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }





}
