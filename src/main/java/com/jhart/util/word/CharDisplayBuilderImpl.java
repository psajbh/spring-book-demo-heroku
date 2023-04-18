package com.jhart.util.word;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jhart.dto.CharDisplayDto;

@Component
public class CharDisplayBuilderImpl implements CharDisplayBuilder {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public List<CharDisplayDto> buildCharDisplayDto1(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis) {
		log.info("CharDisplayBuilderImpl - buildCharDisplayDto1");
		List<CharDisplayDto> response = new ArrayList<>();
		List<CharDisplay> charDisplay1 = charDisplayAnalysis.get(1);

		int totalDisplay1Chars = 0;

		for (int i = 0; i < charDisplay1.size(); i++) {
			totalDisplay1Chars += charDisplay1.get(i).getIntValue();
		}

		for (int i = 0; i < charDisplay1.size(); i++) {
			CharDisplay charDisplay = charDisplay1.get(i);
			charDisplay.setTotalDisplayChars(totalDisplay1Chars);
			log.info("percent: " + charDisplay.getPercent());
		}

		charDisplay1.forEach(charDisplay -> {
			CharDisplayDto charDisplayDto = new CharDisplayDto();
			String charType = charDisplay.getCharType() + " -   ";
			charDisplayDto.setCharacter(charType);

			String percent = String.format("%.2f", charDisplay.getPercent()) + "% ";
			if (percent.length() == 5) {
				percent = " " + percent;
			}

			charDisplayDto.setPercent(percent);
			response.add(charDisplayDto);
		});

		return response;
	}

	public String buildCharDisplay1(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis) {
		log.info("CharDisplayBuilderImpl - buildCharDisplay1");
		StringBuilder sb = new StringBuilder();
		List<CharDisplay> charDisplay1 = charDisplayAnalysis.get(1);

		log.info("CharDisplayBuilderImpl - buildCharDisplay - charDisplay1");
		int totalDisplay1Chars = 0;

		for (int i = 0; i < charDisplay1.size(); i++) {
			totalDisplay1Chars += charDisplay1.get(i).getIntValue();
		}

		for (int i = 0; i < charDisplay1.size(); i++) {
			CharDisplay charDisplay = charDisplay1.get(i);
			charDisplay.setTotalDisplayChars(totalDisplay1Chars);
			log.info("percent: " + charDisplay.getPercent());
		}

		// https://stackoverflow.com/questions/67551784/printing-an-unordered-list-that-is-in-a-ordered-list-by-using-a-for-each-loop-in
		charDisplay1.forEach(charDisplay -> {
			String charType = charDisplay.getCharType() + " -   ";
			String percent = String.format("%.2f", charDisplay.getPercent()) + "% ";
			sb.append(charType + percent + System.getProperty("line.separator"));
		});

		return sb.toString();
	}

	public String buildCharDisplay2(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis) {
		log.info("CharDisplayBuilderImpl - buildCharDisplay");
		StringBuilder sb = new StringBuilder();
		List<CharDisplay> charDisplay2 = charDisplayAnalysis.get(2);

		log.info("CharDisplayBuilderImpl - buildCharDisplay - charDisplay2");
		int totalDisplay2Chars = 0;

		for (int i = 0; i < charDisplay2.size(); i++) {
			totalDisplay2Chars += charDisplay2.get(i).getIntValue();
		}

		for (int i = 0; i < charDisplay2.size(); i++) {
			CharDisplay charDisplay = charDisplay2.get(i);
			charDisplay.setTotalDisplayChars(totalDisplay2Chars);
			log.info("percent: " + charDisplay.getPercent());
		}

		charDisplay2.forEach(charDisplay -> {
			// String value = charDisplay.getValue();

			String charType = charDisplay.getCharType();
			charType += ": ";
			String percent = String.format("%.2f", charDisplay.getPercent());

		});
		
		return sb.toString();
	}

