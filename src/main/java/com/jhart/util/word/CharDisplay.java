package com.jhart.util.word;
//apparently not used.  comment out on 6/30/2023
//import java.math.BigDecimal;
//import java.math.MathContext;
//import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"unused"})
public class CharDisplay {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	DecimalFormat formatter = new DecimalFormat("#0.00");
	private String level;
	private String charType;
	private String value;
	private int totalDisplayChars;
	private double percent;
	private String name;

	
	public CharDisplay(String data) {
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
		return percent;
	}

	private void setPercent() {
		log.info("CharDisplay - setPercent");
		int top = getIntValue();
		int bottom = getTotalDisplayChars();
		if (0 == top || 0 == bottom) {
			percent = 0.0;
		}
		else {
			percent = calculatePercentage(top,bottom);
		}
	}
	
	private double calculatePercentage(double top, double bottom) {
		return top * 100 / bottom;
	}

	//not used.  hold this temporarily start: 6/20/2023
//	private Double getBigDecimal() {
//		log.info("CharDisplay - getBigDecimal");
//		MathContext mathContext = getMathContext();
//		BigDecimal bd = new BigDecimal(percent, mathContext);
//		return bd.doubleValue();
//	}

	//not used.  hold this temporarily start: 6/20/2023
//	private MathContext getMathContext() {
//		log.info("CharDisplay - getMathContext");
//		return new MathContext(1, RoundingMode.DOWN);
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
