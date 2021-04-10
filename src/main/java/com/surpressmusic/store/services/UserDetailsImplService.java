package com.surpressmusic.store.services;

import com.surpressmusic.store.entity.user.UserDetailsImpl;
import com.surpressmusic.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.surpressmusic.store.entity.user.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsImplService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User "
					+ username + " was not found in the database");
		}

		String role = user.getRole().getRoleType();

		List<GrantedAuthority> authList = new ArrayList<>();
		GrantedAuthority authority = new SimpleGrantedAuthority(role);
		authList.add(authority);

		return new UserDetailsImpl(user, authList);
	}
}