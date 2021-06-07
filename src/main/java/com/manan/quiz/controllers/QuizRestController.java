package com.manan.quiz.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manan.quiz.dto.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin
public class QuizRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(QuizRestController.class);

	@RequestMapping("/startTest/{your name}")
	public String findReservation(@PathVariable("your name") String name) {

		String token = getToken(name);
		User user = new User();
		user.setUserName(name);
		user.setToken(token);
		LOGGER.info("Inside findReservation() for user: " + name);

		return token;

	}

	private String getToken(String name) {

		String key = "test";
		String token = Jwts.builder().setId("quiz").setSubject(name).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 700000))
				.signWith(SignatureAlgorithm.HS512, key.getBytes()).compact();

		return "Bearer " + token;
	}

}
