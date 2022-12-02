package com.jhart.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateComparer {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public String getElapsedTime(String start_date, String end_date) {
		log.debug("getElapsedTime start: " + start_date + " end: " + end_date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String result = null;

		try {
			Date d1 = sdf.parse(start_date);
			Date d2 = sdf.parse(end_date);

			long difference_In_Time = d2.getTime() - d1.getTime();

			long difference_In_Seconds = TimeUnit.MILLISECONDS.toSeconds(difference_In_Time) % 60;
			long difference_In_Minutes = TimeUnit.MILLISECONDS.toMinutes(difference_In_Time) % 60;
			long difference_In_Hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time) % 24;
			//long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;
			//long difference_In_Years = TimeUnit.MILLISECONDS.toDays(difference_In_Time) / 365l;

			StringBuilder sb = new StringBuilder();
			
//			if (difference_In_Years > 0) {
//				sb.append(" y: " + difference_In_Years);
//			}
			
//			if (difference_In_Days > 0) {
//				sb.append(" d: " + difference_In_Days);
//			}
			
			if (difference_In_Hours >=  0) {
				sb.append(difference_In_Hours + " : ");
			}
			
			if (difference_In_Minutes > 0) {
				sb.append( difference_In_Minutes + " : ");
			}
			
			sb.append(difference_In_Seconds);
			
			result = sb.toString();
			log.debug("getElapsedTime - elapsed time: " + result);

		} catch (ParseException e) {
			e.printStackTrace();
			//log.error(result)
		}
		
		return result;

	}
}