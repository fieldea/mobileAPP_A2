package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;


//class bookItem {
//    public bookItem(String s) {
//        this.userName = s;
//    };
//    public  String userName = "";
//}
//class bookSlot {
//    public int hour = 0;
//    public List<bookItem> bm;
//    public int sum () {
//        return bm.size();
//    }
//    boolean highlight = false;
//    bookSlot () {
//        bm = new ArrayList<>();
//    }
//}
//class dayBook {
//    public int day = 0;
//    public bookSlot[] bs;
//    dayBook () {
//        bs = new bookSlot[8];
//        for (int j = 0; j < 8; j++) {
//            bs[j] = new bookSlot();
//            bs[j].hour = j+1;
//        }
//    }
//}
public class MainActivity extends AppCompatActivity {

//    int[] zone = {9, 10 , 11, 12, 13, 14, 15, 16};
    String[] zone = {"none","9:00-10:00","10:00-11:00","11:00-12:00","12:00-13:00","13:00-14:00","14:00-15:00","15:00-16:00","16:00-17:00"};
    String[] weekdays = {"Sunday", "Monday", "Tuesday","Wednesday","Thursday","Friday","Saturday"};
//    daybooks.dayBook[] db;
    dayBooks dbs;
    searchDetails sd;
    boolean highlightOn;
    private EditText tv1;
    private EditText tv2;
    private EditText tv3;
    private TextView tv4;
    private myTableRow[] trs;
//    private TextView[][] tabs;

    private TextView b1, b2;

