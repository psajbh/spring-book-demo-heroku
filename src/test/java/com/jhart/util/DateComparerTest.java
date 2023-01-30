package com.jhart.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DateComparerTest {
	
	DateComparer dateComparer;

    @BeforeEach
    void setUp() throws Exception {
    	dateComparer = new DateComparer();
    }

    @Test
    @DisplayName("DateComparer - test difference between dates")
    void testConvertToDatabaseColumn() throws Exception {
        // given
    	String start_date = "2023/01/30 17:53:20";
    	String end_date = "2023/01/30 17:59:40";
    	
    	// then
    	String result = dateComparer.getElapsedTime(start_date, end_date);
    	assertNotNull(result);
    	
    }
    
    @Test
    void testConvertLocalDateTimeToDate() {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    	Date date = new Date();
    	String strDate = sdf.format(date);
    	assertNotNull(strDate);
    }


}
