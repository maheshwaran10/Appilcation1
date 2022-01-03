package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText editText;
    Button check,finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText=(EditText) findViewById(R.id.edit);
        check=(Button)findViewById(R.id.Odd);
        finish=(Button)findViewById(R.id.finish);


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter Number", Toast.LENGTH_SHORT).show();
                } else {
                    int number;
                    number = Integer.parseInt(editText.getText().toString());
                    if (number % 2 == 0) {
                        Toast.makeText(getApplicationContext(), " Entered Number is Even", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "  Entered Number is Odd", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });


    }
}