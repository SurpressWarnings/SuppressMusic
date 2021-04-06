package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
   Role findByRole(String role);
}
