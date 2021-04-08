package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
   List<Artist> findAll();
   Optional<Artist> findById(Integer id);
}
