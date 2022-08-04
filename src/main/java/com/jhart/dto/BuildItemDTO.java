package com.jhart.dto;


//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
public class BuildItemDTO {
	private String type;
	private String value;
	
	public BuildItemDTO() {
		
	}
	
	public BuildItemDTO(String type, String value) {
		this.type = type;
		this.value = value;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	

}
