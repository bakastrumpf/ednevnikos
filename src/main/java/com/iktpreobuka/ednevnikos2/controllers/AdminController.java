package com.iktpreobuka.ednevnikos2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.ednevnikos2.repositories.AdminRepository;
import com.iktpreobuka.ednevnikos2.repositories.UserRepository;
//import com.iktpreobuka.ednevnikos2.services.UserServiceImpl;
import com.iktpreobuka.ednevnikos2.utils.KorisnikCustomValidator;

@RestController
@RequestMapping (path = "/api/v1/eos/admini")
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
//	@Autowired
//	private UserServiceImpl userServiceImpl;
	
	@Autowired
	KorisnikCustomValidator korisnikCustomValidator;
	

	// TODO GET - izlistaj sve admine
	// TODO	POST - dodaj novog admina - ako postoji izbaci gresku / obavestenje (RestError)
	// TODO PUT - izmeni admina - prvo proveri da li postoji
	
}
