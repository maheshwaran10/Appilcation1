package com.example.myapplication.day5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.myapplication.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MultipleViewScrollActivity extends AppCompatActivity {
    private static final String[] COUNTRIES = new String[]{"Afghanistan", "Albania", "Algeria", "Andorra", "Angola"};
    String[] language = {"C", "C++", "Java", ".NET", "iPhone", "Android", "ASP.NET", "PHP","Python"};


    CheckBox pizza,coffe,burger;
    Button buttonOrder,show,load;
    RadioButton generateButton;
    RadioGroup radioGroup;
    ToggleButton toggleButton;
    CalendarView calendar;
    TextView date_view,seekText;
    SeekBar seekBar,seek2;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch sw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_view_scroll);
        CheckedTextView text = findViewById(R.id.simpleCheckedTextView);
        show = (Button) findViewById(R.id.select);
        pizza = (CheckBox) findViewById(R.id.pizza);
        coffe = (CheckBox) findViewById(R.id.coffee);
        burger = (CheckBox) findViewById(R.id.burger);
        buttonOrder = (Button) findViewById(R.id.order);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        toggleButton = findViewById(R.id.toggleButton);
        sw1 = findViewById(R.id.switch2);
        WebView browser = (WebView) findViewById(R.id.webview);
        load = findViewById(R.id.load);
        calendar = (CalendarView) findViewById(R.id.calendar);
        date_view = (TextView) findViewById(R.id.date_view);
        seekBar = (SeekBar) findViewById(R.id.seek);
        seekText = findViewById(R.id.seekText);
        seek2 = findViewById(R.id.sb);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, language);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.RED);

        //********************************************************************************************************************////
        MultiAutoCompleteTextView brandTextView = (MultiAutoCompleteTextView)
                findViewById(R.id.brand);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Brands);

        brandTextView.setAdapter(adapter1);
        brandTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        brandTextView.setOnItemClickListener(onItemClickListener);


        //********************************************************************************************************************////
        text.setCheckMarkDrawable(null);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setCheckMarkDrawable(R.drawable.checked);
            }
        });


        Chip chip1 = findViewById(R.id.chipCpp);
        chip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MultipleViewScrollActivity.this, "Action Completed", Toast.LENGTH_SHORT).show();
            }
        });

        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int totalamount = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected Items:");
                if (pizza.isChecked()) {
                    result.append("\nPizza 100Rs");
                    totalamount += 100;
                }
                if (coffe.isChecked()) {
                    result.append("\nCoffee 50Rs");
                    totalamount += 50;
                }
                if (burger.isChecked()) {
                    result.append("\nBurger 120Rs");
                    totalamount += 120;
                }
                result.append("\nTotal: " + totalamount + "Rs");
                //Displaying the message on the toast
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                generateButton = (RadioButton) findViewById(selectedId);
                if (selectedId == -1) {
                    Toast.makeText(MultipleViewScrollActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MultipleViewScrollActivity.this, "Selected Gender is " + generateButton.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MultipleViewScrollActivity.this, "Turn on", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MultipleViewScrollActivity.this, "Turn off", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MultipleViewScrollActivity.this, "Enable", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MultipleViewScrollActivity.this, "DisEnable", Toast.LENGTH_SHORT).show();
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This is Sample message in Snack Bar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                browser.loadUrl("http://www.google.com");
            }
        });
        calendar.setOnDateChangeListener(
                new CalendarView
                        .OnDateChangeListener() {
                    @Override

                    // In this Listener have one method
                    // and in this method we will
                    // get the value of DAYS, MONTH, YEARS
                    public void onSelectedDayChange(
                            @NonNull CalendarView view,
                            int year,
                            int month,
                            int dayOfMonth) {

                        // Store the value of date with
                        // format in String type Variable
                        // Add 1 in month because month
                        // index is start with 0
                        String Date
                                = dayOfMonth + "-"
                                + (month + 1) + "-" + year;

                        // set this date in TextView for Display
                        date_view.setText(Date);
                    }
                });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pval = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pval = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekText.setText(pval + "/" + seekBar.getMax());
            }
        });

        seek2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar,
                                          int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(MultipleViewScrollActivity.this,
                            "Clicked item from auto completion list "
                                    + adapterView.getItemAtPosition(i)
                            , Toast.LENGTH_SHORT).show();
                }
            };

    private static final String[] Brands = new String[]{
            "Nike", "Adidas", "Reebok", "Puma", "RF", "Polo",
            "Tommy", "Nautica", "Boss", "Spin", "Narwa", "Nivia"
    };


    //***************************************************************************************************************////




}
