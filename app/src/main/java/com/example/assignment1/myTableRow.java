package com.example.assignment1;


import android.annotation.SuppressLint;

import android.annotation.TargetApi;

import android.content.Context;

import android.content.res.TypedArray;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;

import android.util.AttributeSet;

import android.view.View;

import android.widget.ImageView;

import android.widget.RelativeLayout;

import android.widget.TableRow;
import android.widget.TextView;




public class myTableRow extends TableRow {

    private TextView t0,t1,t2,t3,t4,t5;
    public myTableRow(Context context) {
        this(context,null);
    }
    public myTableRow(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }
    public void inputData(int column, String s,boolean highlight,boolean hot) {
        int color = Color.WHITE;

        if(highlight){
            color = Color.CYAN;
        } else {
            if(hot) {
                color = Color.RED;
            } else {
                if (column % 2 == 1) {

                    color = 0XE0E0E0F0;
                } else {
                    color = 0xF0E0F0E0;
                }
            }
        }

//                System.out.println("**********************   "+column+" *******************");
//                System.out.println("**********************   "+highlight+" *******************");
//                System.out.println("**********************   "+s+" *******************");
        if(column ==1) {
            t1.setText(s);
            t1.setBackgroundColor(color);
        } else {
            if (column == 2) {
                t2.setText(s);
                t2.setBackgroundColor(color);
            } else {
                if (column == 3) {
                    t3.setText(s);
                    t3.setBackgroundColor(color);
                } else {
                    if (column == 4) {
                        t4.setText(s);
                        t4.setBackgroundColor(color);
                    } else {
                        if (column == 5) {
                            t5.setText(s);
                            t5.setBackgroundColor(color);
                        } else {
                            if (column == 0) {
                                t0.setText(s);
                                t0.setBackgroundColor(color);
                            }
                        }
                    }

                }
            }
        }

    }
    public myTableRow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        View child = View.inflate(getContext(), R.layout.my_table_row,null);

        addView(child);
        t0 = (TextView) findViewById(R.id.tab00);
        t1 = (TextView) findViewById(R.id.tab01);
        t2 = (TextView) findViewById(R.id.tab02);
        t3 = (TextView) findViewById(R.id.tab03);
        t4 = (TextView) findViewById(R.id.tab04);
        t5 = (TextView) findViewById(R.id.tab05);
    }
}
