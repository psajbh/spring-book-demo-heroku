package com.jhart.util.word;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CharDisplayBuilderImpl implements CharDisplayBuilder {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private static final String THREE_SPACER = "--";
	private static final String FOUR_SPACER = "---";
	private static final String FIVE_SPACER = "----";
	private static final String SIX_SPACER = "-----";
	private static final String SEVEN_SPACER = "------";
	
	private static final int PERCENT_LENGTH_6 = 6;
	private static final int PERCENT_LENGTH_7 = 7;
	
	private static final String CHAR1 = " Char 1";
	private static final String CHAR2 = " Char 2";
	private static final String CHAR3 = " Char 3";
	private static final String CHAR4 = " Char 4";
	private static final String CHAR5 = " Char 5";
	
	private static final String LINE_SEP = "line.separator";

	public String buildCharDisplay1(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis) {
		StringBuilder sb = new StringBuilder();
		List<CharDisplay> charDisplay1;
		
		try {
			charDisplay1 = charDisplayAnalysis.get(1);
		}
		catch(Exception e) {
			sb.append("Invalid submission. No charactor 1 data matches to submission data");
			return sb.toString();
		}

		int totalDisplay1Chars = 0;

		for (int i = 0; i < charDisplay1.size(); i++) {
			totalDisplay1Chars += charDisplay1.get(i).getIntValue();
		}

		for (int i = 0; i < charDisplay1.size(); i++) {
			CharDisplay charDisplay = charDisplay1.get(i);
			charDisplay.setTotalDisplayChars(totalDisplay1Chars);
		}
		
		sb.append(CHAR1 + System.getProperty(LINE_SEP));

		charDisplay1.forEach(charDisplay -> {
			String charType = charDisplay.getCharType(); 
			String percent = String.format("%.2f", charDisplay.getPercent()) + "% ";
			String formmatedCharType = formatCharTypePercent(charType, percent);
			sb.append(formmatedCharType);
		});
		
		return sb.toString();
	}

	public String buildCharDisplay2(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis) {
		StringBuilder sb = new StringBuilder();
		List<CharDisplay> charDisplay2; 
		
		try {
			charDisplay2 = charDisplayAnalysis.get(2);
		}
		catch(Exception e) {
			sb.append("Invalid submission. No charactor 2 data matches to submission data");
			return sb.toString();
		}

		int totalDisplay2Chars = 0;

		for (int i = 0; i < charDisplay2.size(); i++) {
			totalDisplay2Chars += charDisplay2.get(i).getIntValue();
		}

		for (int i = 0; i < charDisplay2.size(); i++) {
			CharDisplay charDisplay = charDisplay2.get(i);
			charDisplay.setTotalDisplayChars(totalDisplay2Chars);
		}

		sb.append(CHAR2 + System.getProperty(LINE_SEP));
		
		charDisplay2.forEach(charDisplay -> {
			String charType = charDisplay.getCharType();
			String percent = String.format("%.2f", charDisplay.getPercent()) + "% ";
			String formmatedCharType = formatCharTypePercent(charType, percent);
			sb.append(formmatedCharType);
		});
		
		return sb.toString();
	}

	public String buildCharDisplay3(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis) {
		StringBuilder sb = new StringBuilder();
		List<CharDisplay> charDisplay3;
		
		try {
			charDisplay3 = charDisplayAnalysis.get(3);
		}
		catch(Exception e) {
			sb.append("Invalid submission. No charactor 3 data matches to submission data");
			return sb.toString();
		}

		int totalDisplay3Chars = 0;

		for (int i = 0; i < charDisplay3.size(); i++) {
			totalDisplay3Chars += charDisplay3.get(i).getIntValue();
		}

		for (int i = 0; i < charDisplay3.size(); i++) {
			CharDisplay charDisplay = charDisplay3.get(i);
			charDisplay.setTotalDisplayChars(totalDisplay3Chars);
		}

		sb.append(CHAR3 + System.getProperty(LINE_SEP));
		
		charDisplay3.forEach(charDisplay -> {
			String charType = charDisplay.getCharType();
			String percent = String.format("%.2f", charDisplay.getPercent()) + "% ";
			String formmatedCharType = formatCharTypePercent(charType, percent);
			sb.append(formmatedCharType);
		});

		return sb.toString();
	}

	public String buildCharDisplay4(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis) {
		StringBuilder sb = new StringBuilder();
		List<CharDisplay> charDisplay4;
		
		try {
			charDisplay4 = charDisplayAnalysis.get(4);
		}
		catch(Exception e) {
			sb.append("Invalid submission. No charactor 4 data matches to submission data");
			return sb.toString();
		}

		int totalDisplay4Chars = 0;

		for (int i = 0; i < charDisplay4.size(); i++) {
			totalDisplay4Chars += charDisplay4.get(i).getIntValue();
		}

		for (int i = 0; i < charDisplay4.size(); i++) {
			CharDisplay charDisplay = charDisplay4.get(i);
			charDisplay.setTotalDisplayChars(totalDisplay4Chars);
		}

		sb.append(CHAR4 + System.getProperty(LINE_SEP));

		charDisplay4.forEach(charDisplay -> {
			String charType = charDisplay.getCharType();
			String percent = String.format("%.2f", charDisplay.getPercent()) + "% ";
			String formmatedCharType = formatCharTypePercent(charType, percent);
			sb.append(formmatedCharType);
		});
		
		return sb.toString();
	}

	public String buildCharDisplay5(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis) {
		StringBuilder sb = new StringBuilder();
		List<CharDisplay> charDisplay5;
		
		try {
			charDisplay5 = charDisplayAnalysis.get(5);
		}
		catch(Exception e) {
			sb.append("Invalid submission. No charactor 5 data matches to submission data");
			return sb.toString();
		}

		int totalDisplay5Chars = 0;

		for (int i = 0; i < charDisplay5.size(); i++) {
			totalDisplay5Chars += charDisplay5.get(i).getIntValue();
		}

		for (int i = 0; i < charDisplay5.size(); i++) {
			CharDisplay charDisplay = charDisplay5.get(i);
			charDisplay.setTotalDisplayChars(totalDisplay5Chars);
		}

		sb.append(CHAR5 + System.getProperty(LINE_SEP));

		charDisplay5.forEach(charDisplay -> {
			String charType = charDisplay.getCharType();
			String percent = String.format("%.2f", charDisplay.getPercent()) + "% ";
			String formmatedCharType = formatCharTypePercent(charType, percent);
			sb.append(formmatedCharType);
		});

		return sb.toString();
	}

	private String formatCharTypePercent(String charType, String percent) {
		if (percent.length() ==  PERCENT_LENGTH_6) {
			if (charType.equals("m") || charType.equals("w")) {
				charType = charType + FIVE_SPACER;
			}
			
			if (charType.equals("a") || charType.equals("b") || charType.equals("c") 
				|| charType.equals("d") || charType.equals("e") || charType.equals("g") 
				|| charType.equals("h") || charType.equals("k") || charType.equals("n") 
				|| charType.equals("o") || charType.equals("p") || charType.equals("q") 
				|| charType.equals("r") || charType.equals("s") || charType.equals("u") 
				|| charType.equals("v") || charType.equals("x") || charType.equals("y") 
				|| charType.equals("z")) {
				charType = charType + SIX_SPACER;
			}
			
			if (charType.equals("f") || charType.equals("l") || charType.equals("j")
					|| charType.equals("i") || charType.equals("t")) {
				charType = charType + SEVEN_SPACER;	
			}
		}
		
		if (percent.length() ==  PERCENT_LENGTH_7) {
			if (charType.equals("a") || charType.equals("b") || charType.equals("c") || charType.equals("d")				
				|| charType.equals("e") || charType.equals("g") || charType.equals("h")  
				|| charType.equals("j") || charType.equals("k") || charType.equals("m") || charType.equals("n") 
				|| charType.equals("o") || charType.equals("p") || charType.equals("q") 
				|| charType.equals("s") 
				|| charType.equals("u") || charType.equals("v") 
				|| charType.equals("x") || charType.equals("y") || charType.equals("z")) {
				charType = charType + FOUR_SPACER;	
			}
			if (charType.equals("f") ||  charType.equals("i") || charType.equals("l") || charType.equals("r") 
				|| charType.equals("t")) {
				charType = charType + FIVE_SPACER;	
			}
			if (charType.equals("m") || charType.equals("w")) {
				charType = charType + THREE_SPACER;
			}
		}
		
		if (percent.length() >  PERCENT_LENGTH_7) {
			charType = charType + THREE_SPACER;
		}
		
		return charType + percent + System.getProperty(LINE_SEP);
		
	}


}
