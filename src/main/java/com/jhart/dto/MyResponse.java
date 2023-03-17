package com.jhart.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Note: MyResponse supports updating dynamic frontend datatables.
public class MyResponse<T> {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private String status = null;
	private T object = null;
	
	public MyResponse(String a, Object T) {
		log.debug("MyResponse conductor");
	}
	
	public String getStatus() {
		if (null != status) {
			log.debug("MyResponse getStatus value: " + status);
		}
		return status;
	}
	
	public void setStatus(String status) {
		if (null != status) {
			log.debug("MyResponse setStatus value: " + status);
		}
		this.status = status;
	}
	
	public T getObject() {
		if (null != object) {
			log.debug("MyResponse getObject value: " + object.toString());
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
