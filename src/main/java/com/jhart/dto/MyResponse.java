package com.jhart.dto;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class MyResponse<T> {
	private String status;
	private T object;
	
	public MyResponse(String a, Object T) {
		
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	
	
}
