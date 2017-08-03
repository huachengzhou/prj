package com.blake.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtil {
	/**
	 * @see format:date and sex isload
	 * @param text
	 * @return
	 */
    public static Date format(String text){
    	ParsePosition pos = new ParsePosition(0);
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = format.parse(text, pos);
    	return date;
    }
    
    public static boolean format(Integer num){
    	boolean flag = false;
    	if(num==1){
    		flag = true;
    	}
    	return flag;
    }
}
