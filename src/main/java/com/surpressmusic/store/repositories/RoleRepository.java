package com.surpressmusic.store.repositories;

import com.surpressmusic.store.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
   Role findByRoleType(String roleType);
}
