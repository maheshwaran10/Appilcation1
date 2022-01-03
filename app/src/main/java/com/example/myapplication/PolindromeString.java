package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PolindromeString extends AppCompatActivity {
    EditText editText;
    Button poliString,leap;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polindrome_string);

        editText=(EditText) findViewById(R.id.edit);
        poliString=(Button)findViewById(R.id.poliString);
        textView=(TextView) findViewById(R.id.textView);
        leap=(Button)findViewById(R.id.goToLeap);

        textView.setVisibility(View.GONE);

        poliString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = editText.getText().toString();
                String org_str=str;
                String rev="";
                int len=str.length();
                textView.setVisibility(View.VISIBLE);

                for(int i=len-1;i>=0;i--) {
                    rev=rev+str.charAt(i);
                }
                if (TextUtils.isEmpty(str)){
                    textView.setVisibility(View.GONE);
                    editText.setError("Please Enter Text");
                    return;
                }
                textView.setVisibility(View.VISIBLE);
                if(org_str.equals(rev))
                    textView.setText("Polindrome");
                else
                    textView.setText("Not a Polindrome");


            }
        });
        leap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent qw = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(qw);
            }
        });



    }
}