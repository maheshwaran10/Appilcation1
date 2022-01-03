package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PrimeActivity extends AppCompatActivity {
    EditText editText;
    Button check,prime;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);

        editText=(EditText) findViewById(R.id.edit);
        check=(Button)findViewById(R.id.primeNumber);
        prime=(Button)findViewById(R.id.next);
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
                    boolean prime = true;
                    for (int i = 2; i < number; i++) {
                        if (number % i == 0) {
                            prime = false;
                            break;
                        }
                    }
                    if (prime == true) {
                        textView.setText("Prime Number");
                    } else {
                        textView.setText("Not a Prime Number ");
                    }
                }
            }
        });
        prime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),FibonacciActivity.class);
                startActivity(i);
            }
        });

    }
}