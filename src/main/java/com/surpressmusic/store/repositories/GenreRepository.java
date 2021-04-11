package com.surpressmusic.store.repositories;

import com.surpressmusic.store.entity.products.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
   List<Genre> findAll();
   Genre findGenreById(Integer id);
   Genre findGenreByGenreType(String type);}
