package com.iktpreobuka.ednevnikos2.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iktpreobuka.ednevnikos2.entities.PredmetEntity;

@Component
public class SubjectCustomValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PredmetEntity.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PredmetEntity noviPredmet = (PredmetEntity) target;
		if (! noviPredmet.getNazivPredmeta().equals(noviPredmet.getNazivPredmeta())) {
			errors.reject("400", "Predmet already exists! Please, rename the Predmet.");
		}
	}
}