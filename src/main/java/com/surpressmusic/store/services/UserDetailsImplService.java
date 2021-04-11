package com.surpressmusic.store.services;

import com.surpressmusic.store.entity.user.Role;
import com.surpressmusic.store.entity.user.UserDetailsImpl;
import com.surpressmusic.store.repositories.UserDetailsImplRepository;
import com.surpressmusic.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.surpressmusic.store.entity.user.User;

import java.util.*;

@Service
public class UserDetailsImplService implements UserDetailsService{

	@Autowired
	private UserDetailsImplRepository detailsRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User "
					+ username + " was not found in the database");
		}

		List<GrantedAuthority> auths = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getRoleType()));

		UserDetailsImpl userDetails = new UserDetailsImpl(user, auths);

		updateDetails(userDetails);

		return userDetails;
	}

	public void updateDetails(UserDetailsImpl details) {
		detailsRepo.save(details);
	}

//	public void saveDetails(User user) {
//		UserDetailsImpl userDetails = new UserDetailsImpl(user);
//		detailsRepo.save(userDetails);
//	}
}