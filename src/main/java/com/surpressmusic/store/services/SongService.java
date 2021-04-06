package com.surpressmusic.store.services;

import com.surpressmusic.store.model.Song;
import com.surpressmusic.store.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

   @Autowired
   private SongRepository songRepo;

   public List<Song> getAllSongs() {
      return songRepo.findAll();
   }

   public Song getSongByTitle(String title) {
      return songRepo.findBySongTitle(title);
   }

   public List<Song> getSongsByArtist(String artist) {
      return songRepo.findByArtist(artist);
   }

   public List<Song> getSongsByGenre(String genre) {
      return songRepo.findByGenre(genre);
   }

   public List<Song> getSongsByFormat(String format) {
      return songRepo.findByFormat(format);
   }

   public List<Song> getSongsByPriceRange(String min, String max) throws NumberFormatException {
      Integer minInt = Integer.parseInt(min);
      Integer maxInt = Integer.parseInt(max);

      return songRepo.findByPrice(minInt, maxInt);
   }
}
