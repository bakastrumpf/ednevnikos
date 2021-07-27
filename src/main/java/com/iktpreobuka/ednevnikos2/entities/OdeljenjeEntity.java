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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OdeljenjeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	
	private Integer razr;
	private Integer odelj;
	
	@JsonBackReference
	@OneToMany(mappedBy = "odeljenje", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	protected List<UcenikEntity> ucenici = new ArrayList<>();

	@JsonBackReference
	@OneToMany(mappedBy = "razred", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private List <PredajeOdeljenju> profesori = new ArrayList<>();

	public OdeljenjeEntity() {
		super();
	}

	public OdeljenjeEntity(Integer id, Integer razr, Integer odelj, List<UcenikEntity> ucenici,
			List<PredajeOdeljenju> profesori) {
		super();
		this.id = id;
		this.razr = razr;
		this.odelj = odelj;
		this.ucenici = ucenici;
		this.profesori = profesori;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRazr() {
		return razr;
	}

	public void setRazr(Integer razr) {
		this.razr = razr;
	}

	public Integer getOdelj() {
		return odelj;
	}

	public void setOdelj(Integer odelj) {
		this.odelj = odelj;
	}

	public List<UcenikEntity> getUcenici() {
		return ucenici;
	}

	public void setUcenici(List<UcenikEntity> ucenici) {
		this.ucenici = ucenici;
	}

	public List<PredajeOdeljenju> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<PredajeOdeljenju> profesori) {
		this.profesori = profesori;
	}

	
}
