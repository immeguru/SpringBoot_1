package com.yi_college.bookmanager.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "user123";
		String encodedPassword = encoder.encode(rawPassword);
		System.out.println(encodedPassword);

	}
}
