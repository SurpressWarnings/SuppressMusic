package com.surpressmusic.store.services;

import com.surpressmusic.store.model.product.Song;
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

   public Song getSongById(Integer id) { return songRepo.findSongById(id); }

   public Song getSongByTitle(String title) {
      return songRepo.findBySongTitle(title);
   }

   public List<Song> getSongsByAlbum(Integer id) {
      return songRepo.findAllByAlbum(id);
   }

   public List<Song> getSongsByArtist(Integer id) {
      return songRepo.findAllByArtist(id);
   }

   public List<Song> getSongsByGenre(Integer id) {
      return songRepo.findAllByGenre(id);
   }

   public List<Song> getSongsByFormat(Integer id) {
      return songRepo.findAllByFormat(id);
   }

   public List<Song> getSongsByPriceRange(String min, String max) throws NumberFormatException {
      Integer minInt = Integer.parseInt(min);
      Integer maxInt = Integer.parseInt(max);

      return songRepo.findByPrice(minInt, maxInt);
   }
}
