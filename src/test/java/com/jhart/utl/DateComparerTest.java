package com.jhart.utl;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.jhart.util.DateComparer;

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
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    	
    	String start_date = "28-11-2022 01:10:20";
    	String end_date = "28-11-2022 02:05:50";
    	
    	// then
    	DateComparer comparer = new DateComparer();
    	
    	String result = comparer.findDifference(start_date, end_date);
    	System.out.println("result: " + result);
    	assertNotNull(result);
    	
    }


}
