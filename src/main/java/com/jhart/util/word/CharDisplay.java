package com.jhart.util.word;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharDisplay {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	DecimalFormat formatter = new DecimalFormat("#0.00");
	
	
	private String level;
	private String charType;
	private String value;
	private int totalDisplayChars;
	private double percent;
	private String name;
	
	

	public CharDisplay() {}
	
	public CharDisplay(String data) {
		// data like 1-b=1
		process(data);
	}
	
	public void process(String data) {
		setName(data);
		log.info("CharDisplay - process");
		String[] input = getName().split("-");
		level = input[0];
		charType = input[1];
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCharType() {
		return charType;
	}

	public void setCharType(String charType) {
		this.charType = charType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public int getIntValue() {
		return Integer.parseInt(getValue());
	}
	
	public int getTotalDisplayChars() {
		return totalDisplayChars;
	}

	public void setTotalDisplayChars(int totalDisplayChars) {
		log.info("CharDisplay - setTotalDisplayChars");
		this.totalDisplayChars = totalDisplayChars;
		setPercent();
	}

	public double getPercent() {
		log.info("CharDisplay - getPercent");
		//return getBigDecimal();
		return percent;
	}

	private void setPercent() {
		log.info("CharDisplay - setPercent");
		// percentage = (x/y)*100  -- how you create percentage normally  
		//String formatter = "##,###,###.##";
		int top = getIntValue();
		int bottom = getTotalDisplayChars();
		if (0 == top || 0 == bottom) {
			percent = 0.0;
		}
		else {
			percent = calculatePercentage(top,bottom);
			//double answer = calculatePercentage(top,bottom);
			//percent = answer;
			//double topA = 9;
			//double bottomA = 117;
			//double answer = calculatePercentage(topA,bottomA);
			
			//System.out.println(answer);
			//System.out.println();
			//DecimalFormat formatter = new DecimalFormat("#0.00");
			//this.percent = formatter.format(answer);
			//System.out.println(answerStr);
		}
		//System.out.println("percent: " + percent);
	}
	
	private double calculatePercentage(double top, double bottom) {
		return top * 100 / bottom;
	}

	private Double getBigDecimal() {
		log.info("CharDisplay - getBigDecimal");
		MathContext mathContext = getMathContext();
		BigDecimal bd = new BigDecimal(percent, mathContext);
		return bd.doubleValue();
	}
	
	private MathContext getMathContext() {
		log.info("CharDisplay - getMathContext");
		return new MathContext(1, RoundingMode.DOWN);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	

	
}
