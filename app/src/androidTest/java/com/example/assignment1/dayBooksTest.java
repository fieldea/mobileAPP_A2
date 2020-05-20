package com.example.assignment1;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class dayBooksTest {
    dayBooks dbs;

    @Before
    public void setUp() throws Exception {
        dbs = new dayBooks(5);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void bookTimeslot() {
        TestCase.assertEquals(true, dbs.bookTimeslot("A1", "Monday", 1));

        TestCase.assertEquals(false, dbs.bookTimeslot("A1", "Monday", 1));
        TestCase.assertEquals(false, dbs.bookTimeslot("A1", "Monday", 2));

        TestCase.assertEquals(true, dbs.bookTimeslot("A1", "Tuesday", 1));


        TestCase.assertEquals(true, dbs.bookTimeslot("B2", "Monday", 1));
        TestCase.assertEquals(true, dbs.bookTimeslot("C3", "Monday", 1));
        TestCase.assertEquals(true, dbs.bookTimeslot("D4", "Monday", 1));
        TestCase.assertEquals(true, dbs.bookTimeslot("E5", "Monday", 1));
        TestCase.assertEquals(true, dbs.bookTimeslot("F6", "Monday", 1));
        TestCase.assertEquals(true, dbs.bookTimeslot("G7", "Monday", 1));
        TestCase.assertEquals(true, dbs.bookTimeslot("H8", "Monday", 1));
        TestCase.assertEquals(true, dbs.bookTimeslot("I9", "Monday", 1));
        TestCase.assertEquals(true, dbs.bookTimeslot("J0", "Monday", 1));

        TestCase.assertEquals(false, dbs.bookTimeslot("K1", "Monday", 1));
        TestCase.assertEquals(true, dbs.bookTimeslot("K1", "Friday", 1));
//        TestCase.assertEquals(true, dbs.bookTimeslot("K1", "Friday", 1));
    }
}