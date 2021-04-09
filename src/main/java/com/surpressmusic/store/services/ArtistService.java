package com.surpressmusic.store.services;

import com.surpressmusic.store.entity.products.Artist;
import com.surpressmusic.store.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

   @Autowired
   private ArtistRepository artistRepo;

   public List<Artist> getAllArtists() { return artistRepo.findAll(); }

   public Optional<Artist> getArtistById(Integer id) { return artistRepo.findById(id); }

   public Artist getArtistByName(String query) {
      return artistRepo.findByName(query);
   }
}
