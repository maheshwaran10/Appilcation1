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

public class PolindromeNumber extends AppCompatActivity {
    EditText editText;
    Button poliNumber,poliString;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polindrome_number);

        editText=(EditText) findViewById(R.id.edit);
        poliNumber=(Button)findViewById(R.id.poliNumber);
        textView=(TextView) findViewById(R.id.textView);
        poliString=(Button)findViewById(R.id.polindromeString);
        textView.setVisibility(View.GONE);


        poliNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().trim().isEmpty()){
                    textView.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),"Please Enter Number",Toast.LENGTH_SHORT).show();
                }else{
                    int number= Integer.parseInt(editText.getText().toString());
                    int org_num=number;
                    int rev=0;
                    while(number>0) {
                        rev=(rev*10)+number%10;
                        number =number/10;
                    }

                    textView.setVisibility(View.VISIBLE);

                    if(org_num==rev)
                        textView.setText("Polindrome number");
                    else
                        textView.setText("Not a Polindrome number");

                }
            }
            
            
        });
        poliString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PolindromeString.class);
                startActivity(i);
            }
        });
    }
}