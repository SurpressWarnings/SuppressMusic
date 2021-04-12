package com.surpressmusic.store.security;

import com.surpressmusic.store.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.surpressmusic.store.repositories.UserRepository;
import com.surpressmusic.store.services.UserService;

@Component
public class AdminSetup implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub	
		if(!userServ.existsByUserName("admin"))
		{
			User admin = new User("admin", "admin");
			admin.setRoles("ROLE_ADMIN");
			admin.setPassword(passwordEncoder.encode(admin.getPassword()));
			userRepo.save(admin);
		}
	}

}
