package com.surpressmusic.store.services;

import com.surpressmusic.store.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

   @Autowired
   private GenreRepository genreRepo;
}
