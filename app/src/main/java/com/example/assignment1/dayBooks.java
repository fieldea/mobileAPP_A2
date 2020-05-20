package com.example.assignment1;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class dayBooks {
    String[] zone = {"none","9:00-10:00","10:00-11:00","11:00-12:00","12:00-13:00","13:00-14:00","14:00-15:00","15:00-16:00","16:00-17:00"};
    String[] weekdays = {"Sunday", "Monday", "Tuesday","Wednesday","Thursday","Friday","Saturday"};
    private boolean booking(int day, int hour, String name) {
        if(name.equals("")){
            return false;
        } else {
            if(day<1 || day>5 || hour<1 || hour> 8){
                return false;
            } else {
                if(db[day-1].bs[hour-1].sum() >= 10) {
                    return false;
                } else {
                    for (int j=0; j<8; j++) {
                        for(int k=0;k<db[day-1].bs[j].bm.size();k++) {
                            if(name.equals(db[day-1].bs[j].bm.get(k).userName)) {
                                return false;
                            }
                        }
                    }
                    db[day-1].bs[hour-1].bm.add(new bookItem(name));
                    return true;
                }
            }
        }
    }
    public boolean bookTimeslot(String licenceNumber,String day,int hour){
        int d = 0;
        if(day.equals("Monday")) {
            d = 1;
        } else if(day.equals("Tuesday")) {
            d = 2;
        } else if(day.equals("Wednesday")) {
            d = 3;
        } else if(day.equals("Thursday")) {
            d = 4;
        } else if(day.equals("Friday")) {
            d = 5;
        }
        return booking(d, hour, licenceNumber);
    }
    public List<String> getTimeslotBooking(String licenceNumber) {
        List<String> ls = new ArrayList<String>();
        boolean found = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                boolean nameMatch = false;
                for (int k = 0; k < db[i].bs[j].bm.size(); k++) {
                    if (licenceNumber.equals(db[i].bs[j].bm.get(k).userName)) {
                        nameMatch = true;
                    }
                }
                if (nameMatch) {
                    found = true;
                    ls.add(weekdays[i+1]+" "+zone[j+1]);
                }
            }
        }
        return ls;
    }
    public List<String> getSlots (String day) {
        List<String> ls = new ArrayList<String>();
        int d = 1;
        if(day.equals("Monday")) {
            d = 1;
        } else if(day.equals("Tuesday")) {
            d = 2;
        } else if(day.equals("Wednesday")) {
            d = 3;
        } else if(day.equals("Thursday")) {
            d = 4;
        } else if(day.equals("Friday")) {
            d = 5;
        }
        for (int j = 0; j < 8; j++) {
            ls.add(zone[j+1]+" "+db[d-1].bs[j].sum());
        }
        return ls;
    }

    public dayBook[] db;
    dayBooks(int n) {
        db = new dayBook[n];
        for(int i=0; i < n; i++) {
            db[i] = new dayBook();
            db[i].day = i+1;
        }
    }
    class bookSlot {
        public int hour = 0;
        public List<bookItem> bm;
        public int sum () {
            return bm.size();
        }
        boolean highlight = false;
        bookSlot () {
            bm = new ArrayList<>();
        }
    }
    class dayBook {
        public int day = 0;
        public bookSlot[] bs;
        dayBook () {
            bs = new bookSlot[8];
            for (int j = 0; j < 8; j++) {
                bs[j] = new bookSlot();
                bs[j].hour = j+1;
            }
        }
    }
}
