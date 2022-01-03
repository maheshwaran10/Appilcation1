package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ArmstrongNumberActivity extends AppCompatActivity {
    EditText editText;
    Button check,odd;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armstrong_number);
        editText=(EditText) findViewById(R.id.edit);
        check=(Button)findViewById(R.id.armNumber);
        odd=(Button)findViewById(R.id.next);
        textView=(TextView) findViewById(R.id.textView);
        textView.setVisibility(View.GONE);


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().trim().isEmpty()) {
                    textView.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Please Enter Number", Toast.LENGTH_SHORT).show();
                } else {
                    int number = Integer.parseInt(editText.getText().toString());
                    textView.setVisibility(View.VISIBLE);
                    int org_num = number;
                    int arm = 0;
                    int rem;

                    while (number > 0) {
                        rem = number % 10;
                        arm = arm + (rem * rem * rem);
                        number = number / 10;

                        // 0, 1,153, 370, 371, 407
                    }
                    if (org_num == arm) {
                        textView.setText("Armstrong Number");
                    } else {
                        textView.setText("Not an Armstrong Number");
                    }
                }
            }
        });
        odd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),PrimeActivity.class);
                startActivity(i);
            }
        });

    }
}