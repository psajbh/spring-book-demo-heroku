package com.jhart.util.word;

public class CharDisplay {
	
	private String level;
	private String charType;
	private String value;
	
	public CharDisplay() {}
	
	public CharDisplay(String data) {
		// data like 1-b=1
		process(data);
	}
	
	public void process(String data) {
		String[] output = data.split("-");
		level = output[0];
		charType = output[1];
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
		//Integer stringValue = (Integer) value;
		this.value = value;
	}
	
	
}
