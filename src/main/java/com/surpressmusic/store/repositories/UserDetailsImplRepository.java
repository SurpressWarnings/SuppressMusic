package com.surpressmusic.store.repositories;

import com.surpressmusic.store.entity.user.UserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsImplRepository extends JpaRepository<UserDetailsImpl, Integer> {
   List<UserDetailsImpl> findAll();
}
