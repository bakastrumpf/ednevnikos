package com.iktpreobuka.ednevnikos2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.ednevnikos2.entities.UserEntity;
import com.iktpreobuka.ednevnikos2.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserContoller {
	
	@Autowired
	private UserRepository userRepository; 
	
	@RequestMapping(method = RequestMethod.POST)
	public UserEntity createUser(@RequestParam String korisnickoIme,
			@RequestParam String mejl, @RequestParam String lozinka) {
		UserEntity user = new UserEntity();
		user.setMejl(mejl);
		user.setKorisnickoIme(korisnickoIme);
		user.setLozinka(lozinka);
		userRepository.save(user);
		return user;
	}
	
	@RequestMapping
	public List<UserEntity> getAll(){
		return (List<UserEntity>) userRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public UserEntity modifyUser(@RequestParam String korisnickoIme,
			@RequestParam String mejl, @RequestParam String lozinka) {
		UserEntity user = new UserEntity();
//		user.setMejl(mejl);
//		user.setKorisnickoIme(korisnickoIme);
//		user.setLozinka(lozinka);
//		userRepository.save(user);
		return user;
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public UserEntity deleteUser(@RequestParam String korisnickoIme,
			@RequestParam String mejl, @RequestParam String lozinka) {
		UserEntity user = new UserEntity();
//		user.setMejl(mejl);
//		user.setKorisnickoIme(korisnickoIme);
//		user.setLozinka(lozinka);
//		userRepository.save(user);
		return user;
	}
	
}
