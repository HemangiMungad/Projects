package com.example.karan.DeepBlue;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.karan.DeepBlue.mapcativity.MapsActivity;
import com.example.karan.R;

public class MainActivity extends AppCompatActivity {
    private Button mDriver, mCustomer, mNumber,mEmergency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDriver = (Button) findViewById(R.id.driver);
        mCustomer = (Button) findViewById(R.id.customer);
        mNumber = (Button) findViewById(R.id.am);
        mEmergency= (Button) findViewById(R.id.em);
        startService(new Intent(MainActivity.this, onAppKilled.class));
        mDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VolunteerLoginActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        mCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BystanderLoginActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        mNumber.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:102"));
                startActivity(callIntent);

            }

        });
        mEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }
}
