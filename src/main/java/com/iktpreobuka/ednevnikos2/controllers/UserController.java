package com.iktpreobuka.ednevnikos2.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.ednevnikos2.entities.UserEntity;
import com.iktpreobuka.ednevnikos2.entities.UserRole;
import com.iktpreobuka.ednevnikos2.repositories.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Value("${spring.security.secret-key}")
	private String secretKey;

	@Value("${spring.security.token-duration}")
	private Integer duration;
	
	@Autowired
	private UserRepository userRepository; 
	
	@RequestMapping(method = RequestMethod.POST)
	public UserEntity createUser(@RequestParam String prezime,
			@RequestParam String ime, @RequestParam UserRole uloga) {
		UserEntity user = new UserEntity();
		user.setPrezime(prezime);
		user.setIme(ime);
		user.setUloga(uloga);
		userRepository.save(user);
		return user;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<UserEntity> getAllUsers(){
		return (List<UserEntity>) userRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public UserEntity modifyUser(@RequestParam String prezime,
			@RequestParam String ime, @RequestParam UserRole uloga) {
		UserEntity user = new UserEntity();
		user.setPrezime(prezime);
		user.setIme(ime);
		user.setUloga(uloga);
		userRepository.save(user);
		return user;
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public UserEntity deleteUser(@RequestParam String prezime,
			@RequestParam String ime, @RequestParam UserRole uloga) {
	/*
	 * treba pretraziti bazu i po ID naći korisnika kog želimo da izbrišemo 
	 * if(getAll.getId().equals(id))
	 * return getAll;
	 * return System.out.println("korisnik ne postoji");
	 * 
	 */
//		UserEntity user = new UserEntity();
//		user.setPrezime(prezime);
//		user.setIme(ime);
//		user.setUloga(uloga);
//		userRepository.save(user);
		return null;
	}
	
	/*
@RequestMapping(method = RequestMethod.POST, path = "/login")
	public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
		UserEntity user = userRepository.findByEmail(email);
		if (user != null && Encryption.validatePassword(password, user.getPassword())) {
			String token = getJWTToken(user);
			UserTokenDTO userDTO = new UserTokenDTO(user.getEmail(), token);
			return new ResponseEntity<>(userDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>("Wrong username/password!", HttpStatus.UNAUTHORIZED);
	}

	private String getJWTToken(UserEntity user) {
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList(user.getRole().getName());
		String token = Jwts.builder().setId("softtekJWT").setSubject(user.getEmail())
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 60000))
				.signWith(SignatureAlgorithm.HS512, secretKey).compact();

		return "Bearer " + token;
	}

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
