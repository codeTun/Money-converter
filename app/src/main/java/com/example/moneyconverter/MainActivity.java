package com.example.moneyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumberDecimal;
    private RadioGroup radioGroup;
    private TextView textView2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumberDecimal = findViewById(R.id.editTextNumberDecimal);
        radioGroup = findViewById(R.id.radioGroup);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

                if (selectedRadioButtonId == R.id.radio_one) {
                    convertEuroToDinar();
                } else if (selectedRadioButtonId == R.id.radio_two) {
                    convertDinarToEuro();
                }
            }

            public void convertEuroToDinar() {
                float amount = Float.parseFloat(editTextNumberDecimal.getText().toString());
                float convertedAmount = amount * 3;

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("conversionResult", String.valueOf(convertedAmount));
                startActivity(intent);
            }

            public void convertDinarToEuro() {
                float amount = Float.parseFloat(editTextNumberDecimal.getText().toString());
                float convertedAmount = amount / 3;

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("conversionResult", String.valueOf(convertedAmount));
                startActivity(intent);
            }
        });
    }
}
