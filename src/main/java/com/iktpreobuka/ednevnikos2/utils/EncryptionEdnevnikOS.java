package com.iktpreobuka.ednevnikos2.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptionEdnevnikOS {

	public static String getPassEncoded(String pass) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(pass);
	}

	public static boolean validatePassword(String pass, String encodedPass) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(pass, encodedPass);
	}
	
	public static void main(String[] args) {
		System.out.println(getPassEncoded("p4ssEnc13"));
	}

}
