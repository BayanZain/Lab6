package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText person = (EditText)findViewById(R.id.person);
        EditText daysE = (EditText)findViewById(R.id.dayNum);
        EditText LicenceE = (EditText)findViewById(R.id.months);

        Button bttn = (Button)findViewById(R.id.button);

        sp = PreferenceManager.getDefaultSharedPreferences(this);

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int personNum = Integer.parseInt(person.getText().toString());
                int licence = Integer.parseInt(LicenceE.getText().toString());
                int days = Integer.parseInt(daysE.getText().toString());

                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("People",personNum);
                editor.putInt("Days",days);
                editor.commit();

                if(licence<1){
                    Toast.makeText(MainActivity.this,"Your driving licenec will expire soon "+
                            "Please renew it first then visit us back",Toast.LENGTH_LONG).show();
                }
                else{
                    startActivity(new Intent(MainActivity.this,MainActivity2.class));
                }

            }
        });

    }
}