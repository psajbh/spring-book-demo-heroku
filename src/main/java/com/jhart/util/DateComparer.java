package com.jhart.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateComparer {

	public String findDifference(String start_date, String end_date) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String result = null;

		try {
			Date d1 = sdf.parse(start_date);
			Date d2 = sdf.parse(end_date);

			long difference_In_Time = d2.getTime() - d1.getTime();

			long difference_In_Seconds = TimeUnit.MILLISECONDS.toSeconds(difference_In_Time) % 60;
			long difference_In_Minutes = TimeUnit.MILLISECONDS.toMinutes(difference_In_Time) % 60;
			long difference_In_Hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time) % 24;
			long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;
			long difference_In_Years = TimeUnit.MILLISECONDS.toDays(difference_In_Time) / 365l;

			StringBuilder sb = new StringBuilder();
			
			if (difference_In_Years > 0) {
				sb.append(difference_In_Years + " years, ");
			}
			
			if (difference_In_Days > 0) {
				sb.append(difference_In_Days + " days, ");
			}
			
			if (difference_In_Hours > 0) {
				sb.append(difference_In_Hours +	 " hours, ");
			}
			
			if (difference_In_Minutes > 0) {
				sb.append(difference_In_Minutes + " minutes, ");
			}
			
			sb.append(difference_In_Seconds + " seconds");
			result = sb.toString();

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return result;

	}
}