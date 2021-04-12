package com.surpressmusic.store.services;

import com.surpressmusic.store.model.product.*;
import com.surpressmusic.store.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

   @Autowired
   private SongRepository songRepo;

   @Autowired
   private ArtistRepository artistRepo;

   @Autowired
   private AlbumRepository albumRepo;

   @Autowired
   private GenreRepository genreRepo;

   @Autowired
   private FormatRepository formatRepo;

   public List<Song> searchSongs(String query) {
      return songRepo.findAllBySongTitleLike(query);
   }

   public List<Album> searchAlbums(String query) {
      return  albumRepo.findAllByTitleLike(query);
   }

   public List<Artist> searchArtists(String query) {
      return artistRepo.findAllByNameLike(query);
   }

   public List<Genre> searchGenres(String query) {
      return genreRepo.findAllByGenreTypeLike(query);
   }

   public List<Format> searchFormats(String query) {

      return formatRepo.findAllByFormatTypeLike(query);
   }
}
