package com.iktpreobuka.ednevnikos2.models;

public class MejlObject {
	
	private String to;
	private String subject;
	private String textBody;
	
	public MejlObject() {
		super();
	}

	public MejlObject(String to, String subject, String textBody) {
		super();
		this.to = to;
		this.subject = subject;
		this.textBody = textBody;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTextBody() {
		return textBody;
	}

	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}
	
	

}
