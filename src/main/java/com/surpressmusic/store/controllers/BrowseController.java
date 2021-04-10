package com.surpressmusic.store.controllers;

import com.surpressmusic.store.entity.products.Album;
import com.surpressmusic.store.entity.products.Artist;
import com.surpressmusic.store.entity.products.Genre;
import com.surpressmusic.store.entity.products.Song;
import com.surpressmusic.store.exceptions.MusicNotFoundException;
import com.surpressmusic.store.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BrowseController {

   @Autowired
   private GenreService genreService;

   @Autowired
   private SongService songService;

   @Autowired
   private AlbumService albumService;

   @Autowired
   private ArtistService artistService;

   @Autowired
   private FormatService formatService;

   @GetMapping("/browse")
   public String showGenres(Model model) {
      List<Genre> genres = genreService.getAll();
      List<Artist> artists = artistService.getAllArtists();
      List<Song> songs = songService.getAllSortedSongs();
      model.addAttribute("genres", genres);
      model.addAttribute("artists", artists);
      model.addAttribute("songs", songs);
      return "browse";
   }

   @PostMapping("/browseByGenre")
   public String browseGenres(@RequestParam String strId, Model model) {

      Integer id = Integer.parseInt(strId);
      Genre genre = new Genre();

      if (genreService.getById(id).isPresent()) {
         genre = genreService.getById(id).get();
      } else {
         throw new MusicNotFoundException("Genre not found");
      }

      List<Song> songs = songService.getSortedSongsByGenre(genre);
      model.addAttribute("songs", songs);
      return "by_genre";
   }

//   @PostMapping("/browseByArtist")
//   public String browseArtists(@RequestParam String id, Model model) {
//
//      Artist artist = artistService.getArtistById(Integer.parseInt(id)).get();
//      List<Song> songs = songService.getSortedSongsByArtist((artist.getName()));
//      model.addAttribute("songs", songs);
//      return "by_artist";
//   }

   @PostMapping("/browseByAlbum")
   public String browseAlbums(Model model) {
      List<Album> albums = albumService.getAll();
      model.addAttribute("albums", albums);
      return "by_artist";
   }

//   @PostMapping("/browseByFormat")
//   public String browseByFormat() {
//
//   }
}