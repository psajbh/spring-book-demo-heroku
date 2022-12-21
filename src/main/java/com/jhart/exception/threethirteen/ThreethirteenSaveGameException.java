package com.jhart.exception.threethirteen;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jhart.exception.DemoException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ThreethirteenSaveGameException extends DemoException {
	private static final long serialVersionUID = -7423414954180246711L;
	
	public ThreethirteenSaveGameException(String msg) {
		super(msg);
	}

}
