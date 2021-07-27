package com.iktpreobuka.ednevnikos2.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RoditeljEntity extends UserEntity {
	
	@Column(nullable = false)
	@NotNull(message = "Email must not be empty")
	private String email;

	@OneToMany(mappedBy = "roditelj", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JsonBackReference
	private List<UcenikEntity> deca;

	public RoditeljEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoditeljEntity(@NotNull(message = "Email must not be empty") String email, List<UcenikEntity> deca) {
		super();
		this.email = email;
		this.deca = deca;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<UcenikEntity> getDeca() {
		return deca;
	}

	public void setDeca(List<UcenikEntity> deca) {
		this.deca = deca;
	}

	
	

}
