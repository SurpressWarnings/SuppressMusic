package com.surpressmusic.store.services;

import com.surpressmusic.store.entity.products.Genre;
import com.surpressmusic.store.entity.products.Song;
import com.surpressmusic.store.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

   @Autowired
   private SongRepository songRepo;

   public List<Song> getAllSongs() {
      return songRepo.findAll();
   }

   public List<Song> getAllSortedSongs() { return songRepo.findAll(Sort.by(Sort.Direction.ASC, "songTitle")); }

   public Song getSongByTitle(String title) {
      return songRepo.findBySongTitle(title);
   }

   public List<Song> getSortedSongsByArtist(String artist) {
      return songRepo.findByArtistOrderBySongTitle(artist);
   }

   public List<Song> getSortedSongsByGenre(Genre genre) {
      return songRepo.findByGenreOrderBySongTitle(genre);
   }

   public List<Song> getSortedSongsByFormat(String format) {
      return songRepo.findByFormatOrderBySongTitle(format);
   }

   public List<Song> getSongsByPriceRange(String min, String max) throws NumberFormatException {
      Integer minInt = Integer.parseInt(min);
      Integer maxInt = Integer.parseInt(max);

      return songRepo.findByPrice(minInt, maxInt);
   }
}
