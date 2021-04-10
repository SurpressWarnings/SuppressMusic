package com.surpressmusic.store.services;

import com.surpressmusic.store.entity.user.UserDetailsImpl;
import com.surpressmusic.store.repositories.UserDetailsImplRepository;
import com.surpressmusic.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.surpressmusic.store.entity.user.User;

@Service
public class UserDetailsImplService implements UserDetailsService{

	@Autowired
	private UserDetailsImplRepository detailsRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User "
					+ username + " was not found in the database");
		}

		return user.getUserDetails();
	}

	public void saveDetails(UserDetailsImpl details) {
		detailsRepo.save(details);
	}

	public void saveDetails(User user) {
		UserDetailsImpl userDetails = new UserDetailsImpl(user);
		detailsRepo.save(userDetails);
	}
}