    private void render() {

        if(!(sd.day == 0)) {
            tv1.setText("" + weekdays[sd.day]);
        } else {
            tv1.setText("");
        }
        if(!(sd.hour == 0)) {
            tv2.setText("" + zone[sd.hour]);
        } else {
            tv2.setText("");
        }
        if(!sd.name.equals("")) {
            tv3.setText("" + sd.name);
        } else {
            tv3.setText("");
        }
        trs[0].inputData(0, "", false, false);
        trs[0].inputData(1, "  Mon", false, false);
        trs[0].inputData(2, "  Tue", false, false);
        trs[0].inputData(3, "  Wed", false, false);
        trs[0].inputData(4, "  Thu", false, false);
        trs[0].inputData(5, "  Fri", false, false);
        for (int j = 1; j <= 8; j++) {
            trs[j].inputData(0, " "+zone[j], false, false);
            for (int i = 1; i <= 5; i++) {
                if(dbs.db[i-1].bs[j-1].sum() >= 8) {
                    trs[j].inputData(i, "   "+dbs.db[i-1].bs[j-1].sum(),dbs.db[i-1].bs[j-1].highlight && highlightOn, true);
                } else {
                    trs[j].inputData(i, "   "+dbs.db[i-1].bs[j-1].sum(),dbs.db[i-1].bs[j-1].highlight && highlightOn, false);
                }

            }
        }
    }
    public void test() {
        //        *******************************************
        booking(1,1,"A1");
        booking(1,1,"B2");
        booking(1,1,"C3");
        booking(1,1,"D4");
        booking(1,1,"E5");
        booking(1,1,"F6");
        booking(1,1,"G7");
        booking(1,1,"H8");
        booking(1,1,"I9");
        booking(1,1,"J0");


        booking(2,2,"A1");
        booking(2,2,"B2");
        booking(2,2,"C3");
        booking(2,2,"D4");
        booking(2,2,"E5");
        booking(2,2,"F6");
        booking(2,2,"G7");
        booking(2,2,"H8");
        booking(2,2,"I9");
        booking(2,3,"J0");


        booking(1,1,"A1");
        booking(1,2,"A1");
        booking(3,1,"A1");
        tv4.setText("");
        tv4.setBackgroundColor(0xFFFAFAFA);
        List<String> ls1 = dbs.getTimeslotBooking("A1");
        for(int k=0;k<ls1.size();k++) {
            Log.d("getTimeslotBooking","*********************  "+ls1.get(k));
        }
        List<String> ls2 = dbs.getSlots("Tuesday");
        for(int k=0;k<ls2.size();k++) {
            Log.d("getSlots","*********************  "+ls2.get(k));
        }

//        *******************************************
    }
    private boolean checking() {
        boolean found = false;
        if(sd.day<0 || sd.day>5 || sd.hour<0 || sd.hour> 8){
            tv4.setText("    invalid date!");
            tv4.setBackgroundColor(Color.RED);
            return false;
        } else {
            if (sd.name.equals("") && sd.hour == 0 && sd.day == 0) {
                found = true;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 8; j++) {
                        dbs.db[i].bs[j].highlight = false;
                    }
                }
                return true;
            } else {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 8; j++) {
                        boolean timeMatch = false;
                        boolean nameMatch = false;
                        if (sd.name.equals("")) {
                            nameMatch = true;
                        } else {
                            for (int k = 0; k < dbs.db[i].bs[j].bm.size(); k++) {
                                if (sd.name.equals(dbs.db[i].bs[j].bm.get(k).userName)) {
                                    nameMatch = true;
                                }
                            }
                        }
                        if (sd.hour == 0 && sd.day == 0) {
                            System.out.println("***********************This is 1");
                            timeMatch = true;
                        } else {
                            if ((sd.day == 0 || dbs.db[i].day == sd.day) && (sd.hour == 0 || dbs.db[i].bs[j].hour == sd.hour)) {
                                System.out.println("***********************This is 2");
                                timeMatch = true;
                            }
                        }
                        if (timeMatch && nameMatch) {
                            dbs.db[i].bs[j].highlight = true;
                            found = true;
                            tv4.setText("    The booking(s) is highlighted.");
                        } else  {
                            dbs.db[i].bs[j].highlight = false;
                        }
                    }
                }
            }
        }
        highlightOn = true;
        if(!found) {
            tv4.setText("    There is no result.");
            tv4.setBackgroundColor(Color.GRAY);
        }
        render();
        return true;
    }
    private boolean booking(int day, int hour, String name) {
        highlightOn = false;
        if(name.equals("")){
            tv4.setText("    invalid licence!");
            tv4.setBackgroundColor(Color.RED);
            render();
            return false;
        } else {
            if(day<1 || day>5 || hour<1 || hour> 8){
                tv4.setText("    invalid date!");
                tv4.setBackgroundColor(Color.RED);
                render();
                return false;
            } else {
                if(dbs.db[day-1].bs[hour-1].sum() >= 10) {
                    tv4.setText("    It is full.");
                    tv4.setBackgroundColor(Color.CYAN);
                    render();
                    return false;
                } else {
                    for (int j=0; j<8; j++) {
                        for(int k=0;k<dbs.db[day-1].bs[j].bm.size();k++) {
                            if(name.equals(dbs.db[day-1].bs[j].bm.get(k).userName)) {
                                tv4.setText("    You cannot make more than 1 booking in one day");
                                tv4.setBackgroundColor(Color.CYAN);
                                render();
                                return false;
                            }
                        }
                    }
                    dbs.db[day-1].bs[hour-1].bm.add(new bookItem(name));
                    tv4.setText("");
                    tv4.setText("    Your booking is successful");
                    tv4.setBackgroundColor(Color.GREEN);
                    render();
                    return true;
                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = new dayBooks(5);
        sd = new searchDetails();
        highlightOn = false;
        tv1 = (EditText) findViewById(R.id.textView);
        tv2 = (EditText) findViewById(R.id.textView2);
        tv3 = (EditText) findViewById(R.id.textView3);
        tv4 = (TextView) findViewById(R.id.textView4);
        tv4.setBackgroundColor(0xFFFAFAFA);
        b1 = (TextView) findViewById(R.id.button);
        b1.setBackgroundColor(0XE0E0F0F0);
        b2 = (TextView) findViewById(R.id.button2);
        b2.setBackgroundColor(0XE0E0F0F0);
        trs = new myTableRow[9];
        trs[1] = (myTableRow) findViewById(R.id.row01);
        trs[2] = (myTableRow) findViewById(R.id.row02);
        trs[3] = (myTableRow) findViewById(R.id.row03);
        trs[4] = (myTableRow) findViewById(R.id.row04);
        trs[5] = (myTableRow) findViewById(R.id.row05);
        trs[6] = (myTableRow) findViewById(R.id.row06);
        trs[7] = (myTableRow) findViewById(R.id.row07);
        trs[8] = (myTableRow) findViewById(R.id.row08);
        trs[0] = (myTableRow) findViewById(R.id.row00);
//        tabs = new TextView[8][5];
//        for(int i=0; i<8; i++) {
//            for(int j=0; j<5; j++) {
//                tabs[i][j] = (TextView) findViewById(R.id.);;
//            }
//        }
//        for (int i = 0; i < 5; i++) {
//            db[i] = new daybooks.dayBook();
//            db[i].day = i+1;
//        }
        render();
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv4.setText("");
                tv4.setBackgroundColor(0xFFFAFAFA);
                Main2Activity m2 = new Main2Activity();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("type", "day");
                startActivityForResult(intent, 0x234);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv4.setText("");
                tv4.setBackgroundColor(0xFFFAFAFA);
                Main2Activity m2 = new Main2Activity();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("type","hour");
                startActivityForResult(intent, 0x345);
            }
        });
        tv3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                sd.name = tv3.getText().toString();
                tv4.setText("");
                tv4.setBackgroundColor(0xFFFAFAFA);
            }
        });
        tv3.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                sd.name = tv3.getText().toString();
                tv4.setText("");
                tv4.setBackgroundColor(0xFFFAFAFA);
                return false;
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv4.setText("");
                tv4.setBackgroundColor(0xFFFAFAFA);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checking();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                booking(sd.day, sd.hour, sd.name);
            }
        });

        test();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == 0x123 && resultCode == 0x123)
//        {
//            sd.name = data.getStringExtra("name");
//            render();
//        }
        if(requestCode == 0x234 && resultCode == 0x234)
        {
            sd.day = data.getIntExtra("day", 0);
            render();
        }
        if(requestCode == 0x345 && resultCode == 0x345)
        {
            sd.hour = data.getIntExtra("hour", 0);
            render();
        }
    }
}