	public String buildCharDisplay3(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis) {
		log.info("CharDisplayBuilderImpl - buildCharDisplay");
		StringBuilder sb = new StringBuilder();
		List<CharDisplay> charDisplay3 = charDisplayAnalysis.get(3);

		log.info("CharDisplayBuilderImpl - buildCharDisplay - charDisplay3");
		int totalDisplay3Chars = 0;

		for (int i = 0; i < charDisplay3.size(); i++) {
			totalDisplay3Chars += charDisplay3.get(i).getIntValue();
		}

		for (int i = 0; i < charDisplay3.size(); i++) {
			CharDisplay charDisplay = charDisplay3.get(i);
			charDisplay.setTotalDisplayChars(totalDisplay3Chars);
			log.info("percent: " + charDisplay.getPercent());
		}

		

		charDisplay3.forEach(charDisplay -> {
			// String value = charDisplay.getValue();
			String charType = charDisplay.getCharType();
			charType += ": ";
			String percent = String.format("%.2f", charDisplay.getPercent());
			sb.append("<li>" + charType + percent + "</li>");
		});

		sb.append("</ol>");
		return sb.toString();
	}

	public String buildCharDisplay4(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis) {
		log.info("CharDisplayBuilderImpl - buildCharDisplay");
		StringBuilder sb = new StringBuilder();
		List<CharDisplay> charDisplay4 = charDisplayAnalysis.get(4);

		log.info("CharDisplayBuilderImpl - buildCharDisplay - charDisplay3");
		int totalDisplay3Chars = 0;

		for (int i = 0; i < charDisplay4.size(); i++) {
			totalDisplay3Chars += charDisplay4.get(i).getIntValue();
		}

		for (int i = 0; i < charDisplay4.size(); i++) {
			CharDisplay charDisplay = charDisplay4.get(i);
			charDisplay.setTotalDisplayChars(totalDisplay3Chars);
			log.info("percent: " + charDisplay.getPercent());
		}

		sb.append("<ol>");

		charDisplay4.forEach(charDisplay -> {
			// String value = charDisplay.getValue();
			String charType = charDisplay.getCharType();
			charType += ": ";
			String percent = String.format("%.2f", charDisplay.getPercent());
			sb.append("<li>" + charType + percent + "</li>");
		});

		sb.append("</ol>");
		return sb.toString();
	}

