package com.iktpreobuka.ednevnikos2.entities;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PredajeOdeljenju {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	
	@JoinColumn (name = "predavac")
	@JsonManagedReference
	@ManyToOne (fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private NastavnikEntity predavac;
	
	@JoinColumn (name = "razred")
	@JsonManagedReference
	@ManyToOne (fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private OdeljenjeEntity razred;
	
	public PredajeOdeljenju() {
		super();
	}

	public PredajeOdeljenju(Integer id, NastavnikEntity predavac, OdeljenjeEntity razred) {
		super();
		this.id = id;
		this.predavac = predavac;
		this.razred = razred;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public NastavnikEntity getPredavac() {
		return predavac;
	}

	public void setPredavac(NastavnikEntity predavac) {
		this.predavac = predavac;
	}

	public OdeljenjeEntity getRazred() {
		return razred;
	}

	public void setRazred(OdeljenjeEntity razred) {
		this.razred = razred;
	}

	

}
