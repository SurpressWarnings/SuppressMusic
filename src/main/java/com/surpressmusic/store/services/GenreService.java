package com.surpressmusic.store.services;

import com.surpressmusic.store.entity.products.Genre;
import com.surpressmusic.store.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

   @Autowired
   private GenreRepository genreRepo;

   public List<Genre> getAll() {
      return genreRepo.findAll();
   }

   public Genre getById(Integer id) {
      return genreRepo.findGenreById(id);
   }
}
