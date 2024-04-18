package com.example.moneyconverter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    public TextView textViewResult;
    public Button backButton, callButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textViewResult = findViewById(R.id.res);
        backButton = findViewById(R.id.backButton);
        callButton = findViewById(R.id.callButton);

        // Add click listener for back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                finish(); // Closes the current activity, effectively navigating back
            }
        });

        // Add click listener for call button
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                finish(); // Closes the current activity, effectively navigating back
            }
        });

        // Add click listener for call button
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace with the actual phone number
                String phoneNumber = "58250125";

                // Directly initiate call without permission check
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(callIntent);

                // Display toast message indicating call initiation
                Toast.makeText(MainActivity2.this, "Calling " + phoneNumber, Toast.LENGTH_SHORT).show();
            }
        });

        String conversionResult = getIntent().getStringExtra("conversionResult");
        textViewResult.setText(conversionResult);
    }
}
