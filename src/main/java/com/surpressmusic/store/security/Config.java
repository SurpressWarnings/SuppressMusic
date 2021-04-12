package com.surpressmusic.store.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.surpressmusic.store.repositories.UserRepository;

@Configuration
public class Config{
	
	@Autowired
	UserRepository userRepo;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(4);
	}
}
