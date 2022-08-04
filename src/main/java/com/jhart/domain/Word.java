package com.jhart.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Wordsearch")
public class Word {
	
	public Word() {
	}
	
	@Id
    private Integer id;
	
	private String word;
	private String char1;
	private String char2;
	private String char3;
	private String char4;
	private String char5;
	private String common;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getChar1() {
		return char1;
	}
	
	public void setChar1(String char1) {
		this.char1 = char1;
	}
	
	public String getChar2() {
		return char2;
	}
	
	public void setChar2(String char2) {
		this.char2 = char2;
	}
	
	public String getChar3() {
		return char3;
	}
	
	public void setChar3(String char3) {
		this.char3 = char3;
	}
	
	public String getChar4() {
		return char4;
	}
	
	public void setChar4(String char4) {
		this.char4 = char4;
	}
	
	public String getChar5() {
		return char5;
	}
	
	public void setChar5(String char5) {
		this.char5 = char5;
	}
	
	public String getCommon() {
		return common;
	}
	
	public void setCommon(String common) {
		this.common = common;
	}
	
	


}
