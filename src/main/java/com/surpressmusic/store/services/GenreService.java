package com.surpressmusic.store.services;

import com.surpressmusic.store.repositories.GenreRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

   @Repository
   private GenreRepository genreRepo;
}
