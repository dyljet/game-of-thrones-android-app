package com.example.gameofquestions.TheoryPagE;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TheoryDate {

    public static String dateFromLong(long time){

        DateFormat format = new SimpleDateFormat( "EEE, dd MMM yyy 'at' hh:mm aaa", Locale.UK);
        return format.format(new Date(time));

    }
}