	public String buildCharDisplay5(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis) {
		log.info("CharDisplayBuilderImpl - buildCharDisplay");
		StringBuilder sb = new StringBuilder();
		List<CharDisplay> charDisplay5 = charDisplayAnalysis.get(5);

		log.info("CharDisplayBuilderImpl - buildCharDisplay - charDisplay5");
		int totalDisplay3Chars = 0;

		for (int i = 0; i < charDisplay5.size(); i++) {
			totalDisplay3Chars += charDisplay5.get(i).getIntValue();
		}

		for (int i = 0; i < charDisplay5.size(); i++) {
			CharDisplay charDisplay = charDisplay5.get(i);
			charDisplay.setTotalDisplayChars(totalDisplay3Chars);
			log.info("percent: " + charDisplay.getPercent());
		}

		sb.append("<ol>");

		charDisplay5.forEach(charDisplay -> {
			// String value = charDisplay.getValue();
			String charType = charDisplay.getCharType();
			charType += ": ";
			String percent = String.format("%.2f", charDisplay.getPercent());
			sb.append("<li>" + charType + percent + "</li>");
		});

		sb.append("</ol>");
		return sb.toString();
	}

//	public String buildCharDisplay2(Map<Integer, ArrayList<CharDisplay>> charDisplayAnalysis) {
//		log.info("CharDisplayBuilderImpl - buildCharDisplay");
//		StringBuilder sb = new StringBuilder();
//		List<CharDisplay> charDisplay2 = charDisplayAnalysis.get(1);
//		
//		log.info("CharDisplayBuilderImpl - buildCharDisplay - charDisplay2");
//		int totalDisplay1Chars = 0;
//		
//		for (int i = 0; i < charDisplay1.size(); i++) {
//			totalDisplay1Chars += charDisplay1.get(i).getIntValue();
//		}
//		
//		for (int i = 0; i < charDisplay1.size(); i++) {
//			CharDisplay charDisplay = charDisplay1.get(i);
//			charDisplay.setTotalDisplayChars(totalDisplay1Chars);
//			log.info("percent: " + charDisplay.getPercent());
//		}
//		
//		sb.append("<ol>");
//		
//		charDisplay1.forEach(charDisplay -> {
//			//String value = charDisplay.getValue();
//			String charType = charDisplay.getCharType();
//			charType += ": ";
//			String percent = String.format("%.2f", charDisplay.getPercent());
//			sb.append("<li>" + charType + percent + "</li>");
//		});
//		
//		sb.append("</ol>");
//		return sb.toString();
//	}
//
//		//System.out.println(sb.toString());
//		//sb.append("</ol>");
//		//sb.deleteCharAt(sb.length() - 2);
//		
//		/*
//		 * sb.append(System.getProperty("line.separator"));
//		 * sb.append(System.getProperty("line.separator"));
//		 * sb.append("Character 2 Analysis:");
//		 * sb.append(System.getProperty("line.separator"));
//		 * sb.append(System.getProperty("line.separator"));
//		 */
//		
//		//log.info("CharDisplayBuilderImpl - buildCharDisplay - charDisplay2");
//		//charDisplay2.forEach(charDisplay -> {
//			//String type = charDisplay.getCharType();
//			//String value = charDisplay.getValue();
//			//String percent = charDisplay.getPercent().toString();
//			//sb.append(" " + type + ": " + value + " - " + percent + ", ");
//		//});
//		
//		//sb.deleteCharAt(sb.length() - 2);
//		
//		/*
//		 * sb.append(System.getProperty("line.separator"));
//		 * sb.append(System.getProperty("line.separator"));
//		 * sb.append("Character 3 Analysis:");
//		 * sb.append(System.getProperty("line.separator"));
//		 * sb.append(System.getProperty("line.separator"));
//		 */
//		//log.info("CharDisplayBuilderImpl - buildCharDisplay - charDisplay3");
//		//charDisplay3.forEach(charDisplay -> {
//			//String type = charDisplay.getCharType();
//			//String value = charDisplay.getValue();
//			//String percent = charDisplay.getPercent().toString();
//			//sb.append(" " + type + ": " + value + " - " + percent + ", ");
//		//});
//		
//		//sb.deleteCharAt(sb.length() - 2);
//		
//		/*
//		 * sb.append(System.getProperty("line.separator"));
//		 * sb.append(System.getProperty("line.separator"));
//		 * sb.append("Character 4 Analysis:");
//		 * sb.append(System.getProperty("line.separator"));
//		 * sb.append(System.getProperty("line.separator"));
//		 */
//		//log.info("CharDisplayBuilderImpl - buildCharDisplay - charDisplay4");
//		//charDisplay4.forEach(charDisplay -> {
//			//String type = charDisplay.getCharType();
//			//String value = charDisplay.getValue();
//			//String percent = charDisplay.getPercent().toString();
//			//sb.append(" " + type + ": " + value + " - " + percent + ", ");
//		//});
//		
//		//sb.deleteCharAt(sb.length() - 2);
//				
//		/*
//		 * sb.append(System.getProperty("line.separator"));
//		 * sb.append(System.getProperty("line.separator"));
//		 * sb.append("Character 5 Analysis:");
//		 * sb.append(System.getProperty("line.separator"));
//		 * sb.append(System.getProperty("line.separator"));
//		 */
//		//log.info("CharDisplayBuilderImpl - buildCharDisplay - charDisplay5");
//		//charDisplay5.forEach(charDisplay -> {
//			//String type = charDisplay.getCharType();
//			//String value = charDisplay.getValue();
//			//String percent = charDisplay.getPercent().toString();
//			//sb.append(" " + type + ": " + value + " - " + percent + ", ");
//		//});
//		
//		//sb.deleteCharAt(sb.length() - 2);
//		
//		log.info("** " + sb.toString());
//		
//		return sb.toString();
//	}

	/*
	 * private int getCharTotalValue(List<CharDisplay> charDisplays) { int charValue
	 * = 0; Integer charTotal = 0;
	 * 
	 * for (CharDisplay charDisplay : charDisplays) { charDisplay.getValue();
	 * 
	 * 
	 * }
	 * 
	 * // charDisplays.forEach(charDisplay -> { // //String type =
	 * charDisplay.getCharType(); // //String value = charDisplay.getValue(); //
	 * //sb.append(" " + type + ": " + value + ", "); // charValue +=
	 * Integer.parseInt(charDisplay.getValue()); // //charTotal = charTotal + x; //
	 * //charTotals += charTotals + i; // //charTotals // });
	 * 
	 * return 0; }
	 */}
