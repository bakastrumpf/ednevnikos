package com.iktpreobuka.ednevnikos2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.ednevnikos2.entities.RoditeljEntity;
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
@RequestMapping("/api/v1/eos/roditelji")
public class RoditeljController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoditeljRepository roditeljRepository;

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

	// TODO GET - izlistaj sve roditelje
	@RequestMapping(method = RequestMethod.GET)
	public List<RoditeljEntity> getAllRoditelji() {
		return (List<RoditeljEntity>) roditeljRepository.findAll();
	}

	// TODO - GET - findRoditeljById

	// TODO POST - dodaj novog roditelja - findRoditeljById - ako postoji> RestError
	// TODO PUT - izmeni roditelja - prvo proveri da li postoji - findById - ako
	// postoji> RestError

}
