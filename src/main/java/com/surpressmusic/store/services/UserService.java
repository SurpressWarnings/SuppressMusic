package com.surpressmusic.store.services;

import com.surpressmusic.store.exceptions.UserNotFoundException;
import com.surpressmusic.store.model.User;
import com.surpressmusic.store.repositories.RoleRepository;
import com.surpressmusic.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

   @Autowired
   private UserRepository userRepo;

   @Autowired
   private RoleRepository roleRepo;

   public List<User> getAllUsers() {
      return userRepo.findAll();
   }

   public User getUserByUsername(String username) throws UserNotFoundException {
      Optional<User> foundUser = Optional.ofNullable(userRepo.findByUsername(username));

      return foundUser.orElseGet(User::new);
   }

   public void saveUser(User user) {
//      user.setPassword(encoder.encode(user.getPassword()));
//      Set<Role> roles = new HashSet<>();
//      roles.add(roleRepo.findByRole("USER"));
//      user.setRoles(roles);
      userRepo.save(user);
   }
}
