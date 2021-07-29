package com.iktpreobuka.ednevnikos2.controllers.util;

import com.fasterxml.jackson.annotation.JsonView;

public class RestErrorEdnevnikOS {
	

	public Integer code;

	public String message;
	
	public RestErrorEdnevnikOS() {
		super();
	}

	public RestErrorEdnevnikOS(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	//geteri i seteri nisu neophodni, na času smo ih ipak ostavili
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
