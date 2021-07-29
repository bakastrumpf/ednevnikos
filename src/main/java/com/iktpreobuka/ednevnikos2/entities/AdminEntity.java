package com.iktpreobuka.ednevnikos2.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class AdminEntity extends UserEntity {

	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminEntity(Integer id, @NotNull(message = "Email must not be empty") String mejl,
			@NotNull(message = "Lozinka must not be empty") @Size(min = 3, max = 50, message = "Lozinka mora imati između {min} i {max} znakova") String lozinka,
			RoleEntity uloga) {
		super(id, mejl, lozinka, uloga);
		// TODO Auto-generated constructor stub
	}

	



}