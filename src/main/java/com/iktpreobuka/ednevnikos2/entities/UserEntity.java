package com.iktpreobuka.ednevnikos2.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "korisnici")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer id;
	
	@JsonProperty("IMEJL ADRESA")
	@Column
	@NotNull(message = "Email must not be empty")
	private String mejl;
	
	@JsonIgnore
	@Column
	@NotNull(message = "Lozinka must not be empty")
	@Size(min = 3, max = 50, message = "Lozinka mora imati između {min} i {max} znakova")
	@JsonProperty("LOZINKA")
	private String lozinka;
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "uloga")
	//@Column(nullable = false)
	protected RoleEntity uloga;

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(Integer id, 
			@NotNull(message = "Email must not be empty") String mejl,
			@NotNull(message = "Lozinka must not be empty") 
				@Size(min = 3, max = 50, message = "Lozinka mora imati između {min} i {max} znakova") 
				String lozinka,
			RoleEntity uloga) {
		super();
		this.id = id;
		this.mejl = mejl;
		this.lozinka = lozinka;
		this.uloga = uloga;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMejl() {
		return mejl;
	}

	public void setMejl(String mejl) {
		this.mejl = mejl;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public RoleEntity getUloga() {
		return uloga;
	}

	public void setUloga(RoleEntity uloga) {
		this.uloga = uloga;
	}


}