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
public class PredajeUceniku {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@JsonManagedReference
	@JoinColumn(name = "profesor")
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private NastavnikEntity profesor;
	
	@JsonManagedReference
	@JoinColumn(name = "djak")
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	private UcenikEntity djak;

	
	public PredajeUceniku() {
		super();
	}


	public PredajeUceniku(Integer id, NastavnikEntity profesor, UcenikEntity djak) {
		super();
		this.id = id;
		this.profesor = profesor;
		this.djak = djak;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public NastavnikEntity getProfesor() {
		return profesor;
	}


	public void setProfesor(NastavnikEntity profesor) {
		this.profesor = profesor;
	}


	public UcenikEntity getDjak() {
		return djak;
	}


	public void setDjak(UcenikEntity djak) {
		this.djak = djak;
	}

	
	
}
