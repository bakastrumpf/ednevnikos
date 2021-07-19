package com.iktpreobuka.ednevnikos2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.iktpreobuka.ednevnikos2.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{

}
