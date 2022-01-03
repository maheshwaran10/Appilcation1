package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SalesManActivity extends AppCompatActivity {
    EditText name,sales,salary;
    TextView text;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_man);

        name=(EditText) findViewById(R.id.name);
        sales=(EditText) findViewById(R.id.sales);
        salary=(EditText) findViewById(R.id.salary);

        text=(TextView) findViewById(R.id.text);

        button=(Button) findViewById(R.id.check);
        text.setVisibility(View.GONE);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int sale,salaryM,per;
                double com=0.0;
                double totSale;
                String name1;
                sale=Integer.parseInt(sales.getText().toString());
                salaryM=Integer.parseInt(salary.getText().toString());
                name1=name.getText().toString();
                text.setVisibility(View.VISIBLE);
                if(sale<=100000) {
                    per=3;
                    com=sale*3/100;
                    totSale= salaryM+com;

                }else if(sale<=200000) {
                    per=5;
                    com=sale*0.05;
                    totSale= salaryM+com;
                }else if(sale<=400000) {
                    per=10;
                    com=sale*0.10;
                    totSale= salaryM+com;
                }
                else {
                    per=15;
                    com=sale*0.15;
                    totSale= salaryM+com;
                }

                text.setText("SalesMan Name : "+ name1+"\n"+("SalesMan Salary : "+ salaryM+"\n")+("SalesMan Sales : "+ sale+"\n")+("Commission Amount is : "+ com+"\n")+("Total Salary : "+ totSale+"\n")+("Overall Commission Percentage is : "+ per +"%"));

            }
        });


    }
}