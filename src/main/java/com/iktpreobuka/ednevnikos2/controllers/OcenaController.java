package com.iktpreobuka.ednevnikos2.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.ednevnikos2.entities.NastavnikEntity;
import com.iktpreobuka.ednevnikos2.entities.OcenaEntity;
import com.iktpreobuka.ednevnikos2.entities.PredmetEntity;
import com.iktpreobuka.ednevnikos2.entities.UcenikEntity;
import com.iktpreobuka.ednevnikos2.repositories.NastavnikRepository;
import com.iktpreobuka.ednevnikos2.repositories.OcenaRepository;
import com.iktpreobuka.ednevnikos2.repositories.PredmetRepository;
import com.iktpreobuka.ednevnikos2.repositories.UcenikRepository;
import com.iktpreobuka.ednevnikos2.services.UserServiceImpl;
import com.iktpreobuka.ednevnikos2.utils.KorisnikCustomValidator;

@RestController
@RequestMapping (path = "/api/v1/eos/ocene")
public class OcenaController {
	
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
	
	// TODO	POST - dodaj novu ocenu
	@RequestMapping(method = RequestMethod.POST)
	public OcenaEntity unesiOcenu(
			@RequestParam Integer ocena, 
			@RequestParam PredmetEntity kurs, 
			@RequestParam Date datumOcene, 
			@RequestParam NastavnikEntity ocenjivac,
			@RequestParam UcenikEntity ucenik) {
		OcenaEntity ocenaNova = new OcenaEntity();
		ocenaNova.setOcena(ocena);
		ocenaNova.setKurs(kurs);
		ocenaNova.setDatumOcene(datumOcene);
		ocenaNova.setOcenjivac(ocenjivac);
		ocenaNova.setUcenik(ucenik);
		ocenaRepository.save(ocenaNova);
		return ocenaNova;
		
	// TODO PUT - izmeni ocenu - pronađi učenika, predmet
	// TODO DELETE - izbriši ocenu - pronađi učenika, odaberi predmet

	}
}
