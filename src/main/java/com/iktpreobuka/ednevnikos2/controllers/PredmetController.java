package com.iktpreobuka.ednevnikos2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.ednevnikos2.entities.PredmetEntity;
import com.iktpreobuka.ednevnikos2.entities.UserEntity;
import com.iktpreobuka.ednevnikos2.repositories.NastavnikRepository;
import com.iktpreobuka.ednevnikos2.repositories.OcenaRepository;
import com.iktpreobuka.ednevnikos2.repositories.PredmetRepository;
import com.iktpreobuka.ednevnikos2.repositories.UcenikRepository;
import com.iktpreobuka.ednevnikos2.utils.KorisnikCustomValidator;

@RestController
@RequestMapping(path = "/api/v1/eos/predmeti")
public class PredmetController {

	@Autowired
	private PredmetRepository predmetRepository;

	@Autowired
	private NastavnikRepository nastavnikRepository;

	@Autowired
	private UcenikRepository ucenikRepository;

	@Autowired
	private OcenaRepository ocenaRepository;

//	@Autowired
//	private UserServiceImpl userServiceImpl;

	@Autowired
	KorisnikCustomValidator korisnikCustomValidator;
	
	@RequestMapping(method = RequestMethod.POST)
	public PredmetEntity dodajPredmet(@RequestParam String nazivPredmeta, @RequestParam Integer nedFondCasova) {
		PredmetEntity predmet = new PredmetEntity();
		predmet.setNazivPredmeta(nazivPredmeta);
		predmet.setNedFondCasova(nedFondCasova);
		predmetRepository.save(predmet);
		return predmet;
	}

	// TODO GET - izlistaj sve predmete
	@RequestMapping(method = RequestMethod.GET)
	public List<PredmetEntity> getAllPredmeti(){
	return (List<PredmetEntity>) predmetRepository.findAll();
	}
	
	// TODO	POST - dodaj novi predmet
	
	// TODO - GET - findPredmetById
	
	
	// TODO PUT - izmeni predmet - proveri da li postoji
	// TODO DELETE - izbriši predmet - proveri da li postoji

}
