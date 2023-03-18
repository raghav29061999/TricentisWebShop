package com.crm.qa.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Functions {
	
	public static int randomNumber(int min, int max) {	
		
		return (int)(Math.random()*(max-min+1)+min);
	
	}
	
	public static String dateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMdd"+"_HHmmss"); 
		return dtf.format(LocalDateTime.now()).toString();
	}
	
	public static String randomPassword(int length) {
		
		String alphanumeric="ABCDEFGHIJKLMNOPQRSTUVWXYZabcedefghijklmnopqurstuvwxyz";
		StringBuilder s = new StringBuilder(length);
		
		for(int i =0 ; i<alphanumeric.length();i++)
		{
			  int ch = (int)(alphanumeric.length() * Math.random());
			  s.append(alphanumeric.charAt(ch));
			  
		}
		
		return s.toString();
	}
	
	
}




