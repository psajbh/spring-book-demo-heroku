package com.jhart.util.word;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CharDisplayBuilderImpl implements CharDisplayBuilder {
	
	public String buildCharDisplay(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis) {
		StringBuilder sb = new StringBuilder();
		
		List<CharDisplay> charDisplay1 = charDisplayAnalysis.get(1);
		List<CharDisplay> charDisplay2 = charDisplayAnalysis.get(2);
		List<CharDisplay> charDisplay3 = charDisplayAnalysis.get(3);
		List<CharDisplay> charDisplay4 = charDisplayAnalysis.get(4);
		List<CharDisplay> charDisplay5 = charDisplayAnalysis.get(5);
		
		sb.append(System.getProperty("line.separator"));
		sb.append("Character 1 Analysis:");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		
		charDisplay1.forEach(charDisplay -> {
			String type = charDisplay.getCharType();
			String value = charDisplay.getValue();
			sb.append(" " + type + ": " + value + ", ");
		});
		sb.deleteCharAt(sb.length() - 2);
		
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		sb.append("Character 2 Analysis:");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		
		charDisplay2.forEach(charDisplay -> {
			String type = charDisplay.getCharType();
			String value = charDisplay.getValue();
			sb.append(" " + type + ": " + value + ", ");
		});
		
		sb.deleteCharAt(sb.length() - 2);
		
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		sb.append("Character 3 Analysis:");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));

		charDisplay3.forEach(charDisplay -> {
			String type = charDisplay.getCharType();
			String value = charDisplay.getValue();
			sb.append(" " + type + ": " + value + ", ");
		});
		
		sb.deleteCharAt(sb.length() - 2);
		
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		sb.append("Character 4 Analysis:");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));

		charDisplay4.forEach(charDisplay -> {
			String type = charDisplay.getCharType();
			String value = charDisplay.getValue();
			sb.append(" " + type + ": " + value + ", ");
		});
		
		sb.deleteCharAt(sb.length() - 2);
				
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		sb.append("Character 5 Analysis:");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));

		charDisplay5.forEach(charDisplay -> {
			String type = charDisplay.getCharType();
			String value = charDisplay.getValue();
			sb.append(" " + type + ": " + value + ", ");
		});
		
		sb.deleteCharAt(sb.length() - 2);
		
		System.out.println();
		return sb.toString();
	}
}
