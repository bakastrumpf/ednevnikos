package com.iktpreobuka.ednevnikos2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.ednevnikos2.entities.UcenikEntity;
import com.iktpreobuka.ednevnikos2.repositories.OcenaRepository;
import com.iktpreobuka.ednevnikos2.repositories.PredmetRepository;
import com.iktpreobuka.ednevnikos2.repositories.RoditeljRepository;
import com.iktpreobuka.ednevnikos2.repositories.UcenikRepository;
import com.iktpreobuka.ednevnikos2.repositories.UserRepository;
import com.iktpreobuka.ednevnikos2.services.UserServiceImpl;
import com.iktpreobuka.ednevnikos2.utils.KorisnikCustomValidator;

@RestController
@RequestMapping("/api/v1/eos/ucenici")
public class UcenikController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UcenikRepository ucenikRepository;
	
	@Autowired
	private RoditeljRepository roditeljRepository;
	
	@Autowired
	private OcenaRepository ocenaRepository;
	
	@Autowired
	private PredmetRepository predmetRepository;
	
//	@Autowired
//	private UserServiceImpl userServiceImpl;
	
	@Autowired
	KorisnikCustomValidator korisnikCustomValidator;
	
	
		// TODO GET - izlistaj sve učenike
	@RequestMapping(method = RequestMethod.GET)
	public List<UcenikEntity> getAllUcenici(){
		return (List<UcenikEntity>) ucenikRepository.findAll();
	}
	
	// TODO - GET - findUcenikById
	
		// TODO	POST - dodaj novog učenika
		// TODO PUT - izmeni učenika - prvo proveri da li postoji> findUcenikById
		// TODO DELETE - obriši učenika - prvo proveri da li postoji - findUcenikById
	
}
