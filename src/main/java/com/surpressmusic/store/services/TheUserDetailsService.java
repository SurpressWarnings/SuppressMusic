//package com.surpressmusic.store.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//import com.surpressmusic.store.model.TheUserDetails;
//import com.surpressmusic.store.model.User;
//import com.surpressmusic.store.repositories.UserRepository;
//
//@Service
//public class TheUserDetailsService implements UserDetailsService{
//
//	@Autowired
//	UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
//
//		user.orElseThrow(() -> new UsernameNotFoundException("User Not Found: " + username));
//
//		return user.map(TheUserDetails::new).get();
//	}
//}