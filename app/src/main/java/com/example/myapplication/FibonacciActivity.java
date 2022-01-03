package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FibonacciActivity extends AppCompatActivity {
    EditText editText;
    Button check,fibo;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci);
        editText=(EditText) findViewById(R.id.edit);
        check=(Button)findViewById(R.id.fiboNumber);
        fibo=(Button)findViewById(R.id.next);
        textView=(TextView) findViewById(R.id.textView);
        textView.setVisibility(View.GONE);

        check.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().trim().isEmpty()) {
                    textView.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Please Enter Number", Toast.LENGTH_SHORT).show();
                } else {
                    int number = Integer.parseInt(editText.getText().toString());
                    textView.setVisibility(View.VISIBLE);
                    String fib="";
                    int first=0;
                    int second=1;
                    int third;
                    for(int i=0;i<number;i++) {
                        third=first+second;
                        first=second;
                        second=third;
                        fib=fib+"\t"+first;
                    }
                    textView.setText(fib);

                }
            }
        });
        fibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(i);
            }
        });

    }
}