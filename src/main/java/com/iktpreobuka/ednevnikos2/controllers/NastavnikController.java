package com.iktpreobuka.ednevnikos2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.ednevnikos2.entities.NastavnikEntity;
import com.iktpreobuka.ednevnikos2.entities.UcenikEntity;
import com.iktpreobuka.ednevnikos2.repositories.NastavnikRepository;
import com.iktpreobuka.ednevnikos2.repositories.OcenaRepository;
import com.iktpreobuka.ednevnikos2.repositories.PredmetRepository;
import com.iktpreobuka.ednevnikos2.repositories.RoditeljRepository;
import com.iktpreobuka.ednevnikos2.repositories.UcenikRepository;
import com.iktpreobuka.ednevnikos2.repositories.UserRepository;
import com.iktpreobuka.ednevnikos2.services.UserServiceImpl;
import com.iktpreobuka.ednevnikos2.utils.KorisnikCustomValidator;

@RestController
@RequestMapping("/api/v1/eos/nastavnici")
public class NastavnikController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private NastavnikRepository nastavnikRepository;
	
	@Autowired
	private UcenikRepository ucenikRepository;
	
	@Autowired
	private OcenaRepository ocenaRepository;
	
	@Autowired
	private PredmetRepository predmetRepository;
	
//	@Autowired
//	private UserServiceImpl userServiceImpl;
	
	@Autowired
	KorisnikCustomValidator korisnikCustomValidator;
	
	
		// TODO GET - izlistaj sve nastavnike
	@RequestMapping(method = RequestMethod.GET)
	public List<NastavnikEntity> getAllNastavnici(){
		return (List<NastavnikEntity>) nastavnikRepository.findAll();
	}
	
	// TODO - GET - findById
	
		// TODO	POST - dodaj novog nastavnika - prvo proveri da li postoji
		// TODO PUT - izmeni nastavnika - prvo proveri da li postoji

}
