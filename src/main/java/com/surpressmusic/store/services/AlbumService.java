package com.surpressmusic.store.services;

import com.surpressmusic.store.entity.products.Album;
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

   public Album getByTitle(String title) { //throws MusicNotFoundException {
      Optional<Album> foundAlbum = Optional.ofNullable(albumRepo.findByTitle(title));

      return foundAlbum.orElseGet(Album::new);
   }

   public List<Album> getByGenre(String genre) {
      return albumRepo.findByGenre(genre);
   }

   public List<Album> getByArtist(String artist) {
      return albumRepo.findByArtist(artist);
   }

//   public Album getBySong(String song) { //throws MusicNotFoundException {
//      Optional<Album> foundAlbum = Optional.ofNullable(albumRepo.findBySong(song));
//
//      return foundAlbum.orElseGet(Album::new);
//   }
}
