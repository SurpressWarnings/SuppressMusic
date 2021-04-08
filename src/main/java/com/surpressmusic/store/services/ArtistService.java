package com.surpressmusic.store.services;

import com.surpressmusic.store.model.Artist;
import com.surpressmusic.store.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

   @Autowired
   private ArtistRepository artistRepo;

   public List<Artist> getAllArtists() { return artistRepo.findAll(); }
}
