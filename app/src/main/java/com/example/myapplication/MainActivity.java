package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button leap,arm;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText) findViewById(R.id.edit);
        leap=(Button)findViewById(R.id.leap);
        textView=(TextView) findViewById(R.id.textView);
        arm=(Button)findViewById(R.id.armCheck);

        textView.setVisibility(View.GONE);
        leap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().trim().isEmpty()) {
                        textView.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), "Please Enter Year", Toast.LENGTH_SHORT).show();

                } else {
                    int year;
                    year = Integer.parseInt(editText.getText().toString());
                    textView.setVisibility(View.VISIBLE);
                    if (year % 4 == 0) {
                        if (year % 100 == 0) {
                            if (year % 400 == 0) {
                                textView.setText("Specified  year is Leap year");
                            } else {
                                textView.setText("Specified  year is  Not an Leap year");
                            }
                        }
                    } else {
                        textView.setText("Specified  year is  Not an Leap year");
                    }
                }
            }
        });
        arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),ArmstrongNumberActivity.class);
                startActivity(i);
            }
        });
    }
}