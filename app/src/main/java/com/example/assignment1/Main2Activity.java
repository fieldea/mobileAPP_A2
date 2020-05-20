package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    searchDetails sd;
    private Button button0, button1,
            button2, button3, button4,
            button5, button6, button7,
            button8;
    private TextView et;
    String type = "day";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sd = new searchDetails();
        button0 =(Button) findViewById(R.id.button0);
        button1 =(Button) findViewById(R.id.button1);
        button2 =(Button) findViewById(R.id.button2);
        button3 =(Button) findViewById(R.id.button3);
        button4 =(Button) findViewById(R.id.button4);
        button5 =(Button) findViewById(R.id.button5);
        button6 =(Button) findViewById(R.id.button6);
        button7 =(Button) findViewById(R.id.button7);
        button8 =(Button) findViewById(R.id.button8);
        et = (TextView) findViewById(R.id.TextArea1);
        Intent it = getIntent();
        type = it.getStringExtra("type");
        if (type.equals("name")) {

//            button0.setVisibility(View.GONE);
//            button1.setVisibility(View.GONE);
//            button2.setVisibility(View.GONE);
//            button3.setVisibility(View.GONE);
//            button4.setVisibility(View.GONE);
//            button5.setVisibility(View.GONE);
//            button6.setVisibility(View.GONE);
//            button7.setVisibility(View.GONE);
//
//            button8.setVisibility(View.VISIBLE);
//            et.setVisibility(View.VISIBLE);
//            button8.setText("OK");
//
//            et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//                @Override
//                public void onFocusChange(View v, boolean hasFocus) {
//                    sd.name = "" + et.getText();
//                }
//            });
//            et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//                @Override
//                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                    sd.name = "" + et.getText();
//                    return false;
//                }
//            });
//            button8.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent it = getIntent();
//                    it.putExtra("name", sd.name);
//                    setResult(0x123,it);
//                    finish();
//                }
//            });

        } else if (type.equals("day")) {
            button6.setVisibility(View.GONE);
            button7.setVisibility(View.GONE);
            button8.setVisibility(View.GONE);

            et.setVisibility(View.VISIBLE);
            button0.setVisibility(View.VISIBLE);
            button1.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            button5.setVisibility(View.VISIBLE);

            et.setText("Select your day.");
            button0.setText("Monday");
            button1.setText("Tuesday");
            button2.setText("Wednesday");
            button3.setText("Thursday");
            button4.setText("Friday");
            button5.setText("Any");

            button0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = getIntent();
                    it.putExtra("day", 1);
                    setResult(0x234,it);
                    finish();
                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = getIntent();
                    it.putExtra("day", 2);
                    setResult(0x234,it);
                    finish();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = getIntent();
                    it.putExtra("day", 3);
                    setResult(0x234,it);
                    finish();
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = getIntent();
                    it.putExtra("day", 4);
                    setResult(0x234,it);
                    finish();
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = getIntent();
                    it.putExtra("day", 5);
                    setResult(0x234,it);
                    finish();
                }
            });
            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = getIntent();
                    it.putExtra("day", 0);
                    setResult(0x234,it);
                    finish();
                }
            });

        }   else if (type.equals("hour")) {

            et.setVisibility(View.VISIBLE);
            button0.setVisibility(View.VISIBLE);
            button1.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            button5.setVisibility(View.VISIBLE);
            button6.setVisibility(View.VISIBLE);
            button7.setVisibility(View.VISIBLE);
            button8.setVisibility(View.VISIBLE);

            et.setText("Select your time.");
            button0.setText("9:00-10:00");
            button1.setText("10:00-11:00");
            button2.setText("11:00-12:00");
            button3.setText("12:00-13:00");
            button4.setText("13:00-14:00");
            button5.setText("14:00-15:00");
            button6.setText("15:00-16:00");
            button7.setText("16:00-17:00");
            button8.setText("Any");

            button0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = getIntent();
                    it.putExtra("hour", 1);
                    setResult(0x345,it);
                    finish();
                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = getIntent();
                    it.putExtra("hour", 2);
                    setResult(0x345,it);
                    finish();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = getIntent();
                    it.putExtra("hour", 3);
                    setResult(0x345,it);
                    finish();
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = getIntent();
                    it.putExtra("hour", 4);
                    setResult(0x345,it);
                    finish();
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = getIntent();
                    it.putExtra("hour", 5);
                    setResult(0x345,it);
                    finish();
                }
            });
            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = getIntent();
                    it.putExtra("hour", 6);
                    setResult(0x345,it);
                    finish();
                }
            });
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = getIntent();
                    it.putExtra("hour", 7);
                    setResult(0x345,it);
                    finish();
                }
            });
            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = getIntent();
                    it.putExtra("hour", 8);
                    setResult(0x345,it);
                    finish();
                }
            });
            button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = getIntent();
                    it.putExtra("hour", 0);
                    setResult(0x345,it);
                    finish();
                }
            });
        }
    }

}
