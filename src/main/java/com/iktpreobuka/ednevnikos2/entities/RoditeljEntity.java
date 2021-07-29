package com.iktpreobuka.ednevnikos2.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RoditeljEntity extends UserEntity {
	
	@Column
	@NotNull(message = "Prezime must not be empty")
	@Size(min = 2, max = 15, message = "Prezime mora imati između {min} i {max} znakova")
	@JsonProperty("PREZIME")
	private String prezime;
	
	@Column
	@NotNull(message = "Ime must not be empty")
	@Size(min = 2, max = 15, message = "Ime mora imati između {min} i {max} znakova")
	@JsonProperty("IME")
	private String ime;

	@OneToMany(mappedBy = "roditelj", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JsonBackReference
	private List<UcenikEntity> deca;

	public RoditeljEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoditeljEntity(Integer id, @NotNull(message = "Email must not be empty") String mejl,
			@NotNull(message = "Lozinka must not be empty") @Size(min = 3, max = 50, message = "Lozinka mora imati između {min} i {max} znakova") String lozinka,
			RoleEntity uloga) {
		super(id, mejl, lozinka, uloga);
		// TODO Auto-generated constructor stub
	}

	public RoditeljEntity(
			@NotNull(message = "Prezime must not be empty") @Size(min = 2, max = 15, message = "Prezime mora imati između {min} i {max} znakova") String prezime,
			@NotNull(message = "Ime must not be empty") @Size(min = 2, max = 15, message = "Ime mora imati između {min} i {max} znakova") String ime,
			List<UcenikEntity> deca) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.deca = deca;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public List<UcenikEntity> getDeca() {
		return deca;
	}

	public void setDeca(List<UcenikEntity> deca) {
		this.deca = deca;
	}


}
