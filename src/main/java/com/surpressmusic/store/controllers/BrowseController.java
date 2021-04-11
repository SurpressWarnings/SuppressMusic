package com.surpressmusic.store.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
   public ModelAndView browser(Model model) {
      List<Genre> genres = genreService.getAll();
      List<Artist> artists = artistService.getAllArtists();
      List<Song> songs = songService.getAllSortedSongs();

      ModelAndView mav = new ModelAndView("browse");

      mav.addObject("genres", genres);
      mav.addObject("artists", artists);
      mav.addObject("songs", songs);
      return mav;
   }

   @GetMapping("/browse/genre")
   public ModelAndView browseGenres(@RequestParam Integer id,
                              Model model) {
      Genre genre = genreService.getById(id);
      List<Song> songs = songService.getSortedSongsByGenre(genre);
      ModelAndView mav = new ModelAndView("by_genre");
      mav.addObject("songs", songs);
      return mav;
   }

   @PostMapping("/browseByArtist")
   public String browseArtists(@RequestParam String name, Model model) {
      Artist artist = artistService.getArtistByName(name);
      List<Song> songs = songService.getSortedSongsByArtist(artist.getName());
      model.addAttribute("songs", songs);
      return "by_artist";
   }

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