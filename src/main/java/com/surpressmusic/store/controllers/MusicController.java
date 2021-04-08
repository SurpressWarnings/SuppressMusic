package com.surpressmusic.store.controllers;

import com.surpressmusic.store.model.Genre;
import com.surpressmusic.store.model.Song;
import com.surpressmusic.store.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MusicController {

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

   private
   @GetMapping("/browse")
   public String showGenres(Model model) {
      List<Genre> genres = genreService.getAll();
      model.addAttribute("genres", genres);

      return "browse";
   }

   @PostMapping("/browseByGenre")
   public String browseGenres(@RequestParam String id, Model model) {
      Genre genre = genreService.getById(Integer.parseInt(id)).get();
      List<Song> songs = songService.getSongsByGenre(genre);
      model.addAttribute("songs", songs);
      return "by_genre";
   }
}