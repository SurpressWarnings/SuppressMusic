package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
   User findByUsername(String username);
   List<User> findAll();
}
