package com.iktpreobuka.ednevnikos2.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name = "ucenici")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UcenikEntity extends UserEntity {
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn	(name = "odeljenje")
	private OdeljenjeEntity odeljenje;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn	(name = "roditelj")
	private RoditeljEntity roditelj;
	
	@JsonBackReference
	@OneToMany(mappedBy = "ucenik", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	protected List<OcenaEntity> ocene;
	
	@JsonBackReference
	@OneToMany(mappedBy = "djak", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	protected List<PredajeUceniku> profesori;

	public UcenikEntity() {
		super();
	}

	public UcenikEntity(OdeljenjeEntity odeljenje, RoditeljEntity roditelj, List<OcenaEntity> ocene,
			List<PredajeUceniku> profesori) {
		super();
		this.odeljenje = odeljenje;
		this.roditelj = roditelj;
		this.ocene = ocene;
		this.profesori = profesori;
	}

	public OdeljenjeEntity getOdeljenje() {
		return odeljenje;
	}

	public void setOdeljenje(OdeljenjeEntity odeljenje) {
		this.odeljenje = odeljenje;
	}

	public RoditeljEntity getRoditelj() {
		return roditelj;
	}

	public void setRoditelj(RoditeljEntity roditelj) {
		this.roditelj = roditelj;
	}

	public List<OcenaEntity> getOcene() {
		return ocene;
	}

	public void setOcene(List<OcenaEntity> ocene) {
		this.ocene = ocene;
	}

	public List<PredajeUceniku> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<PredajeUceniku> profesori) {
		this.profesori = profesori;
	}

	

}
