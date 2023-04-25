package com.jhart.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StringComparerTest {
	
	@Test
	void compareDoubleSort() {
		
		Double d1 = 1.12;
		Double d2 = 12.13;
		Double d3 = 3.56;
		Double d4 = .23;
		
		String sd1 = d1.toString();
		String sd2 = d2.toString();
		String sd3 = d3.toString();
		String sd4 = d4.toString();
		
		List<String> slist = new ArrayList<>();
		slist.add(sd1);
		slist.add(sd2);
		slist.add(sd3);
		slist.add(sd4);
		
		List<String> newList; //= new ArrayList<>();
		Collections.sort(slist);
		System.out.println(slist);
		System.out.println();
	}

	//https://stackoverflow.com/questions/19459235/sort-a-list-on-strings-based-on-a-double-value-in-java
}


/*
 * Collections.sort(yourList, new Comparator<String>() { public int
 * compare(String s1, String s2) { double d1 =
 * Double.valueOf(s1.substring(s1.lastIndexOf(' ') + 1)); double d2 =
 * Double.valueOf(s2.substring(s2.lastIndexOf(' ') + 1)); return
 * Double.compare(d1, d2); } });
 */