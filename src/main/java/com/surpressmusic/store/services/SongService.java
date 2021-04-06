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

//   public List<Song> getSongByTitle(String title) {
//   }
//
//   public List<Song> getSongsBy
}
