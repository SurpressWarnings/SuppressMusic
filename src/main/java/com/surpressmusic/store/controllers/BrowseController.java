package com.surpressmusic.store.controllers;

import com.surpressmusic.store.model.product.*;
import com.surpressmusic.store.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
      List<Album> albums = albumService.getAll();
      List<Format> formats = formatService.getAllFormats();

      model.addAttribute("genres", genres);
      model.addAttribute("artists", artists);
      model.addAttribute("albums", albums);
      model.addAttribute("formats", formats);
      model.addAttribute("songs", songs);
      return "browse";
   }

   @GetMapping("/browse/genre")
   public String browseGenres(@RequestParam String id, Model model) {
      List<Song> songs = songService.getSongsByGenre(Integer.parseInt(id));
      model.addAttribute("songs", songs);
      model.addAttribute("filter", "By Genre");
      return "browse_results";
   }

   @GetMapping("/browse/artist")
   public String browseArtists(@RequestParam String id, Model model) {
      Artist artist = artistService.getArtistById(Integer.parseInt(id)).get();
      List<Song> songs = songService.getSongsByArtist(artist.getId());
      model.addAttribute("songs", songs);
      model.addAttribute("filter", "By Artist");
      return "browse_results";
   }

   @GetMapping("/browse/album")
   public String browseAlbums(@RequestParam String id, Model model) {
      List<Song> songs = songService.getSongsByAlbum(Integer.parseInt(id));
      model.addAttribute("songs", songs);
      model.addAttribute("filter", "By Album");
      return "browse_results";
   }

   @GetMapping("/browse/format")
   public String browseByFormat(@RequestParam String id, Model model) {
      List<Song> songs = songService.getSongsByFormat(Integer.parseInt(id));
      model.addAttribute("songs", songs);
      model.addAttribute("filter", "By Format");
      return "browse_results";
   }
}