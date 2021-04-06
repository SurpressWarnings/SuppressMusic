package com.surpressmusic.store.repositories;

import com.surpressmusic.store.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer> {
   List<Genre> findAll();
}
