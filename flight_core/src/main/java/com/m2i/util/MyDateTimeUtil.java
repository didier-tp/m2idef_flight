package com.m2i.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyDateTimeUtil {
    public static Date dateFromString(String strDate){
    	Date date = null;
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			date = format.parse(strDate);
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
    	return date;
    }
}
