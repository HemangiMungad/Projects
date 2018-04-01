package com.example.lenovo.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.lenovo.tourguide.Beaches.BeachMapsActivity;
import com.example.lenovo.tourguide.Hospitals.HospitalMapsActivity;
import com.example.lenovo.tourguide.Lodge.LodgeMapsActivity;
import com.example.lenovo.tourguide.Malls.MallMapsActivity;
import com.example.lenovo.tourguide.Restaurants.RestaurantMapsActivity;
import com.example.lenovo.tourguide.Theatre.TheatreMapsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton mall= (ImageButton) findViewById(R.id.mall);
        ImageButton hosp=(ImageButton) findViewById(R.id.hosp);
        ImageButton res=(ImageButton) findViewById(R.id.res);
        ImageButton bea=(ImageButton)findViewById(R.id.bea);
        ImageButton cin= (ImageButton) findViewById(R.id.cin);
        ImageButton acc=(ImageButton) findViewById(R.id.acc);

        mall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFirstActivity();
            }
        });


        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             goTosixthActivity();
            }
        });
        cin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            goToFifthActivity();
            }
        });
        hosp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
            }
        });
        bea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToThirdActivity();
            }
        });
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             goToFourthActivity();
            }
        });
    }

    private void goTosixthActivity() {
        Intent i= new Intent(this, LodgeMapsActivity.class);
        startActivity(i);
    }

    private void goToFifthActivity() {
        Intent i= new Intent(this, TheatreMapsActivity.class);
        startActivity(i);
    }

    private void goToFourthActivity() {
        Intent i= new Intent(this, RestaurantMapsActivity.class);
        startActivity(i);
    }

    private void goToThirdActivity() {
        Intent i= new Intent(this, BeachMapsActivity.class);
        startActivity(i);
    }

    private void goToSecondActivity() {
        Intent i= new Intent(this, HospitalMapsActivity.class);
        startActivity(i);
    }

    private void goToFirstActivity() {
        Intent i= new Intent(this, MallMapsActivity.class);
        startActivity(i);
    }
}
