package com.iktpreobuka.ednevnikos2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.ednevnikos2.entities.RoleEntity;
import com.iktpreobuka.ednevnikos2.entities.UserEntity;
import com.iktpreobuka.ednevnikos2.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@RequestMapping(method = RequestMethod.POST)
	public UserEntity createUser(@RequestParam String mejl,	@RequestParam String lozinka) {
		UserEntity user = new UserEntity();
		user.setMejl(mejl);
		user.setLozinka(lozinka);
	//	user.setUloga(uloga);
		userRepository.save(user);
		return user;
	}
	
		@RequestMapping(method = RequestMethod.GET)
		public List<UserEntity> getAllUsers(){
		return (List<UserEntity>) userRepository.findAll();
	}

//	@RequestMapping(method = RequestMethod.PUT)
//	public UserEntity modifyUser(@RequestParam Integer id, @RequestParam String mejl,	@RequestParam String lozinka) {
//		if(getAllUsers().getId().equals(id)) {
//		user.setMejl(getMejl);
//		user.setLozinka(getLozinka);
//		userRepository.save(user);
//		}
//		return user;
//	}
	
//	@RequestMapping(method = RequestMethod.DELETE)
//	public UserEntity deleteUser (@RequestParam String mejl,@RequestParam String lozinka) {
	/*
	 * treba pretraziti bazu i po ID naći korisnika kog želimo da izbrišemo 
	 * if(getAll.getId().equals(id))
	 * return getAll;
	 * return System.out.println("korisnik ne postoji");
	 * 
	 */
//		return null;
//	}

/*
	@Secured("ROLE_ADMIN")
	@RequestMapping("/api/v1/users")
	public ResponseEntity<?> getAllUsers() {
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	}

	@Secured("ROLE_USER")
	@RequestMapping("/api/v1/users/roleUser")
	public ResponseEntity<?> getAllUsersRoleUsers() {
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	}
	 */
	
}
