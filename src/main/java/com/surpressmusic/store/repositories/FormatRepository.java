package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.Format;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormatRepository extends JpaRepository<Format, Integer> {
   public List<Format> findAll();
}
