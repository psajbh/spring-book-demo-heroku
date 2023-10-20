package com.jhart.util.word;
import java.text.DecimalFormat;
import java.util.Objects;

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
	
	public CharDisplay(String data) {
		log.trace("CharDisplay - processing: " + data);
		process(data);
	}
	
	private void process(String data) {
		setName(data);
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
		//log.info("CharDisplay - setTotalDisplayChars");
		this.totalDisplayChars = totalDisplayChars;
		setPercent();
	}

	public double getPercent() {
		//log.info("CharDisplay - getPercent");
		return percent;
	}

	private void setPercent() {
		//log.info("CharDisplay - setPercent");
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(charType, formatter, level, name, percent, totalDisplayChars, value);
	}
	
	@Override
	public String toString() {
		return "CharDisplay [formatter=" + formatter + ", level=" + level + ", charType=" + charType + ", value="
				+ value + ", totalDisplayChars=" + totalDisplayChars + ", percent=" + percent + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharDisplay other = (CharDisplay) obj;
		return Objects.equals(charType, other.charType) && Objects.equals(formatter, other.formatter)
				&& Objects.equals(level, other.level) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(percent) == Double.doubleToLongBits(other.percent)
				&& totalDisplayChars == other.totalDisplayChars && Objects.equals(value, other.value);
	}
	
	
	
}
