package com.iktpreobuka.ednevnikos2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class NastavnikEntity extends UserEntity {
	
//	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
//  @OneToMany(mappedBy = "nesto", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
// @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//	private OdeljenjeEntity odeljenje;
	
	@Column
	@NotNull(message = "Korisničko ime must not be empty")
	@Size(min = 3, max = 15, message = "Korisničko ime mora imati između {min} i {max} znakova")
	private String korisnickoIme;
	
	@JsonIgnore
	@Column
	@NotNull(message = "Lozinka must not be empty")
	@Size(min = 3, max = 50, message = "Lozinka mora imati između {min} i {max} znakova")
	private String lozinka;
	
	@JoinColumn (name = "odeljenje")
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private OdeljenjeEntity odeljenje;
	
	@JsonBackReference
	@OneToMany(mappedBy = "nastavnik", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<PredajePredmet> predajePredmet = new ArrayList<>();;
	
	@JsonBackReference
	@OneToMany(mappedBy = "predavac", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<PredajeOdeljenju> predajeOdeljenju = new ArrayList<>();;
	
	@JsonBackReference
	@OneToMany(mappedBy = "profesor", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<PredajeUceniku> djaci = new ArrayList<>();
	
	@JsonBackReference
	@OneToMany(mappedBy = "ocenjivac", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	private List<OcenaEntity> ocene = new ArrayList<>();

	public NastavnikEntity() {
		super();
	}

	public NastavnikEntity(
			@NotNull(message = "Korisničko ime must not be empty") @Size(min = 3, max = 15, message = "Korisničko ime mora imati između {min} i {max} znakova") String korisnickoIme,
			@NotNull(message = "Lozinka must not be empty") @Size(min = 3, max = 50, message = "Lozinka mora imati između {min} i {max} znakova") String lozinka,
			OdeljenjeEntity odeljenje, List<PredajePredmet> predajePredmet, List<PredajeOdeljenju> predajeOdeljenju,
			List<PredajeUceniku> djaci, List<OcenaEntity> ocene) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.odeljenje = odeljenje;
		this.predajePredmet = predajePredmet;
		this.predajeOdeljenju = predajeOdeljenju;
		this.djaci = djaci;
		this.ocene = ocene;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public OdeljenjeEntity getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(OdeljenjeEntity odeljenje) {
		this.odeljenje = odeljenje;
	}

	public List<PredajePredmet> getPredajePredmet() {
		return predajePredmet;
	}

	public void setPredajePredmet(List<PredajePredmet> predajePredmet) {
		this.predajePredmet = predajePredmet;
	}

	public List<PredajeOdeljenju> getPredajeOdeljenju() {
		return predajeOdeljenju;
	}

	public void setPredajeOdeljenju(List<PredajeOdeljenju> predajeOdeljenju) {
		this.predajeOdeljenju = predajeOdeljenju;
	}

	public List<PredajeUceniku> getDjaci() {
		return djaci;
	}

	public void setDjaci(List<PredajeUceniku> djaci) {
		this.djaci = djaci;
	}

	public List<OcenaEntity> getOcene() {
		return ocene;
	}

	public void setOcene(List<OcenaEntity> ocene) {
		this.ocene = ocene;
	}

	
}
