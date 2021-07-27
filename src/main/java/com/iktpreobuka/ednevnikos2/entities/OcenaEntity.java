package com.iktpreobuka.ednevnikos2.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OcenaEntity {

	//@NotBlank(nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column(name = "OCENA")
	@NotNull(message = "Morate uneti ocenu")
	@Min(value = 1, message = "Najmanja ocena je 1")
	@Max(value = 5, message = "Najveća ocena je 5")
	private Integer ocena;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn	(name = "kurs")
	@NotNull(message = "Učenik može dobiti ocenu samo iz određenog predmeta")
	private PredmetEntity kurs; 
	
	@Column
	@JsonFormat(
			shape = JsonFormat.Shape.STRING,
			pattern = "dd-MM-yyyy")
	private Date datumOcene;
	
	@JoinColumn(name = "ocenjivac")
	@NotNull(message = "Ocenu može uneti samo odgovarajući nastavnik.")
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private NastavnikEntity ocenjivac;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn	(name = "ucenik")
	private UcenikEntity ucenik;
	
	public OcenaEntity() {
		super();
	}

	public OcenaEntity(Integer id,
			@NotNull(message = "Morate uneti ocenu") @Min(value = 1, message = "Najmanja ocena je 1") @Max(value = 5, message = "Najveća ocena je 5") Integer ocena,
			@NotNull(message = "Učenik može dobiti ocenu samo iz određenog predmeta") PredmetEntity kurs,
			Date datumOcene,
			@NotNull(message = "Ocenu može uneti samo odgovarajući nastavnik.") NastavnikEntity ocenjivac,
			UcenikEntity ucenik) {
		super();
		this.id = id;
		this.ocena = ocena;
		this.kurs = kurs;
		this.datumOcene = datumOcene;
		this.ocenjivac = ocenjivac;
		this.ucenik = ucenik;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOcena() {
		return ocena;
	}

	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}

	public PredmetEntity getKurs() {
		return kurs;
	}

	public void setKurs(PredmetEntity kurs) {
		this.kurs = kurs;
	}

	public Date getDatumOcene() {
		return datumOcene;
	}

	public void setDatumOcene(Date datumOcene) {
		this.datumOcene = datumOcene;
	}

	public NastavnikEntity getOcenjivac() {
		return ocenjivac;
	}

	public void setOcenjivac(NastavnikEntity ocenjivac) {
		this.ocenjivac = ocenjivac;
	}

	public UcenikEntity getUcenik() {
		return ucenik;
	}

	public void setUcenik(UcenikEntity ucenik) {
		this.ucenik = ucenik;
	}

	
}
