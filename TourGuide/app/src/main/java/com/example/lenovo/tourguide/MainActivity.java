package com.example.lenovo.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.lenovo.tourguide.Malls.MapsActivity;

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
        Intent i= new Intent(this, com.example.lenovo.tourguide.Lodge.MapsActivity.class);
        startActivity(i);
    }

    private void goToFifthActivity() {
        Intent i= new Intent(this, com.example.lenovo.tourguide.Theatre.MapsActivity.class);
        startActivity(i);
    }

    private void goToFourthActivity() {
        Intent i= new Intent(this, com.example.lenovo.tourguide.Restaurants.MapsActivity.class);
        startActivity(i);
    }

    private void goToThirdActivity() {
        Intent i= new Intent(this, com.example.lenovo.tourguide.Beaches.MapsActivity.class);
        startActivity(i);
    }

    private void goToSecondActivity() {
        Intent i= new Intent(this, com.example.lenovo.tourguide.Hospitals.MapsActivity.class);
        startActivity(i);
    }

    private void goToFirstActivity() {
        Intent i= new Intent(this, MapsActivity.class);
        startActivity(i);
    }
}
