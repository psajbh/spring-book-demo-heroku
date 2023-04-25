package com.jhart.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * GenericResponseDto simplifies support for UpdateTaskController whereby it 
 * integrates the name from the user table with the todo table record. 
 * At some point this should be modified by updating the TodoRepository. 
 *     
 * @author John
 *
 * @param <T>
 */
public class GenericResponseDto<T> {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private String status = null;
	private T object = null;
	
	public GenericResponseDto(String a, Object T) {
		log.debug("GenericResponseDto conductor a: " + a + ": o: " + T);
	}
	
	public String getStatus() {
		if (null != status) {
			log.debug("GenericResponseDto getStatus value: " + status);
		}
		return status;
	}
	
	public void setStatus(String status) {
		if (null != status) {
			log.debug("GenericResponseDto setStatus value: " + status);
		}
		this.status = status;
	}
	
	public T getObject() {
		if (null != object) {
			log.debug("GenericResponseDto getObject value: " + object.toString());
		}
		return object;
	}
	
	public void setObject(T object) {
		if (null != object) {
			log.debug("MyResponse setObject value: " + object.toString());
		}

		this.object = object;
	}
	
}
