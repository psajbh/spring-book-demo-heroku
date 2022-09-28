package com.jhart.dto;

public class WordSupportDto {
	private String wordName;
	private String noWordName;
	private String inChar1;
	private String inChar2;
	private String inChar3;
	private String inChar4;
	private String inChar5;
//	private String notInChar1;
//	private String notInChar2;
//	private String notInChar3;
//	private String notInChar4;
//	private String notInChar5;
	private String words;
	private String wordCount;
//	private String common;
	
	public String getWordName() {
		return wordName;
	}
	public void setWordName(String wordName) {
		this.wordName = wordName;
	}
	public String getNoWordName() {
		return noWordName;
	}
	public void setNoWordName(String nonWordName) {
		this.noWordName = nonWordName;
	}
	public String getInChar1() {
		return inChar1;
	}
	public void setInChar1(String inChar1) {
		this.inChar1 = inChar1;
	}
	public String getInChar2() {
		return inChar2;
	}
	public void setInChar2(String inChar2) {
		this.inChar2 = inChar2;
	}
	public String getInChar3() {
		return inChar3;
	}
	public void setInChar3(String inChar3) {
		this.inChar3 = inChar3;
	}
	public String getInChar4() {
		return inChar4;
	}
	public void setInChar4(String inChar4) {
		this.inChar4 = inChar4;
	}
	public String getInChar5() {
		return inChar5;
	}
	public void setInChar5(String inChar5) {
		this.inChar5 = inChar5;
	}
//	public String getNotInChar1() {
//		return notInChar1;
//	}
//	public void setNotInChar1(String notInChar1) {
//		this.notInChar1 = notInChar1;
//	}
//	public String getNotInChar2() {
//		return notInChar2;
//	}
//	public void setNotInChar2(String notInChar2) {
//		this.notInChar2 = notInChar2;
//	}
//	public String getNotInChar3() {
//		return notInChar3;
//	}
//	public void setNotInChar3(String notInChar3) {
//		this.notInChar3 = notInChar3;
//	}
//	public String getNotInChar4() {
//		return notInChar4;
//	}
//	public void setNotInChar4(String notInChar4) {
//		this.notInChar4 = notInChar4;
//	}
//	public String getNotInChar5() {
//		return notInChar5;
//	}
//	public void setNotInChar5(String notInChar5) {
//		this.notInChar5 = notInChar5;
//	}
//	public String getCommon() {
//		return common;
//	}
//	public void setCommon(String common) {
//		this.common = common;
//	}
	
	
	@Override
	public String toString() {
		return "WordSupportDto [wordName=" + wordName + "]";
	}
	
	 public String getWords() { return words; } 
	 
	 public void setWords(String words) { this.words = words; }
	 
	 public String getWordCount() {
			return wordCount;
	 }
	 
	 public void setWordCount(String wordCount) {
			this.wordCount = wordCount;
	 }
	
}
