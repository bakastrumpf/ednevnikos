package com.iktpreobuka.ednevnikos2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.ednevnikos2.entities.NastavnikEntity;
import com.iktpreobuka.ednevnikos2.entities.PredajePredmet;
import com.iktpreobuka.ednevnikos2.entities.PredmetEntity;
import com.iktpreobuka.ednevnikos2.entities.RoditeljEntity;
import com.iktpreobuka.ednevnikos2.entities.RoleEntity;
import com.iktpreobuka.ednevnikos2.entities.UcenikEntity;
import com.iktpreobuka.ednevnikos2.entities.UserEntity;
import com.iktpreobuka.ednevnikos2.repositories.NastavnikRepository;
import com.iktpreobuka.ednevnikos2.repositories.OcenaRepository;
import com.iktpreobuka.ednevnikos2.repositories.PredmetRepository;
import com.iktpreobuka.ednevnikos2.repositories.RoditeljRepository;
import com.iktpreobuka.ednevnikos2.repositories.RoleRepository;
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
	
	@Autowired
	private RoleRepository ulogaRepository;
	
//	@Autowired
//	private UserServiceImpl userServiceImpl;
	
	@Autowired
	KorisnikCustomValidator korisnikCustomValidator;
	
	@RequestMapping(method = RequestMethod.POST)
	public NastavnikEntity noviNastavnik(@RequestParam String mejl,	@RequestParam String lozinka, @RequestParam String korisnickoIme) {
		NastavnikEntity noviNastavnik = new NastavnikEntity();
		noviNastavnik.setMejl(mejl);
		noviNastavnik.setLozinka(lozinka);
		noviNastavnik.setKorisnickoIme(korisnickoIme);
		nastavnikRepository.save(noviNastavnik);
		return noviNastavnik;
	}
	
		// TODO GET - izlistaj sve nastavnike
	@RequestMapping(method = RequestMethod.GET)
	public List<NastavnikEntity> getAllNastavnici(){
		return (List<NastavnikEntity>) nastavnikRepository.findAll();
		
		// TODO GET - vrati jednog nastavnika - /{id}
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public NastavnikRepository nr findById(@PathVariable Integer id) {
//	for (NastavnikRepository nr : getAllNastavnici()) {
//		if (nr.getId().equals(id))
//			return nr;
//			}
//		return null;
//		}
//	}
	
	// TODO - GET - findById
	
		// TODO	POST - dodaj novog nastavnika - prvo proveri da li postoji
		// TODO PUT - izmeni nastavnika - prvo proveri da li postoji

}
	
//	@RequestMapping(value = "/nastavnikPredmet", method = RequestMethod.PUT)
//	public NastavnikEntity poveziNastPredm (@RequestParam Integer nastavnikId, @RequestParam Integer predmetId) {
//		NastavnikEntity nastavnik = nastavnikRepository.findById(nastavnikId).get();
//		PredmetEntity predmet = predmetRepository.findById(predmetId).get();
//		predmet.setNastavnici(new ArrayList<NastavnikEntity>());
//		predmetRepository.save(predmet);
//		return nastavnik;
//	}
	
	
}
