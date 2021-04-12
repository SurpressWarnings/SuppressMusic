package com.surpressmusic.store.services;

import com.surpressmusic.store.exceptions.UserNotFoundException;
import com.surpressmusic.store.model.Genre;
import com.surpressmusic.store.model.User;
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

   public Optional<Genre> getById(Integer id) {
      return genreRepo.findById(id); }
   
   public Genre getUserByGenreType(String genre){
	      Optional<Genre> foundGenre = genreRepo.findByGenreType(genre);

	      return foundGenre.orElseGet(Genre::new);
	   }
   
   public void updateGenre(Genre genre)
   {
	   genreRepo.save(genre);
   }
}

