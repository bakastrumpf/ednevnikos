package com.iktpreobuka.ednevnikos2.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.iktpreobuka.ednevnikos2.entities.UserRole;
import com.iktpreobuka.ednevnikos2.repositories.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean OvlascenjaUloge(UserRole rola) {
		// proveri ulogu korisnika i da li ima ovlašćenja za radnje
		return false;
	}

}
