package com.surpressmusic.store.services;

import com.surpressmusic.store.model.product.Album;
import com.surpressmusic.store.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
   @Autowired
   private AlbumRepository albumRepo;

   public List<Album> getAll() {
      return albumRepo.findAll();
   }

   public Album getByTitle(String title) {
      Optional<Album> foundAlbum = Optional.ofNullable(albumRepo.findByTitle(title));

      return foundAlbum.orElseGet(Album::new);
   }

   public List<Album> getByGenre(String genre) {
      return albumRepo.findByGenre(genre);
   }

   public List<Album> getByArtist(String artist) {
      return albumRepo.findByArtist(artist);
   }

}
