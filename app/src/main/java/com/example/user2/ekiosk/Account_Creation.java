package com.example.user2.ekiosk;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;


public class Account_Creation extends AppCompatActivity implements View.OnClickListener {

    EditText firstname, lastname, username, password;
    String string_firstname, string_lastname, string_username, string_password, string_gender;
    Button btn_account_create;
    RadioGroup gender;
    SQLiteDatabase db;
    int selectedId;
    EKiosk_DatabaseHelper_Class eKiosk_databaseHelper_class;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account__creation);
        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        gender = (RadioGroup) findViewById(R.id.gender);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btn_account_create = (Button) findViewById(R.id.btn_acc_creation);
        btn_account_create.setOnClickListener(this);
        eKiosk_databaseHelper_class = new EKiosk_DatabaseHelper_Class(this);
    }

    @Override
    public void onClick(View v) {
        if((v.getId()) == R.id.btn_acc_creation){
            string_firstname = firstname.getText().toString();
            string_lastname = lastname.getText().toString();
            selectedId = gender.getCheckedRadioButtonId();
            string_username = username.getText().toString();
            string_password = password.getText().toString();
           boolean isInseted =  eKiosk_databaseHelper_class.insertEntry(string_firstname, string_lastname, string_username, string_password);

            if(isInseted == true){
                Toast.makeText(this, "Successfully inserted", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show();
            }
        }


    }


}
