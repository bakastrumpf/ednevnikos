package com.iktpreobuka.ednevnikos2.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "predmeti")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PredmetEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column
	@NotNull (message = "Morate uneti naziv predmeta!")
	@Size(min = 5, max = 25, message = "Naziv predmeta mora imati između {min} i {max} znakova")
	private String nazivPredmeta;
	
	@Column
	@NotNull (message = "Morate uneti nedeljni fond časova!")
	private Integer nedFondCasova;
	
	@JsonBackReference
	@OneToMany (mappedBy = "predmet", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	protected List<PredajePredmet> nastavnici = new ArrayList<>();
	
	@JsonBackReference
	@OneToMany (mappedBy = "kurs", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	protected List<OcenaEntity> ocene = new ArrayList<>();
	
	public PredmetEntity() {
		super();
	}

	public PredmetEntity(Integer id,
			@NotNull(message = "Morate uneti naziv predmeta!") @Size(min = 5, max = 25, message = "Naziv predmeta mora imati između {min} i {max} znakova") String nazivPredmeta,
			@NotNull(message = "Morate uneti nedeljni fond časova!") Integer nedFondCasova,
			List<PredajePredmet> nastavnici, List<OcenaEntity> ocene) {
		super();
		this.id = id;
		this.nazivPredmeta = nazivPredmeta;
		this.nedFondCasova = nedFondCasova;
		this.nastavnici = nastavnici;
		this.ocene = ocene;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public Integer getNedFondCasova() {
		return nedFondCasova;
	}

	public void setNedFondCasova(Integer nedFondCasova) {
		this.nedFondCasova = nedFondCasova;
	}

	public List<PredajePredmet> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(List<PredajePredmet> nastavnici) {
		this.nastavnici = nastavnici;
	}

	public List<OcenaEntity> getOcene() {
		return ocene;
	}

	public void setOcene(List<OcenaEntity> ocene) {
		this.ocene = ocene;
	}

	

}
