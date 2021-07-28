package com.iktpreobuka.ednevnikos2.services;

import com.iktpreobuka.ednevnikos2.models.MejlModel;

public interface EmailService {
	
	void sendSimpleMessage(MejlModel simpleMejl);
	void sendTemplateMessage(MejlModel templateMejl) throws Exception;
	void sendMessageWithAttachment(MejlModel prilogMejl, String pathToAttachment) throws Exception;

}
