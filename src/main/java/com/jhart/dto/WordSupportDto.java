package com.jhart.dto;

public class WordSupportDto {
	private String wordName;
	private String noWordName;
	private String inChar1;
	private String inChar2;
	private String inChar3;
	private String inChar4;
	private String inChar5;
	private String notInChar1;
	private String notInChar2;
	private String notInChar3;
	private String notInChar4;
	private String notInChar5;
	private String words;
	private String wordCount;
	private String wordAnalysis_1;
	private String wordAnalysis_2;
	private String wordAnalysis_3;
	private String wordAnalysis_4;
	private String wordAnalysis_5;
	
	 

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

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getWordCount() {
		return wordCount;
	}

	public void setWordCount(String wordCount) {
		this.wordCount = wordCount;
	}

	public String getNotInChar1() {
		return notInChar1;
	}

	public void setNotInChar1(String notInChar1) {
		this.notInChar1 = notInChar1;
	}

	public String getNotInChar2() {
		return notInChar2;
	}

	public void setNotInChar2(String notInChar2) {
		this.notInChar2 = notInChar2;
	}

	public String getNotInChar3() {
		return notInChar3;
	}

	public void setNotInChar3(String notInChar3) {
		this.notInChar3 = notInChar3;
	}

	public String getNotInChar4() {
		return notInChar4;
	}

	public void setNotInChar4(String notInChar4) {
		this.notInChar4 = notInChar4;
	}

	public String getNotInChar5() {
		return notInChar5;
	}

	public void setNotInChar5(String notInChar5) {
		this.notInChar5 = notInChar5;
	}
	
	public String getWordAnalysis_1() {
		return wordAnalysis_1;
	}

	public void setWordAnalysis_1(String wordAnalysis_1) {
		this.wordAnalysis_1 = wordAnalysis_1;
	}

	public String getWordAnalysis_2() {
		return wordAnalysis_2;
	}

	public void setWordAnalysis_2(String wordAnalysis_2) {
		this.wordAnalysis_2 = wordAnalysis_2;
	}

	public String getWordAnalysis_3() {
		return wordAnalysis_3;
	}

	public void setWordAnalysis_3(String wordAnalysis_3) {
		this.wordAnalysis_3 = wordAnalysis_3;
	}

	public String getWordAnalysis_4() {
		return wordAnalysis_4;
	}

	public void setWordAnalysis_4(String wordAnalysis_4) {
		this.wordAnalysis_4 = wordAnalysis_4;
	}

	public String getWordAnalysis_5() {
		return wordAnalysis_5;
	}

	public void setWordAnalysis_5(String wordAnalysis_5) {
		this.wordAnalysis_5 = wordAnalysis_5;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inChar1 == null) ? 0 : inChar1.hashCode());
		result = prime * result + ((inChar2 == null) ? 0 : inChar2.hashCode());
		result = prime * result + ((inChar3 == null) ? 0 : inChar3.hashCode());
		result = prime * result + ((inChar4 == null) ? 0 : inChar4.hashCode());
		result = prime * result + ((inChar5 == null) ? 0 : inChar5.hashCode());
		result = prime * result + ((noWordName == null) ? 0 : noWordName.hashCode());
		result = prime * result + ((notInChar1 == null) ? 0 : notInChar1.hashCode());
		result = prime * result + ((notInChar2 == null) ? 0 : notInChar2.hashCode());
		result = prime * result + ((notInChar3 == null) ? 0 : notInChar3.hashCode());
		result = prime * result + ((notInChar4 == null) ? 0 : notInChar4.hashCode());
		result = prime * result + ((notInChar5 == null) ? 0 : notInChar5.hashCode());
		result = prime * result + ((wordCount == null) ? 0 : wordCount.hashCode());
		result = prime * result + ((wordName == null) ? 0 : wordName.hashCode());
		result = prime * result + ((words == null) ? 0 : words.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordSupportDto other = (WordSupportDto) obj;
		if (inChar1 == null) {
			if (other.inChar1 != null)
				return false;
		} else if (!inChar1.equals(other.inChar1))
			return false;
		if (inChar2 == null) {
			if (other.inChar2 != null)
				return false;
		} else if (!inChar2.equals(other.inChar2))
			return false;
		if (inChar3 == null) {
			if (other.inChar3 != null)
				return false;
		} else if (!inChar3.equals(other.inChar3))
			return false;
		if (inChar4 == null) {
			if (other.inChar4 != null)
				return false;
		} else if (!inChar4.equals(other.inChar4))
			return false;
		if (inChar5 == null) {
			if (other.inChar5 != null)
				return false;
		} else if (!inChar5.equals(other.inChar5))
			return false;
		if (noWordName == null) {
			if (other.noWordName != null)
				return false;
		} else if (!noWordName.equals(other.noWordName))
			return false;
		if (notInChar1 == null) {
			if (other.notInChar1 != null)
				return false;
		} else if (!notInChar1.equals(other.notInChar1))
			return false;
		if (notInChar2 == null) {
			if (other.notInChar2 != null)
				return false;
		} else if (!notInChar2.equals(other.notInChar2))
			return false;
		if (notInChar3 == null) {
			if (other.notInChar3 != null)
				return false;
		} else if (!notInChar3.equals(other.notInChar3))
			return false;
		if (notInChar4 == null) {
			if (other.notInChar4 != null)
				return false;
		} else if (!notInChar4.equals(other.notInChar4))
			return false;
		if (notInChar5 == null) {
			if (other.notInChar5 != null)
				return false;
		} else if (!notInChar5.equals(other.notInChar5))
			return false;
		if (wordCount == null) {
			if (other.wordCount != null)
				return false;
		} else if (!wordCount.equals(other.wordCount))
			return false;
		if (wordName == null) {
			if (other.wordName != null)
				return false;
		} else if (!wordName.equals(other.wordName))
			return false;
		if (words == null) {
			if (other.words != null)
				return false;
		} else if (!words.equals(other.words))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WordSupportDto [wordName=" + wordName + ", noWordName=" + noWordName + ", inChar1=" + inChar1
				+ ", inChar2=" + inChar2 + ", inChar3=" + inChar3 + ", inChar4=" + inChar4 + ", inChar5=" + inChar5
				+ ", notInChar1=" + notInChar1 + ", notInChar2=" + notInChar2 + ", notInChar3=" + notInChar3
				+ ", notInChar4=" + notInChar4 + ", notInChar5=" + notInChar5 + ", words=" + words + ", wordCount="
				+ wordCount + "]";
	}
	
	
	

}
