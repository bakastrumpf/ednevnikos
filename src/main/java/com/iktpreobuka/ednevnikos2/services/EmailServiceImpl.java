package com.iktpreobuka.ednevnikos2.services;

import com.iktpreobuka.ednevnikos2.models.MejlModel;

public class EmailServiceImpl implements EmailService {

	@Override
	public void sendSimpleMessage(MejlModel simpleMejl) {
		// šalje običan mejl - kome, naslov, telo
		
	}

	@Override
	public void sendTemplateMessage(MejlModel templateMejl) throws Exception {
		// šalje formular - kome, naslov, obrazac za unos teksta
		//MimeMessage?
		
	}

	@Override
	public void sendMessageWithAttachment(MejlModel prilogMejl, String pathToAttachment) throws Exception {
		// šalje prilog - 
		
	}

}
