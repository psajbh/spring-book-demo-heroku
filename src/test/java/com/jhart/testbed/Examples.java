package com.jhart.testbed;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class Examples {

	@Test
	public void testDateExamples() {
		//LocalDate date1 = LocalDate.of(2014, 9, 11);
		//System.out.println(date1);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String dateInString = "2022/1/9";
        
        try {

            Date date = formatter.parse(dateInString);
            System.out.println(date);
            //System.out.println(formatter.format(date));
            String result = formatter.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

		//LocalDate date2 = LocalDate.parse("2022/11/9");
		//System.out.println(date2);
		//LocalDate date3 = LocalDate.now();
		//System.out.println(date3);
	}
}
