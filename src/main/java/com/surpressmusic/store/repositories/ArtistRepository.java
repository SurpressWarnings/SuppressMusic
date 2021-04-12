package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.product.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
   List<Artist> findAll();
   Optional<Artist> findById(Integer id);
   Artist findByName(String query);

   @Query(value = "SELECT a from Artist a WHERE a.name LIKE %:search ORDER BY a.name")
   List<Artist> findAllByNameLike(String search);
}
