package com.iktpreobuka.ednevnikos2.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iktpreobuka.ednevnikos2.entities.UserEntity;

@Component
public class KorisnikCustomValidator implements Validator{
		
		@Override
		public boolean supports(Class<?> clazz) {
			return UserEntity.class.equals(clazz);
		}

		@Override
		public void validate(Object target, Errors errors) {
			UserEntity user = (UserEntity) target;
			if(! user.getMejl().equals(user.getMejl())) {
				errors.reject("400", "Duplicate user! Please, change email address to create a new user.");
			}
		}
}