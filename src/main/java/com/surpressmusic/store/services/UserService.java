package com.surpressmusic.store.services;

import com.surpressmusic.store.entity.user.Role;
import com.surpressmusic.store.exceptions.UserNotFoundException;
import com.surpressmusic.store.entity.user.User;
import com.surpressmusic.store.repositories.RoleRepository;
import com.surpressmusic.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

   @Autowired
   private UserRepository userRepo;

   @Autowired
   private RoleRepository roleRepo;

   @Autowired
   private UserDetailsImplService detailsService;

   @Autowired
   private BCryptPasswordEncoder encoder;

   public List<User> getAllUsers() {
      return userRepo.findAll();
   }

   public User getUserByUsername(String username) throws UserNotFoundException {
      Optional<User> foundUser = Optional.ofNullable(userRepo.findByUsername(username));

      return foundUser.orElseGet(User::new);
   }

   public void saveUser(User user) {
      user.setPassword(encoder.encode(user.getPassword()));
      Role role = roleRepo.findByRoleType("USER");
      user.setRole(role);
      userRepo.save(user);

      detailsService.saveDetails(user);
   }
}