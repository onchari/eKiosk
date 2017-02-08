package com.example.user2.ekiosk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    Button accont_creation , view_all_data  ;
    Button sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accont_creation  = (Button) findViewById(R.id.account_creation);
        accont_creation.setOnClickListener(this);

        sign_in = (Button) findViewById(R.id.sign_in);
        sign_in.setOnClickListener(this);

        view_all_data = (Button) findViewById(R.id.view_all);
        view_all_data.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case  R.id.account_creation:
                accont_creation();
                break;

            case R.id.sign_in:
                sign_in();
                break;
            case R.id.view_all:
                getAllDetails();

            default:
                Toast.makeText(MainActivity.this, "No button Clicked", Toast.LENGTH_LONG).show();
        }
    }

    private void accont_creation() {
        Intent account_creation_intent = new Intent(this, Account_Creation.class);
        startActivity(account_creation_intent);
    }


    private void sign_in() {
        Intent signin_intent = new Intent(this,Kiosk_Login.class);
        startActivity(signin_intent);
    }

    public void getAllDetails(){
        Intent viewAllData = new Intent(this, ViewAllData.class);
        startActivity(viewAllData);

    }
}
