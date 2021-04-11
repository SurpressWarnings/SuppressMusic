package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.product.Format;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormatRepository extends JpaRepository<Format, Integer> {
   public List<Format> findAll();

   @Query(value = "SELECT f from Format f WHERE f.formatType LIKE %:search ORDER BY f.formatType")
   public List<Format> findAllByFormatTypeLike(String search);
}
