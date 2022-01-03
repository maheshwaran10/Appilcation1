package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class EbBillActivity extends AppCompatActivity {
    EditText customerName, customerNo, currentReading, select;
    TextView text;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eb_bill);
        customerName = (EditText) findViewById(R.id.name);
        customerNo = (EditText) findViewById(R.id.cusNo);
        currentReading = (EditText) findViewById(R.id.currReading);
        select = (EditText) findViewById(R.id.select_current);

        text = (TextView) findViewById(R.id.text);

        button = (Button) findViewById(R.id.check);
        text.setVisibility(View.GONE);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                double units, amount = 0;
                String cno, cname, select1;
                double current;
                cno = customerNo.getText().toString();
                cname = customerName.getText().toString();
                select1=select.getText().toString();
                if(cname.isEmpty()){
                    customerName.setError("Enter Name");
                    return;
                }
                else if(cno.isEmpty()){
                    customerNo.setError("Enter Customer Number");
                    return;
                }
                else if(currentReading.getText().toString().trim().isEmpty()){
                    currentReading.setError("Enter Reading");
                    return;
                }
                else if (select1.isEmpty()){
                    select.setError("Enter Customer Number");
                    return;
                }
                current=Double.parseDouble(currentReading.getText().toString());

                units=current;
                text.setVisibility(View.VISIBLE);

                if(select1.equalsIgnoreCase("D"))
                {
                    if(units<=100)
                        amount=0;
                    else if(units<=200)
                        amount = units*2;
                    else if (units<=500)
                        amount = units*4;
                    else
                        amount = units*6;
                }
                else if(select1.equalsIgnoreCase("C"))
                {
                    if(units<=0)
                        amount=0;
                    else if(units<=100)
                        amount = units*3;
                    else if(units<=200)
                        amount = units*4;
                    else if (units<=500)
                        amount = units*6;
                    else
                        amount = units*7;
                }
                text.setText("Customer Name :" +cname+"\n"+("Customer Number :" +cno+"\n")+
                        ("Current Month Reading :" +current+"\n")+
                        ("Bill amount:" +amount+"\n"));

            }
                 });
            }
        }

