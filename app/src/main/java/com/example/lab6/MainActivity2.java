package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    final int BIKE_PRICE = 100;
    final int CAR_PRICE = 300;
    final int JEEP_PRICE = 800;
    int RentalPrice;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sp = PreferenceManager.getDefaultSharedPreferences(this);
        ImageView img = (ImageView)findViewById(R.id.carImage);

        int persons = sp.getInt("People",0);
        int RentalDays = sp.getInt("Days",0);

        TextView result = (TextView)findViewById(R.id.result);

        if(persons<=2){
            RentalPrice = BIKE_PRICE * RentalDays;
            img.setImageResource(R.drawable.bike) ;
        }
        else if(persons<=4){
            RentalPrice = CAR_PRICE * RentalDays;
            img.setImageResource(R.drawable.car2);
        }
        else{
            RentalPrice = JEEP_PRICE * RentalDays;
            img.setImageResource(R.drawable.jeep);
        }

        result.setText("The total price is: $"+RentalPrice);
    }
}