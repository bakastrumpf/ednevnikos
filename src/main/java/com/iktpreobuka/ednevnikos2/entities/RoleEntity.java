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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "role")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class RoleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uloga_id")
	private Integer id;
	
	@Column(name = "uloga_ime")
	private String ime;
	
	@JsonIgnore
	@OneToMany(mappedBy = "uloga", fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
	private List<UserEntity> users = new ArrayList<>();

	public RoleEntity() {
	//	super();
	}

	public RoleEntity(Integer id, String ime, List<UserEntity> users) {
		super();
		this.id = id;
		this.ime = ime;
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	
	

}
