package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.product.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
   List<Genre> findAll();
   Optional<Genre> findById(Integer id);

   @Query(value = "SELECT g from Genre g WHERE g.genreType LIKE %:search% ORDER BY g.genreType")
   List<Genre> findAllByGenreTypeLike(String search);
}
