package com.iktpreobuka.ednevnikos2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.ednevnikos2.security.Pogledi;

@Entity
@Table(name = "korisnici")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer id;
	
	@Column
	@NotNull(message = "Prezime must not be empty")
	@Size(min = 2, max = 15, message = "Prezime mora imati između {min} i {max} znakova")
	@JsonView(Pogledi.Public.class)
	@JsonProperty("PREZIME")
	private String prezime;
	
	@Column
	@NotNull(message = "Ime must not be empty")
	@Size(min = 2, max = 15, message = "Ime mora imati između {min} i {max} znakova")
	@JsonView(Pogledi.Public.class)
	@JsonProperty("IME")
	private String ime;
	
	@Column
	//@Column(nullable = false)
	@JsonView(Pogledi.Admin.class)
	protected UserRole uloga;
	
	@JsonView(Pogledi.Admin.class)
	@JsonProperty("IMEJL ADRESA")
	@Column
	@NotNull(message = "Email must not be empty")
	private String mejl;
	
	public UserEntity() {
		super();
	}

	public UserEntity(Integer id,
			@NotNull(message = "Prezime must not be empty") @Size(min = 2, max = 15, message = "Prezime mora imati između {min} i {max} znakova") String prezime,
			@NotNull(message = "Ime must not be empty") @Size(min = 2, max = 15, message = "Ime mora imati između {min} i {max} znakova") String ime,
			UserRole uloga, @NotNull(message = "Email must not be empty") String mejl) {
		super();
		this.id = id;
		this.prezime = prezime;
		this.ime = ime;
		this.uloga = uloga;
		this.mejl = mejl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public UserRole getUloga() {
		return uloga;
	}

	public void setUloga(UserRole uloga) {
		this.uloga = uloga;
	}

	public String getMejl() {
		return mejl;
	}

	public void setMejl(String mejl) {
		this.mejl = mejl;
	}

	

}