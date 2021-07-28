package com.iktpreobuka.ednevnikos2.controllers.util;

import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.ednevnikos2.security.Pogledi;

public class RestErrorEdnevnikOS {
	
	@JsonView(Pogledi.Public.class)
	public Integer code;
	@JsonView(Pogledi.Public.class)
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